package kr.sbxt.xtheia.theia.ink.color;

public final class ColorUtility
{
	public static int toInt(final int r, final int g, final int b)
	{
		return ((r & 0x0ff) << 16) | ((g & 0x0ff) << 8) | (b & 0x0ff);
	}
	public static int toInt(final ColorRGB rgb){
		return toInt(rgb.r(),rgb.g(),rgb.b());
	}
	
	public static ColorRGB toRGB(final int rgbInt)
	{
		return new ColorRGB((rgbInt >> 16) & 0xFF, (rgbInt >> 8) & 0xFF, (rgbInt >> 0) & 0xFF);
	}

	
	public static ColorRGB lerp(ColorRGB c1, ColorRGB c2, float weight)
	{
		final int originR = c1.r(),
				originG = c1.g(),
				originB = c1.b(),
				addiR = c2.r() - originR,
				addiG = c2.g() - originG,
				addiB = c2.b() - originB;
		
		return new ColorRGB(
				originR + (int) (weight * addiR),
				originG + (int) (weight * addiG),
				originB + (int) (weight * addiB)
		);
	}
	
}
