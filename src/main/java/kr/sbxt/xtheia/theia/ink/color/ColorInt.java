package kr.sbxt.xtheia.theia.ink.color;


/**
 * 색상을 가볍게 저장하고 싶을 때 int 대신에 쓰는 클래스.
 *
 * @param rgbValue
 */
public record ColorInt(int rgbValue) implements _ITextColor
{
	@Override
	public ColorInt getInt()
	{
		return this;
	}
	
	@Override
	public ColorRGB getRGB()
	{
		return ColorUtility.toRGB(rgbValue);
	}
}
