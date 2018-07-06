package managerWorld;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Timer;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;


import common.Config;
import common.Out;
import managerGameClient.GameClientManager;
import managerProtoServices.ProtoServiceManager;
import serverGame.LogicDispatcher;

public class CenterWorld {
	public Thread[] threads = new Thread[Config.CenterGameNet.CenterServer.DispatcherQueue.ThreadCount];
	public LogicDispatcher[] dispatchers=new LogicDispatcher[threads.length];
	
	
	private static CenterWorld centerWorld=null;
	private CenterWorld() {
		
	}
	
	public static CenterWorld getInstance() {
		if(centerWorld==null) {
			centerWorld=new CenterWorld();
		}
		return centerWorld;
	}
	
	public void init() {
		ProtoServiceManager.init();
		
		for(int i=0;i<threads.length;i++) {	
			dispatchers[i]=new LogicDispatcher();
			dispatchers[i].init();
			threads[i]=new Thread(dispatchers[i],String.valueOf(i));
			threads[i].start();
		}

		
		GameClientManager.getInstance().init();
	}
	
	public LogicDispatcher getALogicDispatcher() {
		int r=(int)(Math.random()*dispatchers.length);
		return dispatchers[r];
	}
}
