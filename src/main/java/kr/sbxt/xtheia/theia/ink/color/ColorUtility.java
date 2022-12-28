package kr.sbxt.xtheia.theia.ink.color;

public final class ColorUtility
{
	public static int rgb(int r, int g, int b)
	{
		return ((r & 0x0ff) << 16) | ((g & 0x0ff) << 8) | (b & 0x0ff);
	}
	
	public static RGB rgb(int rgb)
	{
		return new RGB((rgb >> 16) & 0xFF, (rgb >> 8) & 0xFF, (rgb >> 0) & 0xFF);
	}
}
