package club.hellin.vivillyapi;

import club.hellin.vivillyapi.commands.impl.DebugBase;
import club.hellin.vivillyapi.commands.impl.LeaderboardBase;
import club.hellin.vivillyapi.commands.impl.ToggleStatsBase;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.ServicePriority;
import org.bukkit.plugin.java.JavaPlugin;

@Getter
@Setter
public abstract class SpigotCoreBase extends JavaPlugin implements CoreAPI {
    @Deprecated
    public static SpigotCoreBase INSTANCE;

    private DebugBase debugCommand;
    private LeaderboardBase leaderboardCommand;
    private ToggleStatsBase toggleStatsCommand;

    /**
     * Make sure to call super() when extending this class in the constructor
     */
    public SpigotCoreBase() {
        INSTANCE = this;

        Bukkit.getServicesManager().register(
                CoreAPI.class,
                this,
                this,
                ServicePriority.Normal
        );
    }

    @Override
    public void onDisable() {
        INSTANCE = null;

        Bukkit.getServicesManager().unregisterAll(this);
    }

    public static SpigotCoreBase get() {
        return (SpigotCoreBase) CoreAPI.get();
    }

    protected abstract void registerCommand(final String cmdName, final CommandExecutor cmd);
}