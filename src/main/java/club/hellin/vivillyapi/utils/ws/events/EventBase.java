package club.hellin.vivillyapi.utils.ws.events;

import club.hellin.vivillyapi.models.impl.PlayerStateBase;
import org.bukkit.entity.Player;
import org.json.JSONObject;

import java.util.List;
import java.util.UUID;

/**
 * TODO: Make it ignore parties when transferring to and from the event server since parties are irrelevant
 * @return
 */
public interface EventBase {
    EventType getType();

    /**
     * Gets the Player UUID of the host of this event
     * @return
     */
    UUID getHost();

    List<UUID> getPlayers();

    /**
     * Gets the amount specified in /host <prize>
     * @return
     */
    int getPrizePool();

    EventBase setPrizePool(final int prizePool);
    void parse(final String json);
    JSONObject toJson();
    void update(final boolean create);
    EventBase addPlayer(final UUID uuid);
    EventBase delPlayer(final UUID uuid);
    EventBase broadcast(final String message);
    boolean isHost(final UUID uuid);
    default boolean isHost(final Player player) {
        return this.isHost(player.getUniqueId());
    }
    default EventBase givePrize(final PlayerStateBase state) {
        state.getEventsStats().addToMoneyWon(this.getPrizePool());
        state.update();
        return this;
    }
    boolean isOver();
    EventBase setOver(final boolean over);
    int playerCount();
}