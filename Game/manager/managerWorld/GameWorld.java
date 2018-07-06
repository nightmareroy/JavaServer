package managerWorld;

import java.util.HashMap;
import java.util.Map;

import clientCenter.LogicDispatcher;
import common.Config;
import managerProtoServices.ProtoServiceManager;


public class GameWorld {
	public Thread[] threads = new Thread[Config.CenterGameNet.GameClient.DispatcherQueue.ThreadCount];
	public LogicDispatcher[] dispatchers=new LogicDispatcher[threads.length];
	
	private static GameWorld gameWorld=null;
	private GameWorld() {
		
	}
	
	public static GameWorld getInstance() {
		if(gameWorld==null) {
			gameWorld=new GameWorld();
		}
		return gameWorld;
	}
	
	public void init() {
		ProtoServiceManager.init();
		
		for(int i=0;i<threads.length;i++) {
			dispatchers[i]=new LogicDispatcher();
			dispatchers[i].init();
			threads[i]=new Thread(dispatchers[i],String.valueOf(i));
			threads[i].start();
		}

//		ClientManager.getInstance().init();
		
	}
}
