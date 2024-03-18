package club.hellin.vivillyapi.utils;

import club.hellin.vivillyapi.SpigotCoreBase;
import club.hellin.vivillyapi.models.impl.PlayerStateBase;
import lombok.experimental.UtilityClass;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

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