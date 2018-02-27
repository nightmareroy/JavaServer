package main;

import common.CallBackManager;
import common.Config;
import common.Mysql;
import common.Out;

public class Main {
	public static void main(String [] args){
        
		Config.Init();
		Mysql.Init(Config.mysql_url, Config.mysql_user, Config.mysql_pwd);
        Out.info("启动完毕！");
        
        CallBackManager.invokeSync(()->{
        		Out.debug("total call back");
        }, (()->{})->{
        	
        });
    }
	
	static void InitMysql()
	{
		
	}
	
	static void InitHttpServer()
	{
		
	}
}
