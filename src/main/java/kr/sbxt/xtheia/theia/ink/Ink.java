package kr.sbxt.xtheia.theia.ink;

import kr.sbxt.xtheia.theia.ink.color.Colors;
import net.kyori.adventure.text.Component;
import org.bukkit.Server;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.inventory.ItemFactory;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;

public final class Ink extends JavaPlugin
{
	static Ink current;
	static ConsoleCommandSender componentLogger;
	static Server currentServer;
	static ItemFactory itemFactory;
	static BukkitScheduler scheduler;
	
	@Override
	public void onEnable()
	{
		// Plugin startup logic
		current = this;
		currentServer = getServer();
		componentLogger = currentServer.getConsoleSender();
		itemFactory = currentServer.getItemFactory();
		
		Log.info(Comp.tc("Ink Enabled Successfully!", Colors.LEGACY_AQUA));
		Log.info(Comp.a(Comp.t("Powered by "), Comp.tc("THEIA Core", Colors.LEGACY_YELLOW), Comp.t(" from "), Comp.tc("XTHEIA", Colors.LEGACY_AQUA)));
	}
	
	public static void logPluginLoaded(Plugin plugin)
	{
		Log.info(Comp.tc(plugin.getName() + " Enabled Successfully!", Colors.LEGACY_AQUA));
		Log.info(Comp.a(Comp.t("Powered by "), Comp.tc("Ink", Colors.LEGACY_YELLOW), Comp.t(" from "), Comp.tc("XTHEIA", Colors.LEGACY_AQUA)));
	}
	
	public static Server getCurrentServer()
	{
		return currentServer;
	}
	
	public static ItemFactory getItemFactory()
	{
		return itemFactory;
	}
	
	
}
