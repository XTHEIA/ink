package kr.sbxt.xtheia.theia.ink;

import kr.sbxt.xtheia.theia.ink.color.Colors;
import kr.sbxt.xtheia.theia.ink.color.RGB;
import net.kyori.adventure.text.Component;
import org.bukkit.Server;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.inventory.ItemFactory;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;

import java.awt.*;

public abstract class TheiaPaperPlugin extends JavaPlugin
{
	private static final int _LOG_PREFIX_COLOR_HASH_PRECISION = 256;
	
	protected static RGB hashColor;
	protected static Component logPrefix;
	
	protected static TheiaPaperPlugin current;
	protected static Server currentServer;
	protected static ItemFactory itemFactory;
	protected static BukkitScheduler scheduler;
	protected static ConsoleCommandSender consoleCommandSender;
	
	protected TheiaPaperPlugin()
	{
		current = this;
		final var pluginName = current.getName();
		hashColor = new RGB(Color.HSBtoRGB((float) Math.abs(pluginName.hashCode()) % _LOG_PREFIX_COLOR_HASH_PRECISION / _LOG_PREFIX_COLOR_HASH_PRECISION, 0.5f, 1f));
		logPrefix = Comp.tc("X/", Colors.LEGACY_AQUA).append(Comp.tc(pluginName + "/ ", hashColor));
	}
	
	@Override
	public void onLoad()
	{
		final var _server = currentServer = getServer();
		itemFactory = _server.getItemFactory();
		scheduler = _server.getScheduler();
		consoleCommandSender = _server.getConsoleSender();
		
		log("Powered by INK!");
	}
	
	public static TheiaPaperPlugin getCurrentPlugin()
	{
		return current;
	}
	
	
	public static void log(String msg)
	{
		log(Comp.t(msg));
	}
	
	public static void log(Component msg)
	{
		consoleCommandSender.sendMessage(logPrefix.append(msg));
	}
}
