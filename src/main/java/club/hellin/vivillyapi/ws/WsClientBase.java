package club.hellin.vivillyapi.ws;

import club.hellin.vivillyapi.models.impl.PlayerStateBase;
import club.hellin.vivillyapi.utils.ChatType;
import club.hellin.vivillyapi.utils.api.ServerType;
import club.hellin.vivillyapi.utils.events.impl.FollowEvent;
import club.hellin.vivillyapi.utils.ws.events.EventBase;
import club.hellin.vivillyapi.utils.ws.events.EventType;
import club.hellin.vivillyapi.utils.ws.party.PartyBase;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.function.Consumer;
import java.util.function.Predicate;

public interface WsClientBase {
    Map<UUID, ? extends PlayerStateBase> getPlayerStateMap();
    Map<ServerType, Integer> getPlayerCountMap();
    Map<String, Integer> getPlayerCountServerNameMap();
    Map<UUID, FollowEvent.FollowData> getFollowEvents();
    List<? extends PartyBase> getParties();
    EventBase getActiveEvent();
    boolean isRestrictedMode();
    List<? extends PlayerStateBase> getVanished();
    List<? extends PlayerStateBase> getNonVanished(final boolean online);

    /**
     * Gets the online non-vanished players
     * The predicate acts as a filter to remove any Player objects that test true
     * @param predicate
     * @return
     */
    List<? extends PlayerStateBase> getNonVanished(final Predicate<Player> predicate);

    int getVanishedCount();
    int getNonVanishedCount(final boolean online);
    int getNonVanishedCount(final Predicate<Player> predicate);
    void broadcastToParty(final UUID uuid, final String message);
    void broadcastToParty(final UUID uuid, String message, final boolean formatColor);
    void sendPlayerVanishEvent(final UUID uuid, final boolean vanished);
    void inviteToParty(final UUID ownerUUID, final UUID uuid);
    void warpParty(final UUID ownerUUID, final boolean announce);
    void requestPlayerCountSynchronization();
    void setServerType(final String serverType);
    void setChatType(final UUID uuid, final ChatType type);
    void setServerName(final String name);
    void resetServer(final boolean delete);
    void createServer(final ServerType type);
    void send(final UUID uuid, final ServerType type);
    void setStarted(final boolean started);
    void follow(final UUID uuid, final String username);
    void rejoin(final UUID uuid);
    void setIgnored(final String uuid, final String toIgnore, final boolean ignored);
    void chatReport(final String reporterUUID, final String reportedUUID);
    void isLockedDown(final Consumer<Boolean> callback);
    void setLockedDown(final boolean lockedDown);
    void sudo(final UUID uuid, final String command, final boolean proxy);
    void clearDbCache();
    void announceGameStarting(final ServerType type, final String worldName, final int players, final int startingIn);
    void setLastWorld(final UUID uuid, final String world);
    void setWorldStarted(final String world, final boolean started);
    void isWorldStarted(final String serverName, final String worldName, final Consumer<Boolean> callback);
    void refreshLeaderboard();
    void sendToLobby(final UUID uuid);
    void isOnline(final UUID uuid, final Consumer<Boolean> callback);
    void send(final UUID uuid, final String server);
    void getServer(final UUID uuid, final Consumer<String> callback);
    void getUUID(final String username, final Consumer<UUID> callback);
    void getNames(final List<UUID> uuids, final Consumer<List<String>> callback);
    void getParty(final UUID uuid, final Consumer<? extends PartyBase> callback);
    void getPlayerState(final UUID uuid, final Consumer<? extends PlayerStateBase> callback);
    void getPlayerStateByUsername(final String username, final Consumer<? extends PlayerStateBase> callback);
    void getServers(final Consumer<List<String>> callback);
    void getParties(final Consumer<List<? extends PartyBase>> callback);
    void updatePlayerState(final PlayerStateBase state);
    void hasStarted(final Consumer<Boolean> callback);
    void isInParty(final UUID uuid, final Consumer<Boolean> callback);
    void isFollowing(final UUID uuid, final String username, final Consumer<Boolean> callback);
    void send(final String str);
    void broadcastToEvent(final String message);
    void getCurrentEvent(final Consumer<EventBase> callback);
    void isInEvent(final UUID uuid, final Consumer<Boolean> callback);
    void announceEvent(final int startingIn);

    /**
     * Get the current active event and make the event server start
     * When event server connects to the websocket, it should get the current event and set that to its type
     */
    void startCurrentEvent();
}