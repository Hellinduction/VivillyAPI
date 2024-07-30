package club.hellin.vivillyapi.utils.ws.events;

import lombok.Getter;

@Getter
public enum EventType {
    KOTH,
    DEATH_SWAP,
    TNT_TAG,
    LAVA_RISING,
    SPLEEF,
    TNT_RUN,
    SLIMY,
    MAN_HUNT,
    FFA,
    SUMO_KNOCKOUT,
    BED_WARS,
    UNFAIR_FFA,
    BED_BOMB,
    MICRO_BATTLES,
    PILLARS_OF_FORTUNE(8),
    BLOCK_HUNT;

    private final int players;

    EventType() {
        this(-1);
    }

    EventType(final int players) {
        this.players = players;
    }
}