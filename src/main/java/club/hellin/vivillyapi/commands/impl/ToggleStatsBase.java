package club.hellin.vivillyapi.commands.impl;

import club.hellin.vivillyapi.SpigotCoreBase;

public abstract class ToggleStatsBase {
    @Deprecated
    public static ToggleStatsBase INSTANCE;

    /**
     * Make sure to call super() when extending this class in the constructor
     */
    public ToggleStatsBase() {
        INSTANCE = this;
        SpigotCoreBase.get().setToggleStatsCommand(this);
    }

    public abstract boolean isStatsEnabled(final String worldName);

    public abstract void setStatsEnabled(final String worldName, final boolean enabled);
}