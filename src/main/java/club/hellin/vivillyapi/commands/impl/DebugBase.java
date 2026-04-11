package club.hellin.vivillyapi.commands.impl;

import club.hellin.vivillyapi.SpigotCoreBase;

public abstract class DebugBase {
    @Deprecated
    public static DebugBase INSTANCE;

    /**
     * Make sure to call super() when extending this class in the constructor
     */
    public DebugBase() {
        INSTANCE = this;
        SpigotCoreBase.get().setDebugCommand(this);
    }

    public abstract boolean isDebugMode();
}