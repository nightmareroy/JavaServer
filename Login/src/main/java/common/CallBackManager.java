package common;

import java.lang.reflect.Method;
import java.util.function.Consumer;
import java.util.function.Function;

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
	
	public static void invokeSync(Runnable totalCallBack,Consumer<Runnable>...consumers)
	{
//		Consumer<Runnable> tempRunnable=null;
		consumers[0].accept(()->{
			consumers[1].accept(()->{
				consumers[2].accept(()->{
					consumers[3].accept(()->{
						
					});
				});
			});
		});
		
		
		
//		for (int i=0;i<consumers.length;i++) {
//
//			consumers[i].accept(()->{});
//
//
//		}
	}
//	
//	public static void invokeSync(Function<Object, Object>...functions)
//	{
//		
//	}
}
