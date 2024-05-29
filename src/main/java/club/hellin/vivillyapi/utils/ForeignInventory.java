package club.hellin.vivillyapi.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.inventory.ItemStack;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public final class ForeignInventory {
    private final UUID owner;
    private final String server;
    private final ItemStack[] contents;

    @Override
    public boolean equals(final Object object) {
        if (!(object instanceof ForeignInventory))
            return false;

        final ForeignInventory inv = (ForeignInventory) object;
        return inv.getServer().equals(this.server);
    }
}