package kr.sbxt.xtheia.theia.ink.color;

public enum Colors implements Color
{
	
	WHITE(0xFFFFFF), // #FFFFFF
	
	G_200(0xC8C8C8), // UI 기본
	G_190(0xBEBEBE), // 클릭표시기 설명 색
	G_180(0xB4B4B4),
	G_170(0xAAAAAA),
	G_160(0xA0A0A0),
	G_150(0x969696),
	G_140(0x8C8C8C), // 클릭표시기 클릭 색
	G_130(0x828282),
	G_120(0x787878), // GUI 구분선?
	G_110(0x6E6E6E),
	G_100(0x646464),
	G_90(0x5A5A5A),
	G_80(0x505050),
	G_70(0x464646),
	G_60(0x3C3C3C),
	G_50(0x323232),
	
	BLACK(0x000000),
	
	RED(0xFF0000),
	RED_90(0xFF5A5A), // 어드민 색
	RED_200(0xFFC8C8), // 클릭표시기 OP 설명
	RED_150(0xFF9592), // 클릭표시기 OP 클릭
	
	LIGHT_PINK(0xFF98E2),
	
	YELLOW_0(0xEEE082),
	YELLOW_1(0xFFE974),
	
	EMERALD(0x26C610),
	
	GREEN_0(0x9FEE97), // 유저 칭호 색
	
	DARK_PURPLE(0x2B0097),
	
	ORANGE(0xEE6400),
	
	LEGACY_RED(0xFF5555),
	LEGACY_YELLOW(0xFFFF55),
	LEGACY_GREEN(0x55FF55),
	LEGACY_AQUA(0x55FFFF),
	LEGACY_GOLD(0xFFAA00),
	
	DISCORD(0x5865F2),
	DISCORD_LIGHT(0xAEB1FF),
	
	MONEY(0xFFBA00),
	POINT(0x00B899),
	
	QUASAR(0xFE1671),
	QUASAR_LIGHT(0xFE76AD),
	
	SOUL(0xB289FF);
	final private ColorInt colorInt;
	final private ColorRGB colorRGB;
	final private String description;
	
	private Colors(int value, String description)
	{
		this.colorInt = new ColorInt(value);
		this.colorRGB = ColorUtility.toRGB(value);
		this.description = description;
	}
	
	private Colors(int value)
	{
		this(value, null);
	}
	
	
	@Override
	public ColorInt getInt()
	{
		return colorInt;
	}
	
	@Override
	public ColorRGB getRGB()
	{
		return colorRGB;
	}
}
