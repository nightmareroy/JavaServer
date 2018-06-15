package server.center;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;


import common.Config;
import common.Out;


public class LogicDispatcher implements Runnable {
	
	
	private BlockingQueue<Packet> blockingQueue = new LinkedBlockingQueue<Packet>(Config.CenterServer.DispatcherQueue.Capacity);
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
		Packet packet = null;
		while (true) {
			try {
				packet = blockingQueue.take();
				if (Config.CenterServer.DispatcherQueue.MonitorEnable) {
					// 开始执行的时间...
					long startExecuteTime = System.nanoTime();

					Header header = packet.getHeader();
					execute(packet);

					// 执行结束的时间...
					long endExecuteTime = System.nanoTime();

					float delay = (startExecuteTime - header.getReceiveTime()) / 100_0000F;
					float exec = (endExecuteTime - startExecuteTime) / 100_0000F;

					String protocal = header.getTypeHexString();
					if (Out.isEnableDebug() || !protocal.endsWith(GET_SYSTIME_REQUEST)) {
						GPlayer player = packet.getPlayer();
						Out.info("handle ", protocal, ", delay=", delay, " ms, exec=", exec, " ms, playerId=", player == null ? 0 : player.getId());
					}
				} else {
					execute(packet);
				}
			} catch (Exception e) {
				Out.error(String.format("处理句柄【%s】出错 -> %s", packet.getHeader().getTypeHexString(), e.toString()), e);
				IPBlacks.getInstance().exceptionIp(packet.getSession());
			}
		}
		
	}
}
