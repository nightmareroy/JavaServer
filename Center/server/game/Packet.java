package game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.core.util.ArrayUtils;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

import common.DataUtil;
import game.Header;
import game.Header.HeaderType;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;

public class Packet{
	public Header header;

    public byte[] body;
    
    public Channel channel;
    
    public Packet(Channel channel) {
    	this.channel=channel;
    }
    
    public Packet(HeaderType headerType,Channel channel) {
    	this.body=new byte[0];
		this.header=new Header(body.length,headerType);
		this.channel=channel;
	}
    
    public Packet(HeaderType headerType,byte[] body,Channel channel) {
    	this.body=body;
		this.header=new Header(body.length,headerType);
		this.channel=channel;
	}
    
    public Packet(HeaderType headerType,String route,byte[] content,Channel channel) {
    	byte[] routeBytes=route.getBytes();
//    	byte[] routeBytesLength = DataUtil.int2bytes(routeBytes.length);
//    	byte[] body=new byte[routeBytesLength.length+routeBytes.length+content.length];
    	ByteBuf byteBuf=Unpooled.buffer();
    	byteBuf.writeBytes(DataUtil.int2bytes(routeBytes.length));
    	byteBuf.writeBytes(routeBytes);
    	byteBuf.writeBytes(content);
//    	System.arraycopy(routeBytesLength, 0, body, 0, routeBytesLength.length);
//    	System.arraycopy(routeBytes, 0, body, routeBytesLength.length, routeBytes.length);
//    	System.arraycopy(content, 0, body, routeBytesLength.length+routeBytes.length, content.length);
    	
    	
    	this.body=byteBuf.array();
		this.header=new Header(body.length,headerType);
		this.channel=channel;
	}

    @Override
    public String toString() {
        return "NettyMessage [header=" + header + "]";
    }
}
