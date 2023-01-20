package kr.sbxt.xtheia.theia.ink.color;

public record RGB(int r, int g, int b) implements IColor
{
	public RGB(int r, int g, int b)
	{
		this.r = r;
		this.g = g;
		this.b = b;
	}
	
	public RGB(int rgb)
	{
		this((rgb >> 16) & 0xFF, (rgb >> 8) & 0xFF, (rgb >> 0) & 0xFF);
	}
	
	
	@Override
	public RGB getRGB()
	{
		return this;
	}
}
