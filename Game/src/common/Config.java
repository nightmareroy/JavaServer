package common;
public class Config {
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
		public static final int port = 10050;
		public static final String url = "127.0.0.1";
	}
	public class IdentifyServer {
		public static final int port = 11050;
		public static final String url = "127.0.0.1";
	}
}
