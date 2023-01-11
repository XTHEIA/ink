package kr.sbxt.xtheia.theia.ink;

import org.bukkit.plugin.java.JavaPlugin;

public abstract class TheiaPaperPlugin extends JavaPlugin
{
	public static void log(String msg)
	{
		Ink.log(msg);
	}
}
