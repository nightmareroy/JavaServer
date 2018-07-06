package clientCenter;

import java.net.URI;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

import clientCenter.Decoder;
import clientCenter.Encoder;
import clientCenter.Header;
import clientCenter.Header.HeaderType;
import common.Config;
import common.Out;
import io.netty.bootstrap.Bootstrap;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LengthFieldPrepender;
import io.netty.handler.codec.http.DefaultFullHttpRequest;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpMethod;
import io.netty.handler.codec.http.HttpRequestEncoder;
import io.netty.handler.codec.http.HttpResponseDecoder;
import io.netty.handler.codec.http.HttpVersion;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;


public class LoginClient {
	static Bootstrap clientBootstrap=new Bootstrap();
	static ChannelFuture f;
	
	//static boolean connected=false;
	static int connectedCount=0;
	static EventLoopGroup workerGroup=null;
	static Channel channel=null;
//	public static Runnable checkAndConnect=()->{
//		if(connectedCount>=Config.CenterServer.Reconnect.MaxCount) {
//			return;
//		}
//		if (!connected) {
//			try {
//				connectedCount++;
//				Out.info("第",connectedCount,"次连接");
//				f = clientBootstrap.connect(Config.CenterServer.url, Config.CenterServer.port);
//				f.addListener(new ChannelFutureListener() {
//					
//					@Override
//					public void operationComplete(ChannelFuture future) throws Exception {
//						// TODO Auto-generated method stub
//						connected=future.isSuccess();
//						//Out.debug(future.isSuccess());
////						Thread.sleep(Config.CenterServer.Reconnect.Interval*1000);
//						
//						future.channel().eventLoop().schedule(
//								checkAndConnect,
//								Config.CenterServer.Reconnect.Interval,
//								TimeUnit.SECONDS);
////						checkAndConnect();
//						
//					}
//				}).sync();
//			}
//			catch (Exception e) {
//				//e.printStackTrace();
//				workerGroup.shutdownGracefully();
//			}
//			
//		}
//		else {
//			connectedCount=0;
//		}
//	};
	
	public static void start() {
		
        workerGroup = new NioEventLoopGroup();
		try {
			clientBootstrap
				.group(workerGroup)
				.channel(NioSocketChannel.class)
				.option(ChannelOption.TCP_NODELAY, true)
				.handler(new ChannelInitializer<SocketChannel>() {  
				    @Override  
				    protected void initChannel(SocketChannel ch) throws Exception {  
				        ch.pipeline()
					        .addLast(new ReadTimeoutHandler(Config.CenterGameNet.GameClient.ReadTimeOutSecond))
					        .addLast(new Encoder())
					        .addLast(new Decoder(
				        			Config.CenterGameNet.Packet.MaxFrameLength,
					        		Config.CenterGameNet.Packet.LengthFieldOffset,
					        		Config.CenterGameNet.Packet.LengthFieldLength,
					        		Header.getLengthAdjustment(),
					        		0
				        			));
				        	
//				        	.addLast(new LengthFieldPrepender(Config.LoginServer.Packet.lengthFieldLength));
//					        .addLast(new Handler());
				    }
				});
//			ChannelFuture f = clientBootstrap.bind(Config.LoginClient.port).sync(); 
//
//            f.channel().closeFuture().sync();
//            Out.info("client bind");
			
//			f.channel().closeFuture().addListener(new ChannelFutureListener() {
//				
//				@Override
//				public void operationComplete(ChannelFuture future) throws Exception {
//					Thread.sleep(1000);
//		            f = clientBootstrap.connect(Config.LoginServer.url, Config.LoginServer.port).sync();
//		            Out.debug("login client reconect");
//				}
//			});
			checkAndConnect();

		}
		catch (Exception e) {
			e.printStackTrace();
		}
//		finally {
//            //workerGroup.shutdownGracefully();
//            Out.info("login client shutdown");
//        }
		 
	}
	
	public static void checkAndConnect(){
		if(channel!=null&&channel.isActive()) {
			return;
		}
		if(connectedCount>=Config.CenterGameNet.GameClient.Reconnect.MaxCount) {
			workerGroup.shutdownGracefully();
			return;
		}
		try {
			connectedCount++;
			Out.info("第",connectedCount,"次连接");
			f = clientBootstrap.connect(Config.CenterGameNet.CenterServer.Url, Config.CenterGameNet.CenterServer.Port);
			f.addListener(new ChannelFutureListener() {
				
				@Override
				public void operationComplete(ChannelFuture future) throws Exception {
					channel=future.channel();
//					connected=future.isSuccess();
					//Out.debug(future.isSuccess());
//					Thread.sleep(Config.CenterServer.Reconnect.Interval*1000);
					if(!future.isSuccess()) {
						future.channel().eventLoop().schedule(
								()->{
									checkAndConnect();
								},
								Config.CenterGameNet.GameClient.Reconnect.Interval,
								TimeUnit.SECONDS);
					}
					else {
						connectedCount=0;
					}
					
//					checkAndConnect();
					
				}
			});
		}
		catch (Exception e) {
			//e.printStackTrace();
			workerGroup.shutdownGracefully();
			connectedCount=0;
		}
		

	};
	
}
