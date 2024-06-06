package club.hellin.vivillyapi.utils.events;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.OfflinePlayer;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

@Getter
@Setter
public final class MoneyGiveEvent extends Event implements Cancellable {
    private static final HandlerList handlers = new HandlerList();

    private final OfflinePlayer who;

    private boolean cancelled = false;
    private double amount;

    public MoneyGiveEvent(final OfflinePlayer who, final double amount) {
        this.who = who;
        this.amount = amount;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}