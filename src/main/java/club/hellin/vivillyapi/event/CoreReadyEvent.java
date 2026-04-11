package club.hellin.vivillyapi.event;

import club.hellin.vivillyapi.CoreAPI;
import lombok.Getter;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

@Getter
public final class CoreReadyEvent extends Event {
    private static final HandlerList handlers = new HandlerList();

    private final CoreAPI api;

    public CoreReadyEvent(final CoreAPI api) {
        this.api = api;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }
}