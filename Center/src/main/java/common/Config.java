package common;
public class Config {
	public class server {
		public static final int port = 10050;
		public static final String url = "127.0.0.1";
	}
	public class callBackManager {
		public static final String threadPoolNum = "10";
	}
	public class mysql {
		public class test {
			public static final String t = "t";
		}
		public static final String pwd = "liyue";
		public static final String user = "liyue";
		public static final String url = "jdbc:mysql://127.0.0.1:3306/HEX_FIGHT?useSSL=false";
	}
}
