package kr.sbxt.xtheia.theia.ink;

import kr.sbxt.xtheia.theia.theiacore.TheiaCore;
import net.kyori.adventure.text.logger.slf4j.ComponentLogger;
import org.bukkit.Server;
import org.bukkit.inventory.ItemFactory;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

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
		
		log("INK Enabled!");
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
		componentLogger.info(Comp.t(msg));
	}
}
