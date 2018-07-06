package taskManager;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadPoolFactory implements ThreadFactory {
	static final AtomicInteger poolNumber = new AtomicInteger(1);
	static final AtomicInteger threadNumber = new AtomicInteger(1);
	final String namePrefix;
	
	public ThreadPoolFactory(String name) {
		namePrefix = "pool-" + poolNumber.getAndIncrement() + "-" + name;
	}
	
	@Override
	public Thread newThread(Runnable r) {
		Thread t = new Thread(r, namePrefix + threadNumber.getAndIncrement());
		t.setDaemon(false);
		t.setPriority(Thread.NORM_PRIORITY);
		return t;
	}

}
