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
		public static class GameClient {
			public static final int HeartBeat = 5;
			public static class Reconnect {
				public static final int MaxCount = 30;
				public static final int Interval = 10;
			}
			public static final int ReadTimeOutSecond = 180;
			public static class DispatcherQueue {
				public static final int ThreadCount = 3;
				public static final int Capacity = 100000;
				public static final int WarnCount = 80000;
			}
			public static final int ClientId = 0;
		}
		public static class CenterServer {
			public static final int Port = 10050;
			public static final String Url = "127.0.0.1";
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
}
