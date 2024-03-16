package club.hellin.vivillyapi.utils.api;

import org.bukkit.entity.Player;

import java.util.Collection;
import java.util.function.Consumer;

public interface CoreProviderBase {
    ServerType getType();
    boolean isStarted();
    String getUuid();
    void register(final ServerType type);
    void resetServer();

    /**
     * Should only be used by servers that support multiple games per server
     * @param players
     * @param resetServer
     */
    void reset(final Collection<? extends Player> players, final boolean resetServer);

    void sendAll(final Collection<? extends Player> players);
    void start();
    void stop();
    void setStarted(final boolean value);
    void getName(final Consumer<String> callback);
}