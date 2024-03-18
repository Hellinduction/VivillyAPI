package club.hellin.vivillyapi.models.impl.objects;

import club.hellin.vivillyapi.models.ModelBase;
import club.hellin.vivillyapi.utils.Utils;
import lombok.Getter;

public interface AppWarsStatsBase extends ModelBase {
    @Getter
    enum Values implements StatValues { // Not too proud of this one
        GAMES_PLAYED("gamesPlayed", 0),
        EXPERIENCE("experience", 1000),
        WINS("wins", 0),
        LOSSES("losses", 0),
        WIN_STREAK("winStreak", 0),
        BEST_WIN_STREAK("bestWinStreak", 0),
        ROUNDS_WON("roundsWon", 0);

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
    AppWarsStatsBase setGamesPlayed(final int gamesPlayed);
    int getExperience();
    AppWarsStatsBase setExperience(final int experience);
    int getWins();
    AppWarsStatsBase setWins(final int wins);
    int getLosses();
    AppWarsStatsBase setLosses(final int losses);
    int getWinStreak();
    AppWarsStatsBase setWinStreak(final int winStreak);
    int getBestWinStreak();
    AppWarsStatsBase setBestWinStreak(final int bestWinStreak);
    int getRoundsWon();
    AppWarsStatsBase setRoundsWon(final int roundsWon);
    AppWarsStatsBase incrementGamesPlayed();
    AppWarsStatsBase incrementWins();
    AppWarsStatsBase incrementLosses();
    AppWarsStatsBase incrementWinStreak();
    AppWarsStatsBase incrementBestWinStreak();
    AppWarsStatsBase incrementRoundsWon();
    int getInt(final Values values);
    String toJson();
    AppWarsStatsBase clone();
}