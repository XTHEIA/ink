package kr.sbxt.xtheia.theia.ink.utility;

import org.bukkit.*;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.util.RayTraceResult;
import org.bukkit.util.Vector;

public final class Castor
{
	public static void castBeam(final Location from, final Vector direction,
	                            final double damage, final double range,
	                            final Entity damageSource,
	                            double particleInterval, int particleCount, Color particleColor, float particleSize,
	                            Sound fireSound, float pitch)
	{
		
		if (particleInterval <= 0) particleInterval = 0.25f;
		if (particleCount <= 0) particleCount = 1;
		if (particleColor == null) particleColor = Color.RED;
		if (particleSize <= 0) particleSize = 0.3f;
		if (fireSound == null) fireSound = Sound.ENTITY_BLAZE_HURT;
		if (pitch <= 0) pitch = 1.0f;
		
		double _range = range;
		final int count = (int) ((float) range / particleInterval);
		final World world = from.getWorld();
		
		RayTraceResult rayTraceResult = from.getWorld().rayTrace(from, direction, range, FluidCollisionMode.NEVER, true, 0.01, (hit) -> ! hit.equals(damageSource) && hit.isValid() && ! hit.isDead());
		
		Damageable hit = null;
		if (rayTraceResult != null)
		{
			final Location hitPos = rayTraceResult.getHitPosition().toLocation(world);
			_range = from.distance(hitPos);
			
			if (rayTraceResult.getHitEntity() instanceof Damageable _hit && _hit.isValid())
			{
				hit = _hit;
				_range = from.distance(_hit.getLocation());
				
				if (damageSource != null) { _hit.damage(damage, damageSource); }
				else { _hit.damage(damage); }
				
				//				if (ThreadLocalRandom.current().nextInt(1, 101) <= 40) {
				//					world.strikeLightningEffect(hitPos);
				//				}
				
				
				from.getWorld().playSound(from, Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1f, 2.0f);
				
			}
		}
		
		
		//		Ink.log(XFormatter.xformat(
		//				"살상 광선 시전: %sm, %s 파티클 렌더링됨.%s",
		//				(int) _range,
		//				count,
		//				hit != null
		//						? XFormatter.xformat(" (Hit: %s)", hit.getName())
		//						: ""
		//		));
		world.playSound(from, Sound.ITEM_TRIDENT_RETURN, 1f, 0.6f);
		world.playSound(from, fireSound, 1f, pitch);
		
		drawLinearParticle(from, direction, 2, range, new CastorParticleOption(0.1, 5, particleColor, particleSize));
	}
	
	
	public static void drawLinearParticle(Location from, final Vector direction, final double invisibleDist, final double maxDistance, CastorParticleOption particleOption)
	{
		final Vector normalizedDirection = direction.clone().normalize();
		final World world = from.getWorld();
		
		final Vector step = normalizedDirection.multiply(particleOption.distance());
		for (
				Vector _pos = from.toVector();
				_pos.distance(from.toVector()) <= maxDistance;
				_pos.add(step)
		)
		{
			if (_pos.distance(from.toVector()) >= invisibleDist)
			{
				world.spawnParticle(Particle.REDSTONE, _pos.getX(), _pos.getY(), _pos.getZ(), particleOption.count(), 0, 0, 0, 10, new Particle.DustOptions(particleOption.color(), particleOption.size()));
				
			}
		}
		
	}
	
	public static void drawLinearParticle(Location from, final Vector targetPoint, final double invisibleDist, CastorParticleOption particleOption)
	{
		final double dist = targetPoint.distance(from.toVector());
		final Vector direction = targetPoint.subtract(from.toVector());
		drawLinearParticle(from, direction, invisibleDist, dist, particleOption);
	}
	
	public static void castBeamToEntity(Location from, final LivingEntity target, final Entity damageSource, final double damage, final CastorParticleOption particleOption)
	{
		final Vector targetPos = target.getEyeLocation().toVector();
		final double dist = targetPos.distance(from.toVector());
		final Vector direction = targetPos.subtract(from.toVector());
		castBeam(from, direction, damage, dist, damageSource, particleOption.distance(), particleOption.count(), particleOption.color(), particleOption.size(), null, 0.7f);
	}
	
	public static void castBeamToEntity(LivingEntity source, final LivingEntity target, final double damage, final CastorParticleOption particleOption)
	{
		castBeamToEntity(source.getEyeLocation(), target, source, damage, particleOption);
	}
	
	
	public static void castBeam(final LivingEntity source, final Vector direction, final double damage, final double range, final double particleInterval, final int particleCount, final Color particleColor, float particleSize, Sound fireSound, float pitch)
	{
		castBeam(source.getEyeLocation(), direction, damage, range, source, particleInterval, particleCount, particleColor, particleSize, fireSound, pitch);
	}
	
	public static void castBeam(final LivingEntity source, final double damage, final double range, final double particleInterval, final int particleCount, final Color particleColor, float particleSize, Sound fireSound, float pitch)
	{
		castBeam(source.getEyeLocation(), source.getEyeLocation().getDirection(), damage, range, source, particleInterval, particleCount, particleColor, particleSize, fireSound, pitch);
	}
	
	public static void castBeam(final Entity source, final Vector direction, final double damage, final double range, final double particleInterval, final int particleCount, final Color particleColor, float particleSize, Sound fireSound, float pitch)
	{
		castBeam(source.getLocation(), direction, damage, range, source, particleInterval, particleCount, particleColor, particleSize, fireSound, pitch);
	}
	
	public static void castBeam(final Entity source, final double damage, final double range, final double particleInterval, final int particleCount, final Color particleColor, float particleSize, Sound fireSound, float pitch)
	{
		castBeam(source.getLocation(), source.getLocation().getDirection(), damage, range, source, particleInterval, particleCount, particleColor, particleSize, fireSound, pitch);
	}
}
