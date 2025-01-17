package dev.pgm.community.mutations.types;

import dev.pgm.community.mutations.MutationBase;
import dev.pgm.community.mutations.MutationType;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import tc.oc.pgm.api.match.Match;
import tc.oc.pgm.rage.RageMatchModule;
import tc.oc.pgm.util.material.Materials;

public class RageMutation extends MutationBase {

  public RageMutation(Match match) {
    super(match, MutationType.RAGE);
  }

  @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
  public void onPlayerDamage(EntityDamageByEntityEvent event) {
    if (isRageHit(event.getDamager())) {
      event.setDamage(1000);
    }
  }

  private boolean isRageHit(Entity entity) {
    return (entity instanceof Player
            && Materials.isWeapon(((Player) entity).getItemInHand().getType()))
        || (entity instanceof Projectile && ((Projectile) entity).getShooter() instanceof Player);
  }

  @Override
  public boolean canEnable() {
    return match.getModule(RageMatchModule.class) == null;
  }
}
