package common;

import java.sql.Connection;
import java.sql.DriverManager;

public class Mysql {
	public static void Init(String url,String user,String password)
	{
		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection connection=DriverManager.getConnection(url, user, password);
			if(!connection.isClosed())
			{
				Out.info("连接数据库成功！");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
