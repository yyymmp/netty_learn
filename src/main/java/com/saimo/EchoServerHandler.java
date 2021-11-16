package com.saimo;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

import java.nio.charset.StandardCharsets;

/**
 * @author jlz
 * @className: EchoServerHandler
 * @date 2021/4/22 17:44
 * @description todo
 **/
public class EchoServerHandler extends ChannelInboundHandlerAdapter {


    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("server: 客户端"+ctx.channel().remoteAddress()+"连接已建立");
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {

    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        ByteBuf msg1 = (ByteBuf) msg;

        System.out.println("receive from client:"+msg1.toString(CharsetUtil.UTF_8));
        String replace = msg1.toString(CharsetUtil.UTF_8).replace("你", "我");
        ByteBuf byteBuf = ctx.alloc().buffer().writeBytes(replace.getBytes(StandardCharsets.UTF_8));
        ctx.writeAndFlush(byteBuf);
//        byteBuf.release();
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) {
//        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        // Close the connection when an exception is raised.
        cause.printStackTrace();
        System.out.println("server:客户端"+ctx.channel().remoteAddress()+"连接断开，断开原因："+cause.getMessage());
        ctx.close();
    }
}
