package club.hellin.vivillyapi.models.impl.objects;

import club.hellin.vivillyapi.utils.Utils;
import lombok.Getter;

public interface ArenaStatsBase {
    @Getter
    enum Values implements StatValues {
        ARENA_WIN_STREAK("arenaWinStreak", 0),
        SUMO_WIN_STREAK("sumoWinStreak", 0),
        ARENA_WINS("arenaWins", 0),
        SUMO_WINS("sumoWins", 0);

        private final String fieldName;
        private final String sqlName;
        private final Object defaultValue;

        Values(final String fieldName, final Object defaultValue) {
            this.fieldName = fieldName;
            this.sqlName = Utils.prettyName(this.fieldName);
            this.defaultValue = defaultValue;
        }
    }

    String getUuid();
    int getArenaWinStreak();
    ArenaStatsBase setArenaWinStreak(final int arenaWinStreak);
    int getSumoWinStreak();
    ArenaStatsBase setSumoWinStreak(final int sumoWinStreak);
    int getArenaWins();
    ArenaStatsBase setArenaWins(final int arenaWins);
    int getSumoWins();
    ArenaStatsBase setSumoWins(final int sumoWins);
    int getInt(final Values values);
    boolean getBoolean(final Values values);
    ArenaStatsBase setInt(final Values values, final int integer);
    ArenaStatsBase setBoolean(final Values values, final boolean value);
    <T> T getPrimitive(final Values values, final Class<T> type);
    String toJson();
    ArenaStatsBase clone();
}