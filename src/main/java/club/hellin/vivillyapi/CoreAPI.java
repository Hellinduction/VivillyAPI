package club.hellin.vivillyapi;

import club.hellin.vivillyapi.commands.Initializable;
import club.hellin.vivillyapi.commands.impl.DebugBase;
import club.hellin.vivillyapi.commands.impl.LeaderboardBase;
import club.hellin.vivillyapi.commands.impl.ToggleStatsBase;
import club.hellin.vivillyapi.utils.api.CoreProviderBase;
import club.hellin.vivillyapi.utils.events.EventManagerBase;
import club.hellin.vivillyapi.ws.WsClientBase;
import org.bukkit.Bukkit;

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

    static CoreAPI get() {
        return Objects.requireNonNull(
                Bukkit.getServicesManager().getRegistration(CoreAPI.class),
                "CoreAPI not registered"
        ).getProvider();
    }
}