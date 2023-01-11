package kr.sbxt.xtheia.theia.ink;

import org.bukkit.util.Vector;

public final class VectorUtils
{
	public static Vector getCirclePointAngle(float radius, int angle, float vectorY)
	{
		final var angleRadian = Math.toRadians(angle);
		return getCirclePointRadian(radius, angleRadian, vectorY);
	}
	
	public static Vector getCirclePointAngle(float radius, int angle)
	{
		return getCirclePointRadian(radius, angle, 0f);
	}
	
	public static Vector getCirclePointRadian(double radius, double angleRadian, double vectorY)
	{
		return new Vector(Math.cos(angleRadian) * radius, vectorY, Math.sin(angleRadian) * radius);
	}
	
	
}
