package common;


import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;


public class CallBackManager
{
//	public class CallbackFunction
//	{
//		public Function<T, R>;
//		public Object[] objects;
//		public AsyncFunction(Consumer<Object[]> consumer,Object[] objects)
//		{
//			this.consumer=consumer;
//			this.objects=objects;
//		}
//	}
	
	public static ExecutorService threadPool;
	
	public static void Init(int threadPoolNum)
	{
		threadPool = Executors.newFixedThreadPool(threadPoolNum);
	}

	public static void invokeAsync(Runnable totalCallBack,Runnable...runnables)
	{
		int count=runnables.length;
		int finished=0;
		Object finishedObj=new Object();
		for (Runnable runnable : runnables) {
			runnable.run();
			synchronized (finishedObj) {
				finished++;
			}
			if(finished==count)
			{
				totalCallBack.run();
			}
		}
	}
	
	/**
	 * callback同时执行,单线程异步
	 * @param totalCallBack
	 * @param consumers
	 */
	@SafeVarargs
	public static void invokeAsync(Runnable totalCallBack,Consumer<Runnable>...consumers)
	{
		final CountDownLatch countDownLatch=new CountDownLatch(consumers.length);

		for (Consumer<Runnable> consumer : consumers) {
			consumer.accept(()->{
				countDownLatch.countDown();
			});
			
			
		}
		
		try {
			countDownLatch.await();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		totalCallBack.run();
	}
	
	/**
	 * callback同时执行,多线程异步
	 * @param totalCallBack
	 * @param consumers
	 */
	@SafeVarargs
	public static void invokeAsyncMulti(Runnable totalCallBack,Consumer<Runnable>...consumers)
	{
		final CountDownLatch countDownLatch=new CountDownLatch(consumers.length);

		for (Consumer<Runnable> consumer : consumers) {
			threadPool.execute(()->{
				consumer.accept(()->{
					countDownLatch.countDown();
				});
			});
		}
		
		try {
			countDownLatch.await();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		totalCallBack.run();
	}
	
	/**
	 * callback顺序执行
	 * @param totalCallBack
	 * @param consumers
	 */
	@SafeVarargs
	public static void invokeSync(Runnable totalCallBack,Consumer<Runnable>...consumers)
	{
		for (Consumer<Runnable> consumer : consumers) {
			final CountDownLatch countDownLatch=new CountDownLatch(1);
			
			
			consumer.accept(()->{
				countDownLatch.countDown();
			});
			
			try {
				countDownLatch.await();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		totalCallBack.run();
	}
//	
//	public static void invokeSync(Function<Object, Object>...functions)
//	{
//		
//	}
}
