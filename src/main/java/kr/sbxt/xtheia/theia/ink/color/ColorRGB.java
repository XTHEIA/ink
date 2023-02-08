package kr.sbxt.xtheia.theia.ink.color;

/**
 * RGB 값을 각각 인자로 전달하기 편리하도록 만든 클래스. IColor을 상속받긴 하지만 이 클래스를 사용한다는 것은 R G B 값을 분리할 필요가 있는 것이기 때문에 성능을 따로 최적화하지 않음.
 *
 * @param r
 * @param g
 * @param b
 */
public record ColorRGB(int r, int g, int b) implements _ITextColor
{
	public ColorRGB(int r, int g, int b)
	{
		this.r = r;
		this.g = g;
		this.b = b;
	}
	
	@Override
	public ColorInt getInt()
	{
		return new ColorInt(ColorUtility.toInt(r, g, b));
	}
	
	@Override
	public ColorRGB getRGB()
	{
		return this;
	}
}
