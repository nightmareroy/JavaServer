package world;

import java.util.HashMap;
import java.util.Map;

import client.ClientManager;
import common.Config;
import game.LogicDispatcher;

public class World {
	public Thread[] threads = new Thread[Config.CenterServer.DispatcherQueue.ThreadCount];
	public LogicDispatcher[] dispatchers=new LogicDispatcher[threads.length];
	
	private static World world=null;
	private World() {
		
	}
	
	public static World getInstance() {
		if(world==null) {
			world=new World();
		}
		return world;
	}
	
	public void init() {
		for(int i=0;i<threads.length;i++) {
			Thread thread = threads[i];
			LogicDispatcher logicDispatcher=dispatchers[i];
			
			logicDispatcher=new LogicDispatcher();
			thread=new Thread(logicDispatcher,String.valueOf(i));
			thread.start();
		}

		ClientManager.getInstance().init();
	}
}
