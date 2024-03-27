package club.hellin.vivillyapi.models.impl.objects;

import club.hellin.vivillyapi.models.ModelBase;
import club.hellin.vivillyapi.utils.Utils;
import lombok.Getter;

public interface EventsStatsBase extends ModelBase {
    @Getter
    enum Values implements StatValues {
        WINS("wins", 0),
        WIN_STREAK("winStreak", 0),
        GAMES_PLAYED("gamesPlayed", 0),
        EXPERIENCE("experience", 1000),
        LOSSES("losses", 0),
        BEST_WIN_STREAK("bestWinStreak", 0),
        MONEY_WON("moneyWon", 0); // This is money that is won and can be collected (through some way) on the SMP

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
    int getWins();
    EventsStatsBase setWins(final int wins);
    int getWinStreak();
    EventsStatsBase setWinStreak(final int winStreak);
    int getGamesPlayed();
    EventsStatsBase setGamesPlayed(final int gamesPlayed);
    int getExperience();
    EventsStatsBase setExperience(final int experience);
    int getLosses();
    EventsStatsBase setLosses(final int losses);
    int getBestWinStreak();
    EventsStatsBase setBestWinStreak(final int bestWinStreak);
    int getMoneyWon();

    /**
     * Add to the collectable money won by this player
     * @param amount
     * @return
     */
    int addToMoneyWon(final int amount);

    int getInt(final EventsStatsBase.Values values);
    boolean getBoolean(final EventsStatsBase.Values values);
    EventsStatsBase setInt(final EventsStatsBase.Values values, final int integer);
    EventsStatsBase setBoolean(final EventsStatsBase.Values values, final boolean value);

    /**
     * Gets primitive value from Values
     * @param values
     * @param type
     * @param <T>
     * @return
     */
    <T> T getPrimitive(final EventsStatsBase.Values values, final Class<T> type);

    String toJson();
    EventsStatsBase clone();
}