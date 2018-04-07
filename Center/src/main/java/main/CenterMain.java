package main;

import common.CallBackManager;
import common.Config;
import common.Mysql;
import common.Out;
import io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue.Consumer;

public class CenterMain {
	public static void main(String [] args){
        
//		Config.Init();
//		CallBackManager.Init(Config.callBackManager_threadPoolNum);
//		Mysql.Init(Config.mysql_url, Config.mysql_user, Config.mysql_pwd);
		
        Out.info("启动完毕！");
        

    }

}
