package com.saimo;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringEncoder;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author jlz
 * @className: EchoClient
 * @date 2021/4/22 17:20
 * @description todo
 **/
public final class EchoClient {

    static final boolean SSL = System.getProperty("ssl") != null;
    static final String HOST = System.getProperty("host", "127.0.0.1");
    static final int PORT = 8080;
    static final int SIZE = Integer.parseInt(System.getProperty("size", "256"));

    public static void main(String[] args) throws Exception {

        EventLoopGroup group = new NioEventLoopGroup();
        Bootstrap b = new Bootstrap();
        b.group(group)
                .channel(NioSocketChannel.class)
                .option(ChannelOption.TCP_NODELAY, true)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    public void initChannel(SocketChannel ch) throws Exception {
                        ChannelPipeline p = ch.pipeline();
//                            p.addLast(new LoggingHandler(LogLevel.INFO));
                        p.addLast(new StringEncoder());
                        p.addLast(new EchoClientHandler());
                    }
                });

        // Start the client.
        Channel channel = b.connect(HOST, PORT).sync().channel();

        // Wait until the connection is closed.
        channel.closeFuture().addListener(future -> {
            channel.close();
        });


        ExecutorService es1 = Executors.newSingleThreadExecutor();
        es1.execute(() -> {
            Scanner scanner = new Scanner(System.in);
            while (true) {
                String s = scanner.nextLine();
                if (s.equals("q")) {
                    break;
                }
                channel.writeAndFlush(s);
                System.out.println("send to server:"+s);
            }


        });
    }

}

