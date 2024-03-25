package club.hellin.vivillyapi.utils;

import club.hellin.vivillyapi.models.impl.objects.CourseEntryBase;
import club.hellin.vivillyapi.utils.api.ServerType;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.InventoryView;

import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public abstract class Utils {
    public static final ExecutorService SERVICE = Executors.newCachedThreadPool();
    public static final double LEVEL_DENOMINATOR = 1000.0D;

    public static Utils utils;

    /**
     * This converts the field name to a sql/json friendly name
     *
     * @param fieldName
     * @return
     */
    public static String prettyName(final String fieldName) {
        final StringBuilder builder = new StringBuilder();
        final char[] chars = fieldName.toCharArray();

        for (int i = 0; i < chars.length; ++i) {
            final char c = chars[i];
            char cPlusOne = c;

            if (i < chars.length - 1)
                cPlusOne = chars[i + 1];

            final String cStr = String.valueOf(c);
            final String cPlusOneStr = String.valueOf(cPlusOne);

            if (cStr.equals(cStr.toUpperCase()) && cPlusOneStr.equals(cPlusOneStr.toLowerCase()) && Character.isLetter(cPlusOneStr.toCharArray()[0])) {
                builder.append(String.format("_%s", cStr.toLowerCase()));
                continue;
            }

            builder.append(cStr);
        }

        return builder.toString();
    }

    public abstract String getStar(final int level);

    public abstract ChatColor getColor(final int level);

    public abstract boolean isOnline(final Player player);

    public abstract boolean isVanished(final Player player);

    public abstract double getLevel(final Player p, final ServerType type);

    public abstract double getLevel(final UUID uuid, final ServerType type);

    public abstract double calculateLevel(final double experience);

    public abstract String getPrefix(final Player p);

    public abstract String getPrefix(final String rank);

    public abstract String formatInteger(final int integer);

    public abstract String formatNumber(final double d);

    public abstract String getInventoryName(final InventoryView view);

    public abstract CourseEntryBase createCourseEntry(final String uuid, final int time, final int rocketsUsed, final int timesHitGround, final long finishedAt);
}