package club.hellin.vivillyapi.utils;

import club.hellin.vivillyapi.SpigotCoreBase;
import club.hellin.vivillyapi.models.impl.PlayerStateBase;
import club.hellin.vivillyapi.models.impl.objects.EventsStatsBase;
import club.hellin.vivillyapi.models.impl.objects.SumoEventStatsBase;
import lombok.experimental.UtilityClass;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import java.util.Optional;
import java.util.UUID;
import java.util.function.Consumer;

@UtilityClass
public final class PlayerUtil {
    /**
     * Gets a PlayerState assuming player is online
     * @param uuid
     * @return
     */
    public PlayerStateBase getPlayerState(final UUID uuid) {
        final PlayerStateBase state = SpigotCoreBase.INSTANCE.getWs().getPlayerStateMap().get(uuid);
        return state;
    }


    /**
     * Gets a PlayerState assuming player is online
     * @param player
     * @return
     */
    public PlayerStateBase getPlayerState(final Player player) {
        return getPlayerState(player.getUniqueId());
    }

    public Optional<PlayerStateBase> getPlayerStateOptional(final UUID uuid) {
        return Optional.ofNullable(getPlayerState(uuid));
    }

    public Optional<PlayerStateBase> getPlayerStateOptional(final Player player) {
        return Optional.ofNullable(getPlayerState(player));
    }

    /**
     * Gets a PlayerState assuming player is online
     * @param username
     * @return
     */
    public PlayerStateBase getPlayerStateByUsername(final String username) {
        PlayerStateBase found = null;

        for (final PlayerStateBase state : SpigotCoreBase.INSTANCE.getWs().getPlayerStateMap().values()) {
            if (!state.getUsername().equalsIgnoreCase(username))
                continue;

            found = state;
            break;
        }

        return found;
    }

    public Optional<PlayerStateBase> getPlayerStateByUsernameOptional(final String username) {
        return Optional.ofNullable(getPlayerStateByUsername(username));
    }

    /**
     * Get stats of online player via uuid
     * @param uuid
     * @return
     */
    public SumoEventStatsBase getSumoEventStats(final UUID uuid) {
        final PlayerStateBase state = getPlayerState(uuid);

        if (state != null)
            return state.getSumoEventStats();

        return null;
    }

    /**
     * Get stats of online player via uuid
     * @param uuid
     * @return
     */
    public EventsStatsBase getEventsStats(final UUID uuid) {
        final PlayerStateBase state = getPlayerState(uuid);

        if (state != null)
            return state.getEventsStats();

        return null;
    }

    public void getOfflinePlayerState(final UUID uuid, final Consumer<PlayerStateBase> callback) {
        SpigotCoreBase.INSTANCE.getWs().getPlayerState(uuid, callback);
    }

    public void getOfflinePlayerState(final OfflinePlayer player, final Consumer<PlayerStateBase> callback) {
        getOfflinePlayerState(player.getUniqueId(), callback);
    }

    public void getOfflinePlayerStateByUsername(final String username, final Consumer<PlayerStateBase> callback) {
        SpigotCoreBase.INSTANCE.getWs().getPlayerStateByUsername(username, callback);
    }

    public OfflinePlayer getOfflinePlayer(final PlayerStateBase state) {
        final UUID uuid = UUID.fromString(state.getUuid());
        return Bukkit.getOfflinePlayer(uuid);
    }

    public Player getPlayer(final PlayerStateBase state) {
        final UUID uuid = UUID.fromString(state.getUuid());
        return Bukkit.getPlayer(uuid);
    }
}