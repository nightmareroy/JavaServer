package client.center;

import client.center.Header.HeaderType;

public final class Packet{
	public Header header;

    public byte[] body;
    
    public Packet() {
    	
    }
    
    public Packet(HeaderType headerType) {
    	this.body=new byte[0];
		this.header=new Header(body.length,headerType);
		
	}
    
    public Packet(HeaderType headerType,byte[] body) {
    	this.body=body;
		this.header=new Header(body.length,headerType);
		
	}

    @Override
    public String toString() {
        return "NettyMessage [header=" + header + "]";
    }
}
