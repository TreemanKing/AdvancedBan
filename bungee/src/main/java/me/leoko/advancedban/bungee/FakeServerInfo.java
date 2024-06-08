package me.leoko.advancedban.bungee;

import net.md_5.bungee.api.Callback;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ServerPing;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;

import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.Collection;

public class FakeServerInfo implements ServerInfo {

    private final ServerInfo delegate;
    private final Collection<ProxiedPlayer> fakePlayers;

    public FakeServerInfo(ServerInfo delegate, Collection<ProxiedPlayer> fakePlayers) {
        this.delegate = delegate;
        this.fakePlayers = fakePlayers;
    }

    @Override
    public String getName() {
        return delegate.getName();
    }

    @Override
    public InetSocketAddress getAddress() {
        return delegate.getAddress();
    }

    @Override
    public SocketAddress getSocketAddress() {
        return getSocketAddress();
    }

    @Override
    public Collection<ProxiedPlayer> getPlayers() {
        return fakePlayers;
    }

    @Override
    public String getMotd() {
        return delegate.getName();
    }

    @Override
    public boolean isRestricted() {
        return delegate.isRestricted();
    }

    @Override
    public String getPermission() {
        return delegate.getPermission();
    }

    @Override
    public boolean canAccess(CommandSender commandSender) {
        return delegate.canAccess(commandSender);
    }

    @Override
    public void sendData(String s, byte[] bytes) {
        delegate.sendData(s, bytes);
    }

    @Override
    public boolean sendData(String s, byte[] bytes, boolean b) {
        return sendData(s, bytes, b);
    }

    @Override
    public void ping(Callback<ServerPing> callback) {
        delegate.ping(callback);
    }
}
