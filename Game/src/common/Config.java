package common;
public class Config {
	public class LoginClient {
		public static final int port = 20050;
	}
	public static final String DataCOPath = "dataCOs";
	public class CallBackManager {
		public static final int threadPoolNum = 10;
	}
	public class Mysql {
		public static final String pwd = "liyue";
		public static final String user = "liyue";
		public static final String url = "jdbc:mysql://127.0.0.1:3306/test?useSSL=false&serverTimezone=GMT";
	}
	public class LoginServer {
		public class Packet {
			public static final int lengthFieldOffset = 2;
			public static final int maxFrameLength = 1048576;
			public static final int lengthFieldLength = 4;
		}
		public static final int port = 10050;
		public static final String url = "127.0.0.1";
	}
	public class IdentifyServer {
		public static final int port = 11050;
		public static final String url = "127.0.0.1";
	}
}
