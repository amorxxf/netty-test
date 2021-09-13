package cn.xuxiaofeng.it.service;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.embedded.EmbeddedChannel;
import io.netty.channel.local.LocalChannel;
import io.netty.handler.codec.FixedLengthFrameDecoder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    public void test() {
        ByteBuf buf = Unpooled.buffer();
        for (int i = 0; i < 9; i++) {
            buf.writeByte(i);
        }

        ByteBuf input = buf.duplicate();
        EmbeddedChannel channel = new EmbeddedChannel(new FixedLengthFrameDecoder(3));

        assertFalse(channel.writeInbound(input.readBytes(2))); // 不满3个字节，无法写入
        assertTrue(channel.writeInbound(input.readBytes(7))); // 7字节的入站数据写入成功
        assertTrue(channel.finish());

        ByteBuf read = (ByteBuf) channel.readInbound();
        assertEquals(buf.readSlice(3), read);
        read.release();

        read = (ByteBuf) channel.readInbound();
        assertEquals(buf.readSlice(3), read);
        read.release();

        read = (ByteBuf) channel.readInbound();
        assertEquals(buf.readSlice(3), read);
        read.release();

        assertNull(channel.readInbound());
        buf.release();
    }

    @Test
    public void testFramesDecoded() {
        ByteBuf buf = Unpooled.buffer();
        // 创建一个 ByteBuf，并存储 9 字节
        for (int i = 0; i < 9; i++) {
            buf.writeByte(i);
        }

        // 创建一个EmbeddedChannel，并添加一个FixedLengthFrameDecoder，其将以 3 字节的帧长度被测试
        ByteBuf input = buf.duplicate(); // buf 和 input 引用相同
        EmbeddedChannel channel = new EmbeddedChannel(new FixedLengthFrameDecoder(3));

        // write bytes
        assertTrue(channel.writeInbound(input.retain())); // 引用计数 +1 并返回ByteBuf, 将数据写入EmbeddedChannel
        assertTrue(channel.finish()); // 标记完成

        // read messages
        ByteBuf read = (ByteBuf) channel.readInbound(); // EmbeddedChannel 读取3个字节
        assertEquals(buf.readSlice(3), read);  // 判断 buf 读取3个字节和 read 默认读取相等
        read.release(); // 释放引用 -1

        read = (ByteBuf) channel.readInbound();
        assertEquals(buf.readSlice(3), read);
        read.release();

        read = (ByteBuf) channel.readInbound();
        assertEquals(buf.readSlice(3), read);
        read.release();

        assertNull(channel.readInbound()); // 读取不到字节
        buf.release(); // 释放 buf / input
    }
}
