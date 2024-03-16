package club.hellin.vivillyapi.utils.events;

import java.util.function.Consumer;

public interface EventManagerBase {
    void register(final EventListenerBase listener);
    void call(final Consumer<EventListenerBase> consumer);
}