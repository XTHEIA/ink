package kr.sbxt.xtheia.theia.ink;

import kr.sbxt.xtheia.theia.ink.color.Colors;
import kr.sbxt.xtheia.theia.ink.color.IColor;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.ComponentLike;
import net.kyori.adventure.text.flattener.ComponentFlattener;
import net.kyori.adventure.text.format.Style;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.kyori.adventure.text.serializer.plain.PlainTextComponentSerializer;

import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

public final class Comp
{
	private static final ComponentFlattener componentFlattener = ComponentFlattener.textOnly();
	private static final PlainTextComponentSerializer PLAIN_TEXT_COMPONENT_SERIALIZER = PlainTextComponentSerializer.plainText();
	public static final Style plain = Style.style(Colors.WHITE.asTextColor(), TextDecoration.ITALIC.withState(TextDecoration.State.FALSE));
	public static final Component space = Component.text(" "), empty = Component.text("");
	
	public static String flatten(final Component component)
	{
		return PLAIN_TEXT_COMPONENT_SERIALIZER.serialize(component);
	}
	
	public static String currentTimeString()
	{
		return LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
	}
	
	public static Component currentDateTime(IColor color)
	{
		return Comp.t(currentTimeString(), color);
	}
	
	public static Component brackets(ComponentLike comp)
	{
		return Comp.t("[").append(comp).append(Comp.t("]"));
	}
	
	public static Component bracketsWithSpace(ComponentLike comp)
	{
		return Comp.t("[ ").append(comp).append(Comp.t(" ]"));
	}
	
	public static Component property(String propKey, ComponentLike propValue)
	{
		return a(t(propKey, Colors.G_200), t(" ", Colors.G_100), propValue);
	}
	
	public static Component property(String key, String value, IColor color)
	{
		return property(key, t(value, color));
	}
	
	public static Component property(String key, String value)
	{
		return property(key, value, Colors.LEGACY_YELLOW);
	}
	
	public static Component property(String key, Object value)
	{
		return property(key, value.toString());
	}
	
	
	public static Component a(ComponentLike... components)
	{
		var result = Component.empty();
		for (final ComponentLike component : components)
		{
			result = result.append(component);
		}
		return result;
	}
	
	public static Component hexColor(int rgb)
	{
		return t("#").append(t(Integer.toHexString(rgb).toUpperCase(), rgb));
	}
	
	public static Component[] fromStringLores(String... lores)
	{
		final Component[] _loresComp_ = new Component[lores.length];
		int i = 0;
		for (String lore : lores) { _loresComp_[i++] = Comp.t(lore, Colors.WHITE); }
		return _loresComp_;
	}
	
	
	public static Component highlight(String format, Object... args)
	{
		final var arr = new Object[args.length];
		for (int i = 0; i < args.length; i++)
		{
			arr[i] = "<yellow>%s</yellow>".formatted(String.valueOf(args[i]));
		}
		return MiniMessage.miniMessage().deserialize(MessageFormat.format(format, arr)).style(plain);
	}
	
	public static Component t(String content)
	{
		return t(content, Colors.WHITE);
	}
	
	public static Component t(String content, int rgbInt, TextDecoration... decorations)
	{
		return t(content, TextColor.color(rgbInt), decorations);
	}
	
	public static Component t(String content, IColor rgb, TextDecoration... decorations)
	{
		return t(content, rgb.asTextColor(), decorations);
	}
	
	public static Component t(String content, TextColor color, TextDecoration... decorations)
	{
		return Component.text(content, color, decorations);
	}
	
	//	public static Component rarityTypeName(QuasarElement element)
	//	{
	//		return a(
	//				element.getName(),
	//				t(" ("),
	//				element.getRarity().asRarityComponent(),
	//				t(" "),
	//				element.getType().asTypeComponent(),
	//				t(")")
	//		);
	//	}
	
	public static Component typeName(String type, Component name)
	{
		return Comp.t(type + ": ").append(name);
	}
	
	public static Component mergeLines(List<Component> lines)
	{
		var comp = Component.empty();
		if (lines != null)
		{
			final var size = lines.size();
			for (int i = 0; i < size; i++)
			{
				final Component line = lines.get(i);
				comp = comp.append(line);
				if (i != size - 1)
				{
					comp = comp.append(Component.newline());
				}
			}
		}
		
		return comp;
	}
	
	public static Component[] ts(String... data)
	{
		return Arrays.stream(data).map(Comp::t).toArray(Component[]::new);
	}
	
	public static Component number(Number num)
	{
		return t(num.toString(), Colors.YELLOW_0);
	}
}
