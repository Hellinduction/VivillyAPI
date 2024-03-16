package club.hellin.vivillyapi.utils.events.impl;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.entity.Player;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
public final class FollowEvent {
    public enum Reason {
        NONE,
        PARTY_WARP_COMMAND,
        PARTY_WARP,
        FOLLOW;
    }

    @AllArgsConstructor
    @Getter
    public static class FollowData {
        private final UUID followerUUID;
        private final UUID followedUUID;
        private final Reason reason;
    }

    private final long createdAt = Instant.now().getEpochSecond();
    private Player follower;
    private Player followed;
    private Reason reason = Reason.NONE;

    public FollowEvent(final Player follower, final Player followed) {
        this.follower = follower;
        this.followed = followed;
    }
}