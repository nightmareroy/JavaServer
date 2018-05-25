package server.login;

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

public class LoginServer {
	public static void init() {
		
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
				        	.addLast(new ReadTimeoutHandler(Config.LoginServer.ReadTimeOutSecond))
				        	.addLast(new Encoder())
				        	.addLast(new Decoder(
				        			Config.LoginServer.Packet.maxFrameLength,
					        		Config.LoginServer.Packet.lengthFieldOffset,
					        		Config.LoginServer.Packet.lengthFieldLength,
					        		Header.getLengthAdjustment(),
					        		0
				        			));
				        	
//				        	.addLast(new Handler());
				    }
				});
			ChannelFuture f = serverBootstrap.bind(Config.LoginServer.port).sync(); 
			Out.info("login server init");
			
			// 等待服务端监听端口关闭
            f.channel().closeFuture().sync();
            
            
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
            workerGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
            Out.info("login server shutdown");
        }
		 
	}
}
