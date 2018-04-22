package server.login;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender;

public class bootstraper {
	public static void init() {
		ServerBootstrap serverBootstrap=new ServerBootstrap();
		try {
			serverBootstrap
				.group(new NioEventLoopGroup(), new NioEventLoopGroup())
				.channel(NioServerSocketChannel.class)
				.childHandler(new ChannelInitializer<SocketChannel>() {  
				    @Override  
				    protected void initChannel(SocketChannel ch) throws Exception {  
				        ch.pipeline()  
				                .addLast(new ProtobufVarint32FrameDecoder())  
//				                .addLast(new ProtobufDecoder(ProtoObject.Req.getDefaultInstance()))
				                .addLast(new ProtobufVarint32LengthFieldPrepender())
				                .addLast(new ProtobufEncoder());
				                  
	//			                .addLast(new ServerHandler());  
				    }
			});
		} catch (Exception e) {
			// TODO: handle exception
		}
		 
	}
}
