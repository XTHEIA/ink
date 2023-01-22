package kr.sbxt.xtheia.theia.ink;

import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.scheduler.BukkitTask;

import java.util.function.Consumer;

public final class Tasker
{
	private final static InkPlugin _plugin;
	private final static BukkitScheduler _scheduler;
	
	static
	{
		_plugin = InkPlugin.current;
		_scheduler = InkPlugin.scheduler;
	}
	
	public static BukkitTask delayed(long delayTicks, Runnable task)
	{
		return _scheduler.runTaskLater(_plugin, task, delayTicks);
	}
	
	public static void repeat(long delayTicks, long periodTicks, Consumer<BukkitTask> task)
	{
		_scheduler.runTaskTimer(_plugin, task, delayTicks, periodTicks);
	}
	
	public static BukkitTask repeat(long delayTicks, long periodTicks, Runnable task)
	{
		return _scheduler.runTaskTimer(_plugin, task, delayTicks, periodTicks);
	}
	
	public static BukkitTask repeatWithDuration(long delayTicks, long periodTicks, long durationTicks, Runnable task)
	{
		final var repeat = _scheduler.runTaskTimer(_plugin, task, delayTicks, periodTicks);
		_scheduler.runTaskLater(_plugin, repeat::cancel, delayTicks + durationTicks);
		return repeat;
	}
	
	public static BukkitTask repeatWithDuration(long periodTicks, long durationTicks, Runnable task)
	{
		return repeatWithDuration(0, periodTicks, durationTicks, task);
	}
}
