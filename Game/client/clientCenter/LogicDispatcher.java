package clientCenter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import com.google.protobuf.Descriptors.MethodDescriptor;

import common.Config;
import common.Out;
import handlerInterfaces.IHandler;
import managerProtoServices.ProtoService;
import managerProtoServices.ProtoServiceManager;
import protoCenterGame.Services;
import clientCenter.Header.HeaderType;



public class LogicDispatcher implements Runnable {
	
	private BlockingQueue<LogicPacket> blockingQueue = new LinkedBlockingQueue<LogicPacket>(Config.CenterGameNet.GameClient.DispatcherQueue.Capacity);
	
	private Map<String, Object> handlerMap = new HashMap<>();

	
	public void init()
	{
		
		for (ProtoService protoService : ProtoServiceManager.protoCenterGameServiceMap.values()) {
			if(protoService.handlerClass==null) {
				continue;
			}
			try {
				handlerMap.put(protoService.route, protoService.handlerClass.newInstance());
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
	public boolean addPacket(LogicPacket logicPacket)
	{
		if (blockingQueue.size() > Config.CenterGameNet.GameClient.DispatcherQueue.WarnCount) {
			Out.warn("队列偏大 -> ", blockingQueue.size());
		}
		if (blockingQueue.offer(logicPacket)) {
			return true;
		} else {
			Out.error("队列过大，丢弃了请求：", logicPacket.packet.header.type);
			return false;
		}
	}
	@Override
	public void run() {
		LogicPacket logicPacket = null;
		while (true) {
			try {
				logicPacket = blockingQueue.take();
				
				IHandler iHandler =  (IHandler)handlerMap.get(logicPacket.route);
				
				// 开始执行的时间...
				long startExecuteTime = System.nanoTime();
				
				//执行
				byte[] response=iHandler.handle(logicPacket);
				
				
				// 结束执行的时间...
				long endExecuteTime = System.nanoTime();
				
				long executeTime = endExecuteTime - startExecuteTime;
				
				Packet responsePacket = new Packet(HeaderType.LogicRes,logicPacket.route,response,logicPacket.packet.channel);
				
				logicPacket.packet.channel.writeAndFlush(responsePacket);//,logicPacket.channel.voidPromise());
				
			} catch (Exception e) {
				Out.error(String.format("处理句柄【%s】出错 -> %s", logicPacket.route, e.toString()), e);
//				IPBlacks.getInstance().exceptionIp(packet.getSession());
			}
		}
		
	}
}
