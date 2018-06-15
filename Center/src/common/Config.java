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
		public static final int ReadTimeOutSecond = 10;
		public static class DispatcherQueue {
			public static final int ThreadCount = 3;
			public static final Boolean MonitorEnable = false;
			public static final int Capacity = 100000;
			public static final int WarnCount = 80000;
		}
		public static final int port = 10050;
		public static class WhiteList {
			public static final Boolean Enable = true;
			public static final String[] List = new String[] {"127.0.0.1","localhost",};
		}
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
