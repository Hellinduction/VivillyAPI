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
        MONEY_WON("moneyWon", 0), // This is money that is won and can be collected (through some way) on the SMP

        BED_WARS_ONE_HIT_ONE_KILL("bedWarsOneHitOneKill", false),
        BED_WARS_HEALTH_BUFF("bedWarsHealthBuff", 0),
        BED_WARS_LOW_GRAVITY("bedWarsLowGravity", false),
        BED_WARS_SPEED("bedWarsSpeed", 0),
        BED_WARS_RESPAWN_TIME("bedWarsRespawnTime", 5),
        BED_WARS_EVENT_TIMES("bedWarsEventTimes", 1),
        BED_WARS_NO_EMERALDS("bedWarsNoEmeralds", false),
        BED_WARS_NO_DIAMONDS("bedWarsNoDiamonds", false),
        BED_WARS_DISABLE_BLOCK_PROTECTION("bedWarsDisableBlockProtection", false),
        BED_WARS_BED_INSTA_BREAK("bedWarsBedInstaBreak", false),
        BED_WARS_MAX_TEAM_UPGRADES("bedWarsMaxTeamUpgrades", false),
        BED_WARAS_NO_HIT_DELAY("bedWarsNoHitDelay", false),
        BED_WARS_EVERYTHING_FREE("bedWarsEverythingFree", false),
        BED_WARS_ALL_ROTATING_ITEMS("bedWarsAllRotatingItems", false),

        BED_WARS_APPLY_SETTINGS("bedWarsApplySettings", false),

        MICRO_BATTLES_KIT("microBattlesKit", "Archer");

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

    boolean isBedWarsOneHitOneKill();
    EventsStatsBase setBedWarsOneHitOneKill(final boolean value);
    int getBedWarsHealthBuff();
    EventsStatsBase setBedWarsHealthBuff(final int value);
    boolean isBedWarsLowGravity();
    EventsStatsBase setBedWarsLowGravity(final boolean value);
    int getBedWarsSpeed();
    EventsStatsBase setBedWarsSpeed(final int value);
    int getBedWarsRespawnTime();
    EventsStatsBase setBedWarsRespawnTime(final int value);
    int getBedWarsEventTimes();
    EventsStatsBase setBedWarsEventTimes(final int value);
    boolean isBedWarsNoEmeralds();
    EventsStatsBase setBedWarsNoEmeralds(final boolean value);
    boolean isBedWarsNoDiamonds();
    EventsStatsBase setBedWarsNoDiamonds(final boolean value);
    boolean isBedWarsDisableBlockProtection();
    EventsStatsBase setBedWarsDisableBlockProtection(final boolean value);
    boolean isBedWarsBedInstaBreak();
    EventsStatsBase setBedWarsBedInstaBreak(final boolean value);
    boolean isBedWarsMaxTeamUpgrades();
    EventsStatsBase setBedWarsMaxTeamUpgrades(final boolean value);
    boolean isNoHitDelay();
    EventsStatsBase setNoHitDelay(final boolean value);
    boolean isEverythingFree();
    EventsStatsBase setEverythingFree(final boolean value);
    boolean isAllRotatingItems();
    EventsStatsBase setAllRotatingItems(final boolean value);

    boolean isBedWarsApplySettings();
    EventsStatsBase setBedWarsApplySettings(final boolean value);

    String getMicroBattlesKit();
    EventsStatsBase setMicroBattlesKit(final String value);

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