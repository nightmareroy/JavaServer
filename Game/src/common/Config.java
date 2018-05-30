package common;
public class Config {
	public static final String DataCOPath = "dataCOs";
	public static class CenterServer {
		public static class Packet {
			public static final int lengthFieldOffset = 4;
			public static final int maxFrameLength = 1048576;
			public static final int crcCode = 1024;
			public static final int lengthFieldLength = 4;
		}
		public static final int HeartBeat = 5;
		public static class Reconnect {
			public static final int MaxCount = 30;
			public static final int Interval = 10;
		}
		public static final int ReadTimeOutSecond = 10;
		public static final int port = 10050;
		public static class WhiteList {
			public static final Boolean Enable = true;
			public static final String[] List = new String[] {"127.0.0.1","localhost",};
		}
		public static final String url = "127.0.0.1";
	}
	public static class CallBackManager {
		public static final int threadPoolNum = 10;
	}
	public static class Mysql {
		public static final String pwd = "liyue";
		public static final String user = "liyue";
		public static final String url = "jdbc:mysql://127.0.0.1:3306/test?useSSL=false&serverTimezone=GMT";
	}
}
