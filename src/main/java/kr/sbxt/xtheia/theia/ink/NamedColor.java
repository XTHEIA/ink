package kr.sbxt.xtheia.theia.ink;

import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import java.util.ArrayList;

public interface NamedColor extends ColorCore
{
	String getColorName();
	
	String getColorDescription();
	
	default ItemStack asItemStack()
	{
		final var lores = new ArrayList<Component>();
		if (getColorDescription() != null)
		{
			lores.add(Comp.t(getColorDescription()));
		}
		final var item = ItemStackCreator.simple(Material.LEATHER_CHESTPLATE, false, 1, asHexComponent(), lores);
		item.editMeta(meta ->
		{
			if (meta instanceof LeatherArmorMeta leatherMeta)
			{
				leatherMeta.setColor(asBukkitColor());
				meta.addItemFlags(ItemFlag.HIDE_DYE);
			}
		});
		return item;
	}
}
