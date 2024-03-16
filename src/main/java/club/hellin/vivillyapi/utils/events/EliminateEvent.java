package club.hellin.vivillyapi.utils.events;

import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerEvent;

public final class EliminateEvent extends PlayerEvent {
    private static final HandlerList handlers = new HandlerList();

    public EliminateEvent(final Player who) {
        super(who);
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }
}