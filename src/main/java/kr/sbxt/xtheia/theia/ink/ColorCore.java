package kr.sbxt.xtheia.theia.ink;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;

public interface ColorCore
{
	int getRGB();
	
	default org.bukkit.Color asBukkitColor()
	{
		return org.bukkit.Color.fromRGB(getRGB());
	}
	
	default TextColor asTextColor()
	{
		return TextColor.color(getRGB());
	}
	
	default String asHexString()
	{
		return asTextColor().asHexString().substring(1);
	}
	
	default Component asHexComponent()
	{
		return Comp.hexColor(getRGB());
	}
	

}
