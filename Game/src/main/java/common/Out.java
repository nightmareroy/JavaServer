package common;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Out {

	private static Logger logger = LogManager.getLogger();
	private static StringBuilder sb = new StringBuilder();
	public static void info(Object...arg)
	{
		sb.delete( 0, sb.length() );
		for (Object object : arg) {
			sb.append(object.toString());
		}
		logger.info(sb.toString());
	}
	
	public static void debug(Object...arg)
	{
		sb.delete( 0, sb.length() );
		for (Object object : arg) {
			sb.append(object.toString());
		}
		logger.debug(sb.toString());
	}
	
	public static void warn(Object...arg)
	{
		sb.delete( 0, sb.length() );
		for (Object object : arg) {
			sb.append(object.toString());
		}
		logger.warn(sb.toString());
	}
	
	public static void error(Object...arg)
	{
		sb.delete( 0, sb.length() );
		for (Object object : arg) {
			sb.append(object.toString());
		}
		logger.error(sb.toString());
	}
}
