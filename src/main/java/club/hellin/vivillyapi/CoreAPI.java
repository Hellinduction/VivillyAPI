package club.hellin.vivillyapi;

import club.hellin.vivillyapi.commands.Initializable;
import club.hellin.vivillyapi.commands.impl.DebugBase;
import club.hellin.vivillyapi.commands.impl.LeaderboardBase;
import club.hellin.vivillyapi.commands.impl.ToggleStatsBase;
import club.hellin.vivillyapi.utils.api.CoreProviderBase;
import club.hellin.vivillyapi.utils.events.EventManagerBase;
import club.hellin.vivillyapi.ws.WsClientBase;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

public interface CoreAPI {
    List<Initializable> getInitCommands();

    WsClientBase getWs();

    CoreProviderBase getProvider();

    EventManagerBase getEventManager();

    String getServerName();

    void setServerName(final String serverName);

    UUID generateOrRetrieveUUID();

    DebugBase getDebugCommand();

    LeaderboardBase getLeaderboardCommand();

    ToggleStatsBase getToggleStatsCommand();

    static <T extends CoreAPI> T get(final Plugin plugin) {
        final Class<?> clazz = SpigotCoreBase.getCoreApiClass();

        final T api = (T) Objects.requireNonNull(
                Bukkit.getServicesManager().getRegistration(clazz),
                String.format("%s not registered", clazz.getName())
        ).getProvider();

        if (plugin != null && api instanceof SpigotCoreBase) {
            final SpigotCoreBase spigotCoreBase = (SpigotCoreBase) api;
            spigotCoreBase.registerListeners(plugin);
        }

        return api;
    }
}