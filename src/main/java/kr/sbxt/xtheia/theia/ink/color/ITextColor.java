package kr.sbxt.xtheia.theia.ink.color;

import net.kyori.adventure.text.format.TextColor;

public interface ITextColor extends IColor, TextColor
{
	@Override
	default int value()
	{
		return getInt().rgbValue();
	}
}
