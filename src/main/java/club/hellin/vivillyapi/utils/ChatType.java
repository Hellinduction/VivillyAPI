package club.hellin.vivillyapi.utils;

import lombok.Getter;

@Getter
public enum ChatType {
    ALL, A(true),
    PARTY, P(true),
    STAFF, S(true);

    private final boolean hide;

    ChatType() {
        this(false);
    }

    ChatType(final boolean hide) {
        this.hide = hide;
    }
}