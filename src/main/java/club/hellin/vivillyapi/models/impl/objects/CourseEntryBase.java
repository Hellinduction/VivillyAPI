package club.hellin.vivillyapi.models.impl.objects;

import club.hellin.vivillyapi.models.ModelBase;
import club.hellin.vivillyapi.utils.Utils;
import lombok.Getter;

public interface CourseEntryBase extends ModelBase {
    @Getter
    enum Values implements StatValues {
        TIME("time", 0), // In seconds
        ROCKETS_USED("rocketsUsed", 0),
        TIMES_HIT_GROUND("timesHitGround", 0);

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
    int getTime();
    int getRocketsUsed();
    int getTimesHitGround();
    int getInt(final CourseEntryBase.Values values);
    boolean getBoolean(final CourseEntryBase.Values values);
    CourseEntryBase setInt(final CourseEntryBase.Values values, final int integer);
    CourseEntryBase setBoolean(final CourseEntryBase.Values values, final boolean value);

    /**
     * Gets primitive value from Values
     * @param values
     * @param type
     * @param <T>
     * @return
     */
    <T> T getPrimitive(final CourseEntryBase.Values values, final Class<T> type);

    String toJson();
    CourseEntryBase clone();
}