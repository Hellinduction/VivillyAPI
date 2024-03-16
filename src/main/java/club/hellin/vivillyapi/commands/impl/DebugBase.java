package club.hellin.vivillyapi.commands.impl;

public abstract class DebugBase {
    public static DebugBase INSTANCE;

    /**
     * Make sure to call super() when extending this class in the constructor
     */
    public DebugBase() {
        INSTANCE = this;
    }

    public abstract boolean isDebugMode();
}