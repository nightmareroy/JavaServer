package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import common.Config;
import common.FileUtil;
import common.Out;

public class DataCOIniter {
	
	public static void main(String[] args) {
		FileUtil.deleteDirectory(Config.DataCOPath);
		
		
		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection connection=DriverManager.getConnection(Config.Mysql.url, Config.Mysql.user, Config.Mysql.pwd);
			if(!connection.isClosed())
			{
				Out.info("连接数据库成功！");
			}
			
			genFolder(connection);
			
			
			connection.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	public static void genFolder(Connection connection) {
		try {
			List<Map<String,Object>> list = new ArrayList<>();
			Statement statement=connection.createStatement();
			ResultSet resultSet = statement.executeQuery("show tables from test;");
			ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
			while (resultSet.next()) {
	            Map<String,Object> rowData = new HashMap<>();
	            for (int i = 1; i <= resultSetMetaData.getColumnCount(); i++) {
	                rowData.put(resultSetMetaData.getColumnName(i), resultSet.getObject(i));
	            }
	            list.add(rowData);
	        }
			statement.close();
			
			for (Map<String,Object> map : list) {
				for (Object name : map.values()) {
//					Out.debug(entry.getKey(),"::",entry.getValue());
					FileUtil.createFolder(Config.DataCOPath, (String)name);
				}
				
//				Out.info(FileUtil.createFolder(Config.DataCOPath, (String)nameObj));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
