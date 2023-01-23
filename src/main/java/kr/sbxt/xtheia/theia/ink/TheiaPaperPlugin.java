package kr.sbxt.xtheia.theia.ink;

import kr.sbxt.xtheia.theia.ink.color.Colors;
import kr.sbxt.xtheia.theia.ink.color.RGB;
import net.kyori.adventure.text.Component;
import org.bukkit.Server;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemFactory;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;

import java.awt.*;

public abstract class TheiaPaperPlugin extends JavaPlugin
{
	private static final int _LOG_PREFIX_COLOR_HASH_PRECISION = 256;
	
	protected static RGB hashColor;
	protected static Component logPrefix, pluginNameComponent;
	
	protected static TheiaPaperPlugin current;
	protected static Server currentServer;
	protected static ItemFactory itemFactory;
	protected static BukkitScheduler scheduler;
	protected static ConsoleCommandSender consoleCommandSender;
	
	protected TheiaPaperPlugin()
	{
		current = this;
		final var pluginName = current.getName();
		hashColor = new RGB(Color.HSBtoRGB((float) Math.abs(pluginName.hashCode()) % _LOG_PREFIX_COLOR_HASH_PRECISION / _LOG_PREFIX_COLOR_HASH_PRECISION, 0.4f, 1f));
		logPrefix = Comp.tc("X/", Colors.LEGACY_AQUA).append(Comp.tc(pluginName + "/", hashColor));
		pluginNameComponent = Comp.tc(pluginName, hashColor);
	}
	
	@Override
	public void onLoad()
	{
		final var _server = currentServer = getServer();
		itemFactory = _server.getItemFactory();
		scheduler = _server.getScheduler();
		consoleCommandSender = _server.getConsoleSender();
		
		log(pluginNameComponent.append(Comp.t(" initiated ")).append(Comp.tc(" Successfully!", Colors.LEGACY_GREEN)));
		final var isInkPluginMode = getServer().getPluginManager().getPlugin("Ink") != null;
		log(Comp.a(
				Comp.t("Powered by "), Comp.
						tc("INK", Colors.LEGACY_AQUA), Comp.t
						("! ("), isInkPluginMode ?
						Comp.tc("Plugin", Colors.QUASAR) : Comp.tc("Shadow", Colors.LEGACY_AQUA), Comp.t(")")
		));
	}
	
	public static TheiaPaperPlugin CurrentPlugin()
	{
		return current;
	}
	
	public static Server CurrentServer()
	{
		return currentServer;
	}
	
	public static void RegisterServerEventListener(Listener listener)
	{
		currentServer.getPluginManager().registerEvents(listener, current);
	}
	
	public static ItemFactory ItemFactory()
	{
		return itemFactory;
	}
	
	public static BukkitScheduler ServerScheduler()
	{
		return scheduler;
	}
	
	public static ConsoleCommandSender ConsoleCommandSender()
	{
		return consoleCommandSender;
	}
	
	public static RGB PluginNameHashColor()
	{
		return hashColor;
	}
	
	public static Component PluginLogPrefix()
	{
		return logPrefix;
	}
	
	public static void log(String msg)
	{
		Log.info(msg);
	}
	
	public static void log(Component msg)
	{
		Log.info(msg);
	}
}
