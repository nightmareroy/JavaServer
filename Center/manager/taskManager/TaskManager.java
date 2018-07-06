package taskManager;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;


public class TaskManager {
	public static ScheduledExecutorService TaskExec;
	
	static {
		TaskExec = Executors.newSingleThreadScheduledExecutor(new ThreadPoolFactory("排程业务"));
	}
}
