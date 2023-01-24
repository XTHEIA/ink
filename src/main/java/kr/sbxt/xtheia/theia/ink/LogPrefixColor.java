package kr.sbxt.xtheia.theia.ink;

import kr.sbxt.xtheia.theia.ink.color.RGB;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface LogPrefixColor
{
	String hexValue();
}
