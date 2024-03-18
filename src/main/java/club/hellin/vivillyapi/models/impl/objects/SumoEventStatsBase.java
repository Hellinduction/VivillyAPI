package club.hellin.vivillyapi.models.impl.objects;

import club.hellin.vivillyapi.models.ModelBase;
import club.hellin.vivillyapi.utils.Utils;
import lombok.Getter;

public interface SumoEventStatsBase extends ModelBase {
    @Getter
    enum Values implements StatValues {
        GAMES_PLAYED("gamesPlayed", 0),
        EXPERIENCE("experience", 1000),
        WINS("wins", 0),
        LOSSES("losses", 0),
        KILLS("kills", 0),
        WIN_STREAK("winStreak", 0),
        BEST_WIN_STREAK("bestWinStreak", 0),
        KILL_STREAK("killStreak", 0),
        BEST_KILL_STREAK("bestKillStreak", 0),
        WIN_EFFECT("winEffect", "FIREWORKS"),
        PERK("perk", "NONE"),
        KB_STICK_LEVEL("kbStickLevel", 0),
        MAP_BREAKING("mapBreaking", false),
        AUTO_STARTING("autoStarting", true),
        PEARL_MANIA("pearlMania", false),
        DEATH_MATCH("deathMatch", true),
        UNLOCK_PERKS("unlockPerks", false),
        CHEST_REFILL_TIME("chestRefillTime", 300),
        COOL_DOWNS("coolDowns", true),
        FALL_DAMAGE("fallDamage", false),
        ALLOW_MAP_ESCAPING("allowMapEscaping", false),
        WAND_MAP_BREAKING("wandMapBreaking", false);

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
    int getGamesPlayed();
    int getExperience();
    int getWins();
    int getLosses();
    int getKills();
    int getWinStreak();
    int getBestWinStreak();
    int getKillStreak();
    int getBestKillStreak();
    String getWinEffect();
    String getPerk();
    int getKbStickLevel();
    boolean isMapBreaking();
    boolean isAutoStarting();
    boolean isPearlMania();
    boolean isDeathMatch();
    boolean isUnlockPerks();
    int getChestRefillTime();
    boolean isCoolDowns();
    boolean isFallDamage();
    boolean isAllowMapEscaping();
    boolean isWandMapBreaking();
    SumoEventStatsBase setGamesPlayed(final int gamesPlayed);
    SumoEventStatsBase setExperience(final int experience);
    SumoEventStatsBase setWins(final int wins);
    SumoEventStatsBase setLosses(final int losses);
    SumoEventStatsBase setKills(final int kills);
    SumoEventStatsBase setWinStreak(final int winStreak);
    SumoEventStatsBase setBestWinStreak(final int bestWinStreak);
    SumoEventStatsBase setKillStreak(final int killStreak);
    SumoEventStatsBase setBestKillStreak(final int bestKillStreak);
    SumoEventStatsBase setWinEffect(final String winEffect);
    SumoEventStatsBase setPerk(final String perk);
    SumoEventStatsBase setKbStickLevel(final int kbStickLevel);
    SumoEventStatsBase setMapBreaking(final boolean mapBreaking);
    SumoEventStatsBase setAutoStarting(final boolean autoStarting);
    SumoEventStatsBase setPearlMania(final boolean pearlMania);
    SumoEventStatsBase setDeathMatch(final boolean deathMatch);
    SumoEventStatsBase setUnlockPerks(final boolean unlockPerks);
    SumoEventStatsBase setChestRefillTime(final int chestRefillTime);
    SumoEventStatsBase setCoolDowns(final boolean coolDowns);
    SumoEventStatsBase setFallDamage(final boolean fallDamage);
    SumoEventStatsBase setAllowMapEscaping(final boolean allowMapEscaping);
    SumoEventStatsBase setWandMapBreaking(final boolean wandMapBreaking);
    SumoEventStatsBase setTemporaryWinEffect(final String winEffect);
    SumoEventStatsBase setTemporaryPerk(final String perk);
    SumoEventStatsBase incrementGamesPlayed();
    SumoEventStatsBase incrementWins();
    SumoEventStatsBase incrementLosses();
    SumoEventStatsBase incrementKills();
    SumoEventStatsBase incrementWinStreak();
    SumoEventStatsBase incrementBestWinStreak();
    SumoEventStatsBase incrementKillStreak();
    SumoEventStatsBase incrementBestKillStreak();
    int getInt(final Values values);
    boolean getBoolean(final Values values);
    SumoEventStatsBase setInt(final Values values, final int integer);
    SumoEventStatsBase setBoolean(final Values values, final boolean value);

    /**
     * Gets primitive value from Values
     * @param values
     * @param type
     * @param <T>
     * @return
     */
    <T> T getPrimitive(final Values values, final Class<T> type);

    String toJson();
    SumoEventStatsBase clone();
}