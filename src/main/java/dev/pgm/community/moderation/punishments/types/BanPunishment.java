package dev.pgm.community.moderation.punishments.types;

import dev.pgm.community.moderation.ModerationConfig;
import dev.pgm.community.moderation.punishments.PunishmentBase;
import dev.pgm.community.moderation.punishments.PunishmentType;
import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

public class BanPunishment extends PunishmentBase {

  public BanPunishment(
      UUID punishmentId,
      UUID targetId,
      Optional<UUID> issuerId,
      String reason,
      Instant timeIssued,
      boolean active,
      Instant lastUpdated,
      Optional<UUID> lastUpdatedBy,
      String service,
      ModerationConfig config) {
    super(
        punishmentId,
        targetId,
        issuerId,
        reason,
        timeIssued,
        active,
        lastUpdated,
        lastUpdatedBy,
        service,
        config);
  }

  @Override
  public boolean punish(boolean silent) {
    return kick(silent);
  }

  @Override
  public PunishmentType getType() {
    return PunishmentType.BAN;
  }
}
