package kr.sbxt.xtheia.theia.ink;

import com.destroystokyo.paper.ParticleBuilder;
import kr.sbxt.xtheia.theia.ink.color.ColorInt;
import kr.sbxt.xtheia.theia.ink.color.ColorRGB;
import kr.sbxt.xtheia.theia.ink.color.ColorUtility;
import kr.sbxt.xtheia.theia.ink.server.Tasker;
import kr.sbxt.xtheia.theia.ink.vector.Line;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.World;
import org.bukkit.entity.LivingEntity;

public final class Particler
{
	public static void linearTransition(final World world, final Line line, final float interval, ParticleOption option, Particle.DustOptions start, Particle.DustOptions end)
	{
		final var origin = line.getP1();
		final double originX = origin.getX(), originY = origin.getY(), originZ = origin.getZ();
		final var destination = line.getP2();
		final var dif = destination.clone().subtract(origin);
		final var dist = dif.length();
		final var count = dist / interval;
		final var step = dif.clone().normalize().multiply(interval);
		final double stepX = step.getX(), stepY = step.getY(), stepZ = step.getZ();
		final var particleCount = option.count;
		final var offsetXZ = option.offsetXZ;
		final var offsetY = option.offsetY;
		final ColorRGB colorStart = ColorUtility.toRGB(start.getColor().asRGB()), colorEnd = ColorUtility.toRGB(end.getColor().asRGB());
		for (int i = 0; i < count; i += 1)
		{
			final var weight = i / (float) count;
			world.spawnParticle(Particle.REDSTONE, originX + (i * stepX), originY + (i * stepY), originZ + (i * stepZ), particleCount, offsetXZ, offsetY, offsetXZ, 0.01,
					new Particle.DustOptions(ColorUtility.lerp(colorStart, colorEnd, weight).asBukkitColor(), weight), true);
		}
	}
	
	public static void linearTransition(final World world, final Line line, final float interval, ParticleOption option, Color color, float sizeStart, float sizeEnd)
	{
		final var origin = line.getP1();
		final double originX = origin.getX(), originY = origin.getY(), originZ = origin.getZ();
		final var destination = line.getP2();
		final var dif = destination.clone().subtract(origin);
		final var dist = dif.length();
		final var count = dist / interval;
		final var step = dif.clone().normalize().multiply(interval);
		final double stepX = step.getX(), stepY = step.getY(), stepZ = step.getZ();
		final var particleCount = option.count;
		final var offsetXZ = option.offsetXZ;
		final var offsetY = option.offsetY;
		final var sizeAddi = sizeEnd - sizeStart;
		for (int i = 0; i < count; i += 1)
		{
			final var weight = i / (float) count;
			world.spawnParticle(Particle.REDSTONE, originX + (i * stepX), originY + (i * stepY), originZ + (i * stepZ), particleCount, offsetXZ, offsetY, offsetXZ, 0.01,
					new Particle.DustOptions(color, sizeStart + (weight * sizeAddi)), true);
		}
	}
	
	public static void linearTransition(final World world, final Line line, final float interval, ParticleOption option, float size, Color start, Color end)
	{
		linearTransition(world, line, interval, option, new Particle.DustOptions(start, size), new Particle.DustOptions(end, size));
		
	}
	
	
	public static void linear(final World world, final Line line, final float interval, ParticleOption option, final float size, Color color)
	{
		final var origin = line.getP1();
		final double originX = origin.getX(), originY = origin.getY(), originZ = origin.getZ();
		final var destination = line.getP2();
		final var dif = destination.clone().subtract(origin);
		final var dist = dif.length();
		final var count = dist / interval;
		final var step = dif.clone().normalize().multiply(interval);
		final double stepX = step.getX(), stepY = step.getY(), stepZ = step.getZ();
		final var particleCount = option.count;
		final var offsetXZ = option.offsetXZ;
		final var offsetY = option.offsetY;
		final var dustOption = new Particle.DustOptions(color, size);
		for (int i = 0; i < count; i += 1)
		{
			world.spawnParticle(Particle.REDSTONE, originX + (i * stepX), originY + (i * stepY), originZ + (i * stepZ), particleCount, offsetXZ, offsetY, offsetXZ, 0.01,
					dustOption, true);
		}
	}
	
	public static void linear(World world, Line line, float interval, ParticleBuilder particleBuilder)
	{
		final var origin = line.getP1();
		final double originX = origin.getX(), originY = origin.getY(), originZ = origin.getZ();
		final var destination = line.getP2();
		final var dif = destination.clone().subtract(origin);
		final var dist = dif.length();
		final var count = dist / interval;
		final var step = dif.clone().normalize().multiply(interval);
		final double stepX = step.getX(), stepY = step.getY(), stepZ = step.getZ();
		for (int i = 0; i < count; i += 1)
		{
			particleBuilder
					.location(new Location(world, originX + (i * stepX), originY + (i * stepY), originZ + (i * stepZ)))
					.spawn();
		}
	}
	
	
	public static void trailing(LivingEntity target, int durationTicks, ParticleBuilder particleBuilder)
	{
		final var height = target.getHeight();
		Tasker.repeatWithDuration(0, 1, durationTicks, () ->
		{
			particleBuilder
					.location(target.getLocation().add(0, height / 2, 0))
					.spawn();
		});
		
	}
	
	
	public static record ParticleOption(int count, double offsetXZ, double offsetY, double extra)
	{
	
	}
}
