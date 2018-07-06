package serverGame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.core.util.ArrayUtils;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

import common.DataUtil;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import serverGame.Header;
import serverGame.Header.HeaderType;

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

    	ByteBuf byteBuf=Unpooled.buffer();
    	byteBuf.writeBytes(DataUtil.int2bytes(routeBytes.length));
    	byteBuf.writeBytes(routeBytes);
    	byteBuf.writeBytes(content);

    	this.body=new byte[byteBuf.readableBytes()];
    	byteBuf.getBytes(0, this.body);
		this.header=new Header(body.length,headerType);
		this.channel=channel;
	}

    @Override
    public String toString() {
        return "NettyMessage [header=" + header + "]";
    }
}
