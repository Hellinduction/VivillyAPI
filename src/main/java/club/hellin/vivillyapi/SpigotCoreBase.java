package club.hellin.vivillyapi;

import club.hellin.vivillyapi.commands.Initializable;
import club.hellin.vivillyapi.utils.api.CoreProviderBase;
import club.hellin.vivillyapi.utils.events.EventManagerBase;
import club.hellin.vivillyapi.ws.WsClientBase;
import lombok.Getter;
import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;
import java.util.UUID;

@Getter
public abstract class SpigotCoreBase extends JavaPlugin {
    public static SpigotCoreBase INSTANCE;

    /**
     * Make sure to call super() when extending this class in the constructor
     */
    public SpigotCoreBase() {
        INSTANCE = this;
    }

    public abstract List<Initializable> getInitCommands();

    public abstract WsClientBase getWs();

    public abstract CoreProviderBase getProvider();

    public abstract EventManagerBase getEventManager();

    public abstract String getServerName();

    public abstract void setServerName(final String serverName);

    public abstract UUID generateOrRetrieveUUID();

    protected abstract void registerCommand(final String cmdName, final CommandExecutor cmd);
}