package kr.sbxt.xtheia.theia.ink;

import org.bukkit.util.Vector;

public final class Line
{
	private final double x1, y1, z1, x2, y2, z2;
	
	public Line(double x1, double y1, double z1, double x2, double y2, double z2)
	{
		this.x1 = x1;
		this.y1 = y1;
		this.z1 = z1;
		this.x2 = x2;
		this.y2 = y2;
		this.z2 = z2;
	}
	
	public Line(Vector p1, Vector p2)
	{
		this(p1.getX(), p1.getY(), p1.getZ(), p2.getX(), p2.getY(), p2.getZ());
	}
	
	public Line(Vector p1, Vector dir, double dist)
	{
		this(p1, p1.clone().add(dir.clone().normalize().multiply(dist)));
	}
	
	
	public Vector getP1()
	{
		return new Vector(x1, y1, z1);
	}
	
	public Vector getP2()
	{
		return new Vector(x2, y2, z2);
	}
	
	public double getLength()
	{
		return getP1().distance(getP2());
	}
	
	public Vector asDirection()
	{
		return getP1().subtract(getP2());
	}
}
