package server.center;

import io.netty.channel.Channel;
import server.center.Header;
import server.center.Header.HeaderType;

public class Packet{
	public Header header;

    public byte[] body;
    
    public Channel channel;
    
    public Packet(Channel channel) {
    	this.channel=channel;
    }
    
    public Packet(HeaderType headerType,Channel channel) {
    	this.body=new byte[0];
		this.header=new Header(body.length,0L,headerType);
		this.channel=channel;
	}
    
    public Packet(long sessionID,HeaderType headerType,byte[] body,Channel channel) {
    	this.body=body;
		this.header=new Header(body.length,sessionID,headerType);
		this.channel=channel;
	}

    @Override
    public String toString() {
        return "NettyMessage [header=" + header + "]";
    }
}
