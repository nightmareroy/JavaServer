package server.login;

import server.login.Header.HeaderType;

public final class NettyMessage{
	public Header header;

    public byte[] body;
    
    public NettyMessage() {
    	
    }
    
    public NettyMessage(long sessionID,HeaderType headerType,byte[] body) {
    	this.body=body;
		this.header=new Header(body.length,sessionID,headerType);
		
	}

//    /**
//     * @return the header
//     */
//    public final Header getHeader() {
//        return header;
//    }
//
//    /**
//     * @param header the header to set
//     */
//    public final void setHeader(Header header) {
//        this.header = header;
//    }
//
//    /**
//     * @return the body
//     */
//    public final Object getBody() {
//        return body;
//    }
//
//    /**
//     * @param body the body to set
//     */
//    public final void setBody(Object body) {
//        this.body = body;
//    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "NettyMessage [header=" + header + "]";
    }
}
