package kr.sbxt.xtheia.theia.ink;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.logger.slf4j.ComponentLogger;
import org.bukkit.plugin.Plugin;

public final class Log
{
	private static ComponentLogger componentLogger;
	
	public static void init(Plugin plugin)
	{
		componentLogger = plugin.getComponentLogger();
	}
	
	public static void info(String msg)
	{
		info(Comp.t(msg));
	}
	
	public static void info(Component msg)
	{
		componentLogger.info(msg);
	}
}
