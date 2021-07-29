package cn.xuxiaofeng.it.service;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.CompositeByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.local.LocalChannel;

import java.nio.charset.StandardCharsets;

public class TestService {
    public static void main(String[] args) {

        Channel channel = new LocalChannel();
        ByteBufAllocator allocator = channel.alloc();
        ByteBuf buf = allocator.directBuffer();
        System.out.println(buf.refCnt());
        System.out.println(buf.release());

//        ByteBuf buf2 = new CompositeByteBuf(channel.alloc(), Boolean.TRUE, 16);
        ByteBuf buf2 = Unpooled.compositeBuffer();
        System.out.println(buf2.refCnt());
        System.out.println(buf2.release());
        System.out.println(buf2.refCnt());

    }
}
