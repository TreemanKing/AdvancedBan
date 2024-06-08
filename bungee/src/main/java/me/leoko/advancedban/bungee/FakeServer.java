package me.leoko.advancedban.bungee;

import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.Server;

import java.net.InetSocketAddress;
import java.net.SocketAddress;

public class FakeServer implements Server {

    private final Server delegate;
    private final ServerInfo fakeServerInfo;

    public FakeServer(Server delegate, ServerInfo fakeServerInfo) {
        this.delegate = delegate;
        this.fakeServerInfo = fakeServerInfo;
    }


    @Override
    public ServerInfo getInfo() {
        return fakeServerInfo;
    }

    @Override
    public void sendData(String s, byte[] bytes) {
        delegate.sendData(s, bytes);
    }

    @Override
    public InetSocketAddress getAddress() {
        return delegate.getAddress();
    }

    @Override
    public SocketAddress getSocketAddress() {
        return delegate.getSocketAddress();
    }

    @Override
    public void disconnect(String s) {
        delegate.disconnect(s);
    }

    @Override
    public void disconnect(BaseComponent... baseComponents) {
        delegate.disconnect(baseComponents);
    }

    @Override
    public void disconnect(BaseComponent baseComponent) {
        delegate.disconnect(baseComponent);
    }

    @Override
    public boolean isConnected() {
        return delegate.isConnected();
    }

    @Override
    public Unsafe unsafe() {
        return delegate.unsafe();
    }
}
