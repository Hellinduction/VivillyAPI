package club.hellin.vivillyapi.models.impl.objects;

import club.hellin.vivillyapi.models.impl.PlayerStateBase;
import club.hellin.vivillyapi.utils.api.ServerType;
import com.google.gson.JsonObject;
import lombok.Getter;

import java.util.List;

public interface LeaderboardBase {
    /**
     * I KNOW THIS IS AUTISTIC BUT I CANT BE ASSED TO DO IT ANOTHER WAY:
     * PUT THE SERVER TYPE NAME BEFORE THE LEADERBOARD TYPE NAME + _
     */
    @Getter
    enum LeaderboardType {
        /**
         * Sumo Event Stats
         */
        SUMO_EVENT_WINS(SumoEventStatsBase.Values.WINS, ServerType.SUMO_EVENT),
        SUMO_EVENT_LOSSES(SumoEventStatsBase.Values.LOSSES, ServerType.SUMO_EVENT),
        SUMO_EVENT_KILLS(SumoEventStatsBase.Values.KILLS, ServerType.SUMO_EVENT),
        SUMO_EVENT_WIN_STREAK(SumoEventStatsBase.Values.WIN_STREAK, ServerType.SUMO_EVENT),
        SUMO_EVENT_BEST_WIN_STREAK(SumoEventStatsBase.Values.BEST_WIN_STREAK, ServerType.SUMO_EVENT),
        SUMO_EVENT_KILL_STREAK(SumoEventStatsBase.Values.KILL_STREAK, ServerType.SUMO_EVENT),
        SUMO_EVENT_BEST_KILL_STREAK(SumoEventStatsBase.Values.BEST_KILL_STREAK, ServerType.SUMO_EVENT),
        SUMO_EVENT_EXPERIENCE(SumoEventStatsBase.Values.EXPERIENCE, ServerType.SUMO_EVENT),

        /**
         * App Wars Stats
         */
        APP_WARS_WINS(AppWarsStatsBase.Values.WINS, ServerType.APP_WARS),
        APP_WARS_LOSSES(AppWarsStatsBase.Values.LOSSES, ServerType.APP_WARS),
        APP_WARS_WIN_STREAK(AppWarsStatsBase.Values.WIN_STREAK, ServerType.APP_WARS),
        APP_WARS_BEST_WIN_STREAK(AppWarsStatsBase.Values.BEST_WIN_STREAK, ServerType.APP_WARS),
        APP_WARS_EXPERIENCE(AppWarsStatsBase.Values.EXPERIENCE, ServerType.APP_WARS),
        APP_WARS_ROUNDS_WON(AppWarsStatsBase.Values.ROUNDS_WON, ServerType.APP_WARS),

        /**
         * Arena Stats
         */
        ARENA_ARENA_WIN_STREAK(ArenaStatsBase.Values.ARENA_WIN_STREAK, ServerType.ARENA),
        ARENA_SUMO_WIN_STREAK(ArenaStatsBase.Values.SUMO_WIN_STREAK, ServerType.ARENA),
        ARENA_ARENA_WINS(ArenaStatsBase.Values.ARENA_WINS, ServerType.ARENA),
        ARENA_SUMO_WINS(ArenaStatsBase.Values.SUMO_WINS, ServerType.ARENA),
        ARENA_ARENA_BEST_WIN_STREAK(ArenaStatsBase.Values.BEST_ARENA_WIN_STREAK, ServerType.ARENA),
        ARENA_SUMO_BEST_WIN_STREAK(ArenaStatsBase.Values.BEST_SUMO_WIN_STREAK, ServerType.ARENA),

        /**
         * Events Stats
         */
        EVENTS_WINS(EventsStatsBase.Values.WINS, ServerType.EVENTS),
        EVENTS_WIN_STREAK(EventsStatsBase.Values.WIN_STREAK, ServerType.EVENTS),
        EVENTS_EXPERIENCE(EventsStatsBase.Values.EXPERIENCE, ServerType.EVENTS),
        EVENTS_LOSSES(EventsStatsBase.Values.LOSSES, ServerType.EVENTS),
        EVENTS_BEST_WIN_STREAK(EventsStatsBase.Values.BEST_WIN_STREAK, ServerType.EVENTS),

        /**
         * Elytra Stats
         */
        ELYTRA_TIME(ElytraStatsBase.Values.TIME, ServerType.ELYTRA),
        ELYTRA_COMPLETION_STREAK(ElytraStatsBase.Values.COMPLETION_STREAK, ServerType.ELYTRA),
        ELYTRA_TIMES_COMPLETED(ElytraStatsBase.Values.TIMES_COMPLETED, ServerType.ELYTRA),
        ELYTRA_ROCKETS_USED(ElytraStatsBase.Values.ROCKETS_USED, ServerType.ELYTRA);

        private final StatValues values;
        private final ServerType serverType;
        private final String formattedName; // Unique
        private final String prettyName; // Not unique

        LeaderboardType(final StatValues values, final ServerType serverType) {
            this.values = values;
            this.serverType = serverType;
            this.formattedName = this.name().replace("_", "-");
            this.prettyName = this.formattedName.replace(this.serverType.name().replace("_", "-") + "-", "");
        }

        public static LeaderboardType getByFormattedName(final String formattedName) {
            for (final LeaderboardType type : LeaderboardType.values())
                if (type.getFormattedName().equals(formattedName))
                    return type;

            return null;
        }

        /**
         * Deprecated because its results are unreliable since multiple leaderboard types can have the same pretty name
         *
         * @param prettyName
         * @return
         */
        @Deprecated
        public static LeaderboardType getByPrettyName(final String prettyName) {
            for (final LeaderboardType type : LeaderboardType.values())
                if (type.getPrettyName().equals(prettyName))
                    return type;

            return null;
        }
    }

    List<PlayerStateBase> getPlayerStates();
    LeaderboardType getType();
    long getCreatedAt();
    int get(final PlayerStateBase state);
    JsonObject toJson();
}