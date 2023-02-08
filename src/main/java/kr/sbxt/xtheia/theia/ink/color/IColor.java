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
