package club.hellin.vivillyapi.utils.ws.party;

import org.bukkit.entity.Player;
import org.json.JSONObject;

import java.util.List;
import java.util.UUID;

public interface PartyBase {
    String getName();
    UUID getOwner();
    List<UUID> getMembers();
    List<UUID> getInvited();
    boolean isMuted();
    PartyBase setMuted(final boolean muted);
    boolean isPublic();
    PartyBase setPublic(final boolean isPublic);
    boolean isPrivate();
    PartyBase setPrivate(final boolean isPrivate);
    boolean isDisbanded();
    PartyBase setDisbanded(final boolean disbanded);
    void parse(final String json);
    PartyBase addMember(final UUID uuid);
    PartyBase removeMember(final UUID uuid);
    JSONObject toJson();
    void update(final boolean create);
    PartyBase broadcast(final String message);
    PartyBase broadcast(final String message, final boolean formatColor);
    PartyBase invite(final UUID uuid);
    PartyBase warp(final boolean announce, final String serverName, final boolean force);
    boolean isOwner(final UUID uuid);
    boolean isOwner(final Player p);
    boolean isInvited(final UUID uuid);
    boolean isInvited(final Player p);
}