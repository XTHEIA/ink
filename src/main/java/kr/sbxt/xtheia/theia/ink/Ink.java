package kr.sbxt.xtheia.theia.ink;

import kr.sbxt.xtheia.theia.ink.color.Colors;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.logger.slf4j.ComponentLogger;
import org.bukkit.Server;
import org.bukkit.inventory.ItemFactory;
import org.bukkit.plugin.java.JavaPlugin;

public final class Ink extends JavaPlugin
{
	
	private static ComponentLogger componentLogger;
	private static Server currentServer;
	private static ItemFactory itemFactory;
	
	@Override
	public void onEnable()
	{
		// Plugin startup logic
		currentServer = getServer();
		componentLogger = getComponentLogger();
		itemFactory = currentServer.getItemFactory();
		
		log(Comp.tc("Ink Enabled Successfully!", Colors.LEGACY_AQUA));
		log(Comp.a(Comp.t("Powered by "), Comp.tc("THEIA Core", Colors.LEGACY_YELLOW), Comp.t(" from "), Comp.tc("XTHEIA", Colors.LEGACY_AQUA)));
	}
	
	public static Server getCurrentServer()
	{
		return currentServer;
	}
	
	public static ItemFactory getItemFactory()
	{
		return itemFactory;
	}
	
	public static void log(String msg)
	{
		log(Comp.t(msg));
	}
	
	public static void log(Component msg)
	{
		componentLogger.info(msg);
	}
}
