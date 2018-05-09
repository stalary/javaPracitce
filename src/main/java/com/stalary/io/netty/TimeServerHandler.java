package com.stalary.io.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;

/**
 * TimeServerHandler
 *
 * @author lirongqian
 * @since 2018/05/03
 */
@Slf4j
public class TimeServerHandler extends ChannelHandlerAdapter {

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) {
        System.out.println("TimeServerHandler handlerAdded Now is " + LocalDateTime.now());
        System.out.println(ctx);
        ByteBuf resp = Unpooled.copiedBuffer(LocalDateTime.now().toString().getBytes());
        ctx.write(resp);
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx)  {
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        ctx.close();
    }
}
