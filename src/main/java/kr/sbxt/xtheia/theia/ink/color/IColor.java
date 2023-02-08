package kr.sbxt.xtheia.theia.ink.color;

import kr.sbxt.xtheia.theia.ink.Comp;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;

public interface IColor
{
	ColorInt getInt();
	
	ColorRGB getRGB();
	
	
	default org.bukkit.Color asBukkitColor()
	{
		return org.bukkit.Color.fromRGB(getInt().rgbValue());
	}
	
	default String asHex()
	{
		return "#" + asHexWithoutSharp();
	}
	
	
	default String asHexWithoutSharp()
	{
		return String.format("%06x", getInt().rgbValue());
	}
	
	default Component asHexComponent()
	{
		return Comp.hexColor(getInt().rgbValue());
	}
	
	default TextColor asTextColor()
	{
		return TextColor.color(getInt());
	}
}
