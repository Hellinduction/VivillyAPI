package club.hellin.vivillyapi.commands.impl;

import club.hellin.vivillyapi.SpigotCoreBase;
import eu.decentsoftware.holograms.api.holograms.Hologram;
import org.bukkit.Location;

public abstract class LeaderboardBase {
    @Deprecated
    public static LeaderboardBase INSTANCE;

    /**
     * Make sure to call super() when extending this class in the constructor
     */
    public LeaderboardBase() {
        INSTANCE = this;
        SpigotCoreBase.get().setLeaderboardCommand(this);
    }

    public abstract Hologram createLeaderboard(final club.hellin.vivillyapi.models.impl.objects.LeaderboardBase.LeaderboardType type, final Location loc, final boolean save);
}