package fr.startkingz.elec.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * This class allows Elec to be versioned. This version will be a serialized
 * version.<br>
 * Its calculation is simple: the class adds up each received version and
 * divides it by the number of received versions and so we get this version.
 * 
 * @author StartKingz
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Version(version = 1)
public @interface Version
{

	/**
	 * This is the version of your file. Make sure that it is modified as soon as
	 * you apply changes to it.
	 * 
	 * @return Returns the version of your file.
	 */
	double version();

}
