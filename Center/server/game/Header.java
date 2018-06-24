package game;

import java.util.HashMap;
import java.util.Map;

import common.Config;

public final class Header {
	
	public enum HeaderType{
		LogicReq(0),
		LogicRes(1),
		WorkOneWay(2),
		LoginReq(3),
		LoginRes(4),
		BeatReq(5),
		BeatRes(6),
		LogoutReq(7);
		
		public byte value;
		private HeaderType(int value) {
			byte bv=(byte)value;
			this.value=bv;
		}
		
//		public int getValue() {
//			return value;
//		}
		
		public static HeaderType getHeaderType(int value) {
			for (HeaderType headerType : HeaderType.values()) {
				if(headerType.value==value) {
					return headerType;
				}
			}
			return null;
		}
		
	}
	
	public Header() {
		
	}
	
	public Header(int bodyLength,HeaderType headerType) {
		this.length=bodyLength;//(Integer.SIZE+Integer.SIZE+Long.SIZE+Byte.SIZE+bodyLength)/8;
		//this.sessionID=sessionID;
		this.type=headerType.value;
	}
	
	public static int getLengthAdjustment() {
		return (Byte.SIZE)/8;
	}
	
	public int getBodyLength() {
		return this.length-(Integer.SIZE+Integer.SIZE+Byte.SIZE)/8;
	}
	
//	public static int getInitialBytesToStrip() {
//		return (Integer.SIZE+Integer.SIZE)/8;
//	}
	
	

	public int crcCode = Config.CenterServer.Packet.crcCode;

    public int length;// 消息长度

    //public long sessionID;// 会话ID

    public byte type;// 消息类型

    //public byte priority;// 消息优先级

    
    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Header [crcCode=" + crcCode + ", length=" + length
                + ", type=" + type + "]";
    }

}