package club.hellin.vivillyapi.models.impl.objects;

import club.hellin.vivillyapi.models.ModelBase;
import club.hellin.vivillyapi.utils.Utils;
import lombok.Getter;

import java.util.List;

public interface ElytraStatsBase extends ModelBase {
    @Getter
    enum Values implements StatValues {
        COMPLETION_STREAK("completionStreak", 0),
        TIMES_COMPLETED("timesCompleted", 0);

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
    List<CourseEntryBase> getEntries();
    int getCompletionStreak();
    int getTimesCompleted();
    int getInt(final ElytraStatsBase.Values values);
    boolean getBoolean(final ElytraStatsBase.Values values);
    ElytraStatsBase setInt(final ElytraStatsBase.Values values, final int integer);
    ElytraStatsBase setBoolean(final ElytraStatsBase.Values values, final boolean value);

    /**
     * Gets primitive value from Values
     * @param values
     * @param type
     * @param <T>
     * @return
     */
    <T> T getPrimitive(final ElytraStatsBase.Values values, final Class<T> type);

    String toJson();
    ElytraStatsBase clone();
}