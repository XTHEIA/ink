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
	
	public static int rgb(RGB rgb)
	{
		return rgb(rgb.r(), rgb.g(), rgb.b());
	}
	
	
	public static org.bukkit.Color lerp(org.bukkit.Color c1, org.bukkit.Color c2, float weight)
	{
		final int originR = c1.getRed(),
				originG = c1.getGreen(),
				originB = c1.getBlue(),
				addiR = c2.getRed() - originR,
				addiG = c2.getGreen() - originG,
				addiB = c2.getBlue() - originB;
		
		return org.bukkit.Color.fromRGB(
				originR + (int) (weight * addiR),
				originG + (int) (weight * addiG),
				originB + (int) (weight * addiB)
		);
	}
	
	public static RGB lerp(RGB c1, RGB c2, float weight)
	{
		final int originR = c1.r(),
				originG = c1.g(),
				originB = c1.b(),
				addiR = c2.r() - originR,
				addiG = c2.g() - originG,
				addiB = c2.b() - originB;
		
		return new RGB(
				originR + (int) (weight * addiR),
				originG + (int) (weight * addiG),
				originB + (int) (weight * addiB)
		);
	}
}
