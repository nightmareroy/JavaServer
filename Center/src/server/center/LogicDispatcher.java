package server.center;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
//import java.awt.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import com.google.protobuf.Descriptors.MethodDescriptor;
import com.google.protobuf.MessageLite;

import common.Config;
import common.Out;
import handler.base.IHandler;
import server.center.Header.HeaderType;
import test.Services;



public class LogicDispatcher implements Runnable {
	
	
	private BlockingQueue<LogicPacket> blockingQueue = new LinkedBlockingQueue<LogicPacket>(Config.CenterServer.DispatcherQueue.Capacity);
	public static Map<String, Class<?>> handlerClassMap = new HashMap<>();
	private Map<String, Object> handlerMap = new HashMap<>();
	
	static {
		List<MethodDescriptor> mdList = Services.Handle.getDescriptor().getMethods();
		Out.debug(mdList.size());
		for (MethodDescriptor methodDescriptor : mdList) {
			
			try {
				Class<?> handlerC = Class.forName("handler."+methodDescriptor.getName()+"Handler");
//				IHandler<MessageLite, MessageLite> iHandler=(IHandler<MessageLite, MessageLite>)handlerC;
				handlerClassMap.put(methodDescriptor.getName(), handlerC);
				Out.debug(handlerClassMap.get(methodDescriptor.getName()));
			} catch (Exception e) {
//				e.printStackTrace();
				Out.warn("handler."+methodDescriptor.getName()+"Handler,未实现");
			}

			
		}
	}
	
	public void init()
	{
		
		for (Map.Entry<String, Class<?>> entry : handlerClassMap.entrySet()) {
			try {
				handlerMap.put(entry.getKey(), entry.getValue().newInstance());
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
	public boolean addPacket(LogicPacket logicPacket)
	{
		if (blockingQueue.size() > Config.CenterServer.DispatcherQueue.WarnCount) {
			Out.warn("队列偏大 -> ", blockingQueue.size());
		}
		if (blockingQueue.offer(logicPacket)) {
			return true;
		} else {
			Out.error("队列过大，丢弃了请求：", logicPacket.header.type);
			return false;
		}
	}
	@Override
	public void run() {
		LogicPacket logicPacket = null;
		while (true) {
			try {
				logicPacket = blockingQueue.take();
				
				IHandler<MessageLite, MessageLite> iHandler =  (IHandler<MessageLite, MessageLite>)handlerMap.get(logicPacket);
				
				// 开始执行的时间...
				long startExecuteTime = System.nanoTime();
				
				//执行
				MessageLite response=iHandler.handle(logicPacket.content);
				
				
				// 结束执行的时间...
				long endExecuteTime = System.nanoTime();
				
				long executeTime = endExecuteTime - startExecuteTime;
				
				Packet responsePacket = new Packet(logicPacket.header.sessionID,HeaderType.LoginRes,logicPacket.route,logicPacket.content,logicPacket.channel);
				
				logicPacket.channel.writeAndFlush(responsePacket);
				
			} catch (Exception e) {
				Out.error(String.format("处理句柄【%s】出错 -> %s", logicPacket.route, e.toString()), e);
//				IPBlacks.getInstance().exceptionIp(packet.getSession());
			}
		}
		
	}
}
