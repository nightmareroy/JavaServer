package main;

import common.CallBackManager;
import common.Config;
import common.Mysql;
import common.Out;
import io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue.Consumer;
import server.center.LoginServer;


/**
 * center功能：
 * 1.接受用户登录请求，返回游戏服ip、port、aid
 * 2.接受游戏服认证请求，确认玩家是否已登录
 * @author Administrator
 *
 */
public class CenterMain {
	public static void main(String [] args){
        
//		Config.Init();
//		CallBackManager.Init(Config.CallBackManager.threadPoolNum);
//		Mysql.Init(Config.mysql_url, Config.mysql_user, Config.mysql_pwd);
		
		LoginServer.start();
		
		
        
        

    }

}
