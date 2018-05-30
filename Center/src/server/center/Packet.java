package server.center;

import server.center.Header;
import server.center.Header.HeaderType;

public final class Packet{
	public Header header;

    public byte[] body;
    
    public Packet() {
    	
    }
    
    public Packet(HeaderType headerType) {
    	this.body=new byte[0];
		this.header=new Header(body.length,0L,headerType);
		
	}
    
    public Packet(long sessionID,HeaderType headerType,byte[] body) {
    	this.body=body;
		this.header=new Header(body.length,sessionID,headerType);
		
	}

    @Override
    public String toString() {
        return "NettyMessage [header=" + header + "]";
    }
}
