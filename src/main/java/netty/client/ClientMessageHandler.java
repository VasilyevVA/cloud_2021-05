package netty.client;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import netty.AbstractCommand;
import netty.Message;

public class ClientMessageHandler extends SimpleChannelInboundHandler<AbstractCommand> {

    private final Callback callback;

    public ClientMessageHandler(Callback callback) {
        this.callback = callback;
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, AbstractCommand message) throws Exception {
        callback.call(message);
    }
}