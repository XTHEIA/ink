package kr.sbxt.xtheia.theia.ink.color;

import kr.sbxt.xtheia.theia.ink.Comp;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;

public interface IColor
{
	
	RGB asRGB();
	
	default int getRGBInt()
	{
		return asRGB().asRGBInt();
	}
	
	default org.bukkit.Color asBukkitColor()
	{
		return org.bukkit.Color.fromRGB(getRGBInt());
	}
	
	default TextColor asTextColor()
	{
		return TextColor.color(getRGBInt());
	}
	
	default String asHexString()
	{
		return asTextColor().asHexString().substring(1);
	}
	
	default Component asHexComponent()
	{
		return Comp.hexColor(getRGBInt());
	}
	
	
}
