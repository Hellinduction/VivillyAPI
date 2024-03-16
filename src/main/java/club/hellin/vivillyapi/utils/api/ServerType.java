package club.hellin.vivillyapi.utils.api;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public enum ServerType {
    SUMO_EVENT(2, 100, true, false),
    APP_WARS(2, 16, false, false),
    BED_WARS(2, 16, false, true), // Start with 4v4v4v4 BedWars but make it so if 2 players joined it would just distribute them evenly among the teams, process people in parties first and put them in the same team as the leader if possible
    ARENA(2, 2, false, true);

    private final int minPlayers;
    private final int maxPlayers;
    private final boolean megaServer;
    private final boolean isHidden; // For GameMode's that are not released yet!!

    ServerType(final int minPlayers, final int maxPlayers, final boolean megaServer, final boolean isHidden) {
        this.minPlayers = minPlayers;
        this.maxPlayers = maxPlayers;
        this.megaServer = megaServer;
        this.isHidden = isHidden;
    }

    public String prettyName() {
        return this.name().replace("_", " ");
    }

    public String prettyName(final boolean toLower) {
        String prettyName = this.prettyName();

        if (toLower)
            prettyName = prettyName.toLowerCase();

        return prettyName;
    }

    public static List<ServerType> getNonHidden() {
        final List<ServerType> types = new ArrayList<>();

        for (final ServerType type : ServerType.values()) {
            if (type.isHidden())
                continue;

            types.add(type);
        }

        return types;
    }

    public static ServerType[] getNonHiddenArray() {
        final List<ServerType> nonHidden = getNonHidden();
        return nonHidden.toArray(new ServerType[nonHidden.size()]);
    }
}