package cn.xuxiaofeng.it.service.chat.secure;

import cn.xuxiaofeng.it.service.chat.ChatServerInitializer;
import io.netty.channel.Channel;
import io.netty.channel.group.ChannelGroup;
import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslHandler;

import javax.net.ssl.SSLEngine;

/**
 * @ClassName: SecureChatServerInitializer
 * @Description: 为 ChannelPipeline 添加加密
 * @CreateBy: xxf
 * @Date: 2021/9/13 13:54
 */
public class SecureChatServerInitializer extends ChatServerInitializer {
    private final SslContext context;
    public SecureChatServerInitializer(ChannelGroup group,
                                       SslContext context) {
        super(group);
        this.context = context;
    }
    @Override
    protected void initChannel(Channel ch) throws Exception {
        super.initChannel(ch);
        SSLEngine engine = context.newEngine(ch.alloc());
        engine.setUseClientMode(false);
        ch.pipeline().addFirst(new SslHandler(engine));
    }
}
