package club.hellin.vivillyapi.commands.impl;

public abstract class ToggleStatsBase {
    public static ToggleStatsBase INSTANCE;

    /**
     * Make sure to call super() when extending this class in the constructor
     */
    public ToggleStatsBase() {
        INSTANCE = this;
    }

    public abstract boolean isStatsEnabled(final String worldName);

    public abstract void setStatsEnabled(final String worldName, final boolean enabled);
}