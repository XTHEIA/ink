package kr.sbxt.xtheia.theia.ink;

import kr.sbxt.xtheia.theia.ink.color.Colors;
import kr.sbxt.xtheia.theia.ink.color.IColor;
import org.bukkit.Server;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.inventory.ItemFactory;
import org.bukkit.scheduler.BukkitScheduler;

import javax.annotation.Nullable;
import java.util.LinkedList;
import java.util.List;

public final class Ink extends TheiaPaperPlugin
{
	static Ink current;
	static Server currentServer;
	static ItemFactory itemFactory;
	static BukkitScheduler scheduler;
	static ConsoleCommandSender componentLogger;
	
	private final static LinkedList<IColor> _LOG_PREFIX_COLORS = new LinkedList<>(List.of(Colors.RED_200, Colors.YELLOW_0, Colors.ORANGE, Colors.GREEN_0, Colors.DARK_PURPLE));
	
	
	@Override
	public void onEnable()
	{
		super.onEnable();
		current = this;
		currentServer = getServer();
		componentLogger = currentServer.getConsoleSender();
		itemFactory = currentServer.getItemFactory();
		scheduler = currentServer.getScheduler();
		
		preInitInk(this);
		
		Log.info(Comp.tc("Ink Enabled Successfully!", Colors.LEGACY_AQUA));
		Log.info(Comp.a(Comp.t("Powered by "), Comp.tc("THEIA Core", Colors.LEGACY_YELLOW), Comp.t(" from "), Comp.tc("XTHEIA", Colors.LEGACY_AQUA)));
	}
	
	static @Nullable IColor hookPlugin(TheiaPaperPlugin plugin)
	{
		final var pop = _LOG_PREFIX_COLORS.poll();
		Log.info(Comp.a(Comp.tc(plugin.getName(), pop), Comp.t(" hooked!")));
		Log.info(Comp.a(Comp.t("Powered by "), Comp.tc("Ink", Colors.LEGACY_YELLOW), Comp.t(" from "), Comp.tc("XTHEIA", Colors.LEGACY_AQUA)));
		return pop;
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
