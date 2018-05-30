package main;


import client.center.LoginClient;
import common.Config;
import common.Mysql;
import common.Out;
import io.netty.channel.ChannelFuture;
import io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue.Consumer;



/**
 * game功能：
 * 1.接受用户连接请求
 * 2.向中心服认证请求，确认玩家是否已登录
 * @author Administrator
 *
 */
public class GameMain {
	public static void main(String [] args){
        
//		Config.Init();
//		CallBackManager.Init(Config.CallBackManager.threadPoolNum);
//		Mysql.Init(Config.mysql_url, Config.mysql_user, Config.mysql_pwd);
		
		LoginClient.start();
		//LoginClient.request();

        

    }

}
