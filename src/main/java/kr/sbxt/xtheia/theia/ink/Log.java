package kr.sbxt.xtheia.theia.ink;

import kr.sbxt.xtheia.theia.ink.color.Colors;
import net.kyori.adventure.text.Component;
import org.bukkit.command.ConsoleCommandSender;

//@Deprecated
public final class Log
{
	private final static ConsoleCommandSender componentLogger;
	private final static Component prefix;
	
	static
	{
		componentLogger = TheiaPaperPlugin.ConsoleCommandSender();
		prefix = TheiaPaperPlugin.PluginLogPrefix();
	}
	
	public static void info(String msg)
	{
		info(Comp.t(msg));
	}
	
	public static void info(Component msg)
	{
		componentLogger.sendMessage(prefix.append(Comp.space).append(msg));
	}
}
