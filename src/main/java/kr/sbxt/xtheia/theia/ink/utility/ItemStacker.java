package kr.sbxt.xtheia.theia.ink.utility;

import kr.sbxt.xtheia.theia.ink.Comp;
import kr.sbxt.xtheia.theia.ink.TheiaPaperPlugin;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFactory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public final class ItemStacker
{
	private final static ItemFactory _ITEM_FACTORY;
	
	static
	{
		_ITEM_FACTORY = TheiaPaperPlugin.ItemFactory();
	}
	
	public static ItemStack simple(final Material material, final Component displayName)
	{
		return simple(material, false, 1, displayName);
	}
	
	public static ItemStack simple(final Material material, final boolean shiny, final Component displayName)
	{
		return simple(material, shiny, 1, displayName);
	}
	
	
	public static ItemStack simple(final Material material, final String display, final String... lores)
	{
		return simple(material, 1, display, lores);
	}
	
	public static ItemStack simple(final Material material, final int qty, final String displayName, final String... lores)
	{
		return simple(material, false, qty, displayName, lores);
	}
	
	public static ItemStack simple(final Material material, final boolean shiny, final int qty, final String displayName, final String... lores)
	{
		return simple(material, shiny, qty, Comp.t(displayName), Comp.fromStringLores(lores));
	}
	
	public static ItemStack simple(final Material material, final boolean shiny, final int qty, final Component displayName, final String lore, final String... lores)
	{
		final var loreLength = lores.length;
		final var arr = new String[loreLength + 1];
		arr[0] = lore;
		System.arraycopy(lores, 0, arr, 1, loreLength);
		return simple(material, shiny, qty, displayName, Comp.fromStringLores(arr));
		
	}
	
	public static ItemStack simple(final Material material, final boolean shiny, final int qty, final Component displayName, final Collection<Component> lores)
	{
		return simple(material, shiny, qty, displayName, Optional.ofNullable(lores).orElse(List.of()).toArray(new Component[0]));
	}
	
	public static ItemStack simple(final Material material, final boolean shiny, final int qty, final Component displayName, final Component... lores)
	{
		
		final var meta = _ITEM_FACTORY.getItemMeta(material);
		meta.displayName(displayName);
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		if (lores != null && lores.length > 0)
		{
			meta.lore(Arrays.stream(lores).toList());
		}
		if (shiny)
		{
			meta.addEnchant(Enchantment.DURABILITY, 1, true);
			meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		}
		final var item = new ItemStack(material, qty);
		item.setItemMeta(meta);
		return item;
	}
	
	public static ItemStack empty(final Material material)
	{
		final var meta = _ITEM_FACTORY.getItemMeta(material);
		meta.displayName(Component.empty());
		final var item = new ItemStack(material, 1);
		item.setItemMeta(meta);
		return item;
	}
}
