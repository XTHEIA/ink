package kr.sbxt.xtheia.theia.ink;

import kr.sbxt.xtheia.theia.ink.vector.VectorUtils;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public final class PlayerUtils
{
	
	public static Vector getPlayerCenter(Player player)
	{
		return player.getLocation().toVector().add(new Vector(0, 0.9, 0));
	}
	
	public static Location getPlayerCenterLocation(Player player)
	{
		return player.getLocation().add(0, 0.9, 0);
	}
	
	public static Vector getDirectionRelativePosition(Vector origin, Vector dir, Vector relativeOffset)
	{
		return origin.clone().add(getDirectionalPosition(dir, relativeOffset));
	}
	
	public static Vector getDirectionalPosition(Vector dir, Vector relativeOffset)
	{
		final var _dir = dir.clone().normalize();
		return new Vector(
				- ((_dir.getX() * relativeOffset.getZ()) + (_dir.getZ() * relativeOffset.getX())),
				relativeOffset.getY(),
				(_dir.getX() * relativeOffset.getX()) - (_dir.getZ() * relativeOffset.getZ())
		);
	}
	
	public static Location getDirectionRelativePosition(Location origin, Vector offset)
	{
		return origin.clone().add(getDirectionalPosition(origin.getDirection(), offset));
	}
	
	public static Location getPitchRelativeLocation(Location origin, Vector relativeOffset)
	{
		return origin.clone()
				.add(VectorUtils.getCirclePointRadian(
						Math.sqrt((relativeOffset.getX() * relativeOffset.getX()) + (relativeOffset.getZ() * relativeOffset.getZ())),
						Math.toRadians(origin.getYaw() + 180) + Math.atan2(relativeOffset.getZ(), relativeOffset.getX()),
						relativeOffset.getY()));
	}
}
