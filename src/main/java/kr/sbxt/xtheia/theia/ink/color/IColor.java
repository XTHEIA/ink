package kr.sbxt.xtheia.theia.ink.color;

import kr.sbxt.xtheia.theia.ink.Comp;
import kr.sbxt.xtheia.theia.ink.utility.ItemStacker;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;

public interface IColor
{
	
	RGB getRGB();
	
	default int getRGBInt()
	{
		return ColorUtility.rgb(getRGB());
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
	
	default ItemStack createItemStack(int qty)
	{
		final var item = ItemStacker.simple(Material.LEATHER_CHESTPLATE, false, qty, asHexComponent());
		item.editMeta(meta ->
		{
			if (meta instanceof LeatherArmorMeta leatherArmorMeta)
			{
				leatherArmorMeta.setColor(asBukkitColor());
			}
		});
		return item;
	}
	
	
}
