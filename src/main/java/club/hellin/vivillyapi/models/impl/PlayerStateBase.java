package club.hellin.vivillyapi.models.impl;

import club.hellin.vivillyapi.SpigotCoreBase;
import club.hellin.vivillyapi.models.ModelBase;
import club.hellin.vivillyapi.models.impl.objects.*;
import club.hellin.vivillyapi.utils.AutoJoinType;
import club.hellin.vivillyapi.utils.ChatType;

import java.util.Collection;
import java.util.UUID;
import java.util.function.Consumer;

public interface PlayerStateBase extends ModelBase {
    int getId();
    String getUuid();
    String getUsername();
    PlayerStateBase setUsername(final String username);
    boolean isVanished();
    PlayerStateBase setVanished(final boolean vanished);
    SumoEventStatsBase getSumoEventStats();
    AppWarsStatsBase getAppWarsStats();
    ArenaStatsBase getArenaStats();
    EventsStatsBase getEventsStats();
    boolean hasForceField();
    PlayerStateBase hasForceField(final boolean forceField);
    boolean hasMagnet();
    PlayerStateBase hasMagnet(final boolean magnet);
    boolean isCrashBanned();
    PlayerStateBase setCrashBanned(final boolean crashBanned);
    int getTokens();
    PlayerStateBase setTokens(final int tokens);
    String getNickname();
    PlayerStateBase setNickname(final String nickname);
    String getApiKey();
    PlayerStateBase setApiKey(final String apiKey);
    AutoJoinType getAutoJoin();
    PlayerStateBase setAutoJoin(final AutoJoinType type);
    boolean isBusy();
    PlayerStateBase setBusy(final boolean busy);
    double getForceMultiplier();
    PlayerStateBase setForceMultiplier(final double forceMultiplier);
    ChatType getChatType();
    PlayerStateBase setChatType(final ChatType type);
    String getServer();
    PlayerStateBase setServer(final String server);
    String getProxy();
    PlayerStateBase setProxy(final String proxy);
    Collection<String> getIgnored();
    PlayerStateBase getClone();
    PlayerStateBase original();
    boolean hasChanged();
    PlayerStateBase addTokens(final int amount);
    PlayerStateBase useToken() throws NotEnoughTokensException;
    PlayerStateBase useTokens(final int amounts) throws NotEnoughTokensException;
    boolean hasEnoughTokens(final int amount);

    /**
     * Returns how many tokens this player needs until they reach the desired amount
     *
     * @param amount
     * @return
     */
    int requiredTokens(final int amount);

    boolean hasNickname();
    boolean isAutoJoin();
    void isOnline(final Consumer<Boolean> callback);
    void send(final String server);
    default void sudo(final String command, final boolean proxy) {
        SpigotCoreBase.INSTANCE.getWs().sudo(UUID.fromString(this.getUuid()), command, proxy);
    }

    /**
     * Updates the PlayerState in the DB and synchronizes across all servers
     * call this after you have finished making all your changes
     * WARNING: DO NOT WAIT TO CALL THIS!! CALL THIS AS SOON AS YOU HAVE THE CHANGES OTHERWISE YOU MAY CAUSE ISSUES!
     */
    default void update() {
        SpigotCoreBase.INSTANCE.getWs().updatePlayerState(this);
    }
}