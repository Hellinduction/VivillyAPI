package club.hellin.vivillyapi.utils.events;

import club.hellin.vivillyapi.utils.ws.events.EventBase;
import lombok.Getter;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

@Getter
public final class EventStartEvent extends Event {
    private static final HandlerList handlers = new HandlerList();
    protected EventBase event;

    public EventStartEvent(final EventBase event) {
        super();

        this.event = event;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }
}