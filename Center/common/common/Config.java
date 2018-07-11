package common;
public class Config {
	public static final String DataCOPath = "dataCOs";
	public static class CenterGameNet {
		public static class Packet {
			public static final int MaxFrameLength = 1048576;
			public static final int LengthFieldLength = 4;
			public static final int CrcCode = 1024;
			public static final int LengthFieldOffset = 4;
		}
		public static class CenterServer {
			public static final int LeaveClientsIntval = 300;
			public static final int ReadTimeOutSecond = 180;
			public static class DispatcherQueue {
				public static final int ThreadCount = 3;
				public static final int Capacity = 100000;
				public static final int WarnCount = 80000;
			}
			public static final int Port = 10050;
			public static class WhiteList {
				public static final Boolean Enable = true;
				public static final String[] List = new String[] {"127.0.0.1","localhost",};
			}
		}
	}
	public static class CallBackManager {
		public static final int ThreadPoolNum = 10;
	}
	public static class Mysql {
		public static final String User = "liyue";
		public static final String Pwd = "liyue";
		public static final String Url = "jdbc:mysql://127.0.0.1:3306/test?useSSL=false&serverTimezone=GMT";
	}
	public static class MongoDB {
		public static final int Port = 27017;
		public static final String DatabaseName = "test";
		public static final String Url = "localhost";
	}
}
