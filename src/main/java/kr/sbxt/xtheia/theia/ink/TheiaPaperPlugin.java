package kr.sbxt.xtheia.theia.ink;

import kr.sbxt.xtheia.theia.ink.color.Colors;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.logger.slf4j.ComponentLogger;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public abstract class TheiaPaperPlugin extends JavaPlugin
{
	
	private static Component logPrefix;
	private static ConsoleCommandSender componentLogger;
	
	TheiaPaperPlugin()
	{
		getServer().getConsoleSender().sendMessage(getName() + " ctor");
	}
	
	@Override
	public void onLoad()
	{
		getServer().getConsoleSender().sendMessage(getName() + " onLoad");
	}
	
	@Override
	public void onEnable()
	{
		getServer().getConsoleSender().sendMessage(getName() + " onEnable");
	}
	
	protected void preInitInk()
	{
		preInitInk(this);
	}
	
	protected static void preInitInk(TheiaPaperPlugin plugin)
	{
		componentLogger = Ink.componentLogger;
		var color = Ink.hookPlugin(plugin);
		if (color == null) color = Colors.WHITE;
		logPrefix = Comp.tc(plugin.getName() + "/ ", color);
	}
	
	public static void log(String msg)
	{
		log(Comp.t(msg));
	}
	
	public static void log(Component msg)
	{
		componentLogger.sendMessage(logPrefix.append(msg));
	}
}
