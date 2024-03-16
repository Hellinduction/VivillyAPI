package club.hellin.vivillyapi.utils.events;

import club.hellin.vivillyapi.utils.events.impl.FollowEvent;

public interface EventListenerBase {
    /**
     * Called when a follower is transferred to the followed server after they join
     */
    void onFollow(final FollowEvent event);
}