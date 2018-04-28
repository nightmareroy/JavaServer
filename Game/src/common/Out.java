package common;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Out {

	private static Logger logger = LogManager.getLogger();
	private static StringBuilder sb = new StringBuilder();
	
	private static void argsTransfer(Object...arg)
	{
		sb.delete( 0, sb.length() );
		for (Object object : arg) {
			if(object!=null)
			{
				sb.append(object.toString());
			}
			else {
				sb.append("null");
			}
		}
	}
	public static void info(Object...arg)
	{
		argsTransfer(arg);
		logger.info(sb.toString());
	}
	
	public static void debug(Object...arg)
	{
		StackTraceElement[] lvStacks=Thread.currentThread().getStackTrace();
		argsTransfer(arg);
		
		logger.debug("["+lvStacks[2].getClassName() + "][" + lvStacks[2].getMethodName()  
                +"]["+ lvStacks[2].getLineNumber()+"] "+sb.toString());
	}
	
	public static void warn(Object...arg)
	{
		argsTransfer(arg);
		logger.warn(sb.toString());
	}
	
	public static void error(Object...arg)
	{
		StackTraceElement[] lvStacks=Thread.currentThread().getStackTrace();
		argsTransfer(arg);
		logger.error("["+lvStacks[2].getClassName() + "][" + lvStacks[2].getMethodName()  
                +"]["+ lvStacks[2].getLineNumber()+"] "+sb.toString());
	}
}
