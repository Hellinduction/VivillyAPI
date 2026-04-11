package club.hellin.vivillyapi;

import club.hellin.vivillyapi.commands.impl.DebugBase;
import club.hellin.vivillyapi.commands.impl.LeaderboardBase;
import club.hellin.vivillyapi.commands.impl.ToggleStatsBase;
import club.hellin.vivillyapi.event.CoreReadyEvent;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.plugin.ServicePriority;
import org.bukkit.plugin.java.JavaPlugin;

@Getter
@Setter
public abstract class SpigotCoreBase extends JavaPlugin implements CoreAPI, Listener {
    @Deprecated
    public static SpigotCoreBase INSTANCE;

    private static Class<?> coreApiClass = CoreAPI.class;

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

    /**
     * To be called onEnable
     */
    protected void init() {
        Bukkit.getPluginManager().registerEvents(this, this);
        Bukkit.getPluginManager().callEvent(new CoreReadyEvent(this));
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onCoreReady(final CoreReadyEvent e) {
        coreApiClass = e.getApi().getClass();
    }

    @Override
    public void onDisable() {
        INSTANCE = null;

        Bukkit.getServicesManager().unregisterAll(this);
    }

    protected static Class<?> getCoreApiClass() {
        if (CoreAPI.class.getSimpleName().equals(coreApiClass.getSimpleName()))
            return coreApiClass;

        for (final Class<?> clazz : coreApiClass.getSuperclass().getInterfaces())
            if (CoreAPI.class.getSimpleName().equals(clazz.getSimpleName()))
                return clazz;

        return null;
    }

    public static SpigotCoreBase get() {
        return CoreAPI.get();
    }

    protected abstract void registerCommand(final String cmdName, final CommandExecutor cmd);
}