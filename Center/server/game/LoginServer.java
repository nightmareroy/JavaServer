package game;

import java.util.concurrent.ExecutorService;

import common.Config;
import common.Out;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;

public class LoginServer {
	public static void start() {
		
		EventLoopGroup bossGroup = new NioEventLoopGroup(); 
        EventLoopGroup workerGroup = new NioEventLoopGroup();
		ServerBootstrap serverBootstrap=new ServerBootstrap();
		try {
			serverBootstrap
				.group(bossGroup, workerGroup)
				.channel(NioServerSocketChannel.class)
				.option(ChannelOption.SO_BACKLOG, 128)  
				.childHandler(new ChannelInitializer<SocketChannel>() {  
				    @Override  
				    protected void initChannel(SocketChannel ch) throws Exception {  
				        ch.pipeline()
				        	.addLast(new ReadTimeoutHandler(Config.CenterServer.ReadTimeOutSecond))
				        	.addLast(new Encoder())
				        	.addLast(new Decoder(
				        			Config.CenterServer.Packet.maxFrameLength,
					        		Config.CenterServer.Packet.lengthFieldOffset,
					        		Config.CenterServer.Packet.lengthFieldLength,
					        		Header.getLengthAdjustment(),
					        		0
				        			));
				        	
//				        	.addLast(new Handler());
				    }
				});
			ChannelFuture f = serverBootstrap.bind(Config.CenterServer.port).sync(); 
			Out.info("login server init");
			
//			ExecutorService
			// 等待服务端监听端口关闭
            f.channel().closeFuture().addListener(new GenericFutureListener<Future<? super Void>>() {

				@Override
				public void operationComplete(Future<? super Void> future) throws Exception {
					workerGroup.shutdownGracefully();
		            bossGroup.shutdownGracefully();
		            Out.debug("login server shutdown");
				}
			});
            
            
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		 
	}
}
