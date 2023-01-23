package kr.sbxt.xtheia.theia.ink.vector;

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
	
	/**
	 * (0,vectorY,0) 기준, 반지름이 radius인 원의 angleRadian 각도의 위치를 반환합니다.
	 * @param radius
	 * @param angleRadian
	 * @param vectorY
	 * @return
	 */
	public static Vector getCirclePointRadian(double radius, double angleRadian, double vectorY)
	{
		return new Vector(Math.cos(angleRadian) * radius, vectorY, Math.sin(angleRadian) * radius);
	}
	
	
}
