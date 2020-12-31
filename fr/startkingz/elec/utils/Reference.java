package fr.startkingz.elec.utils;

import java.io.IOException;

import fr.startkingz.elec.annotations.Version;

/**
 * This class contains all the unchangeable information of Elec such as its
 * version.
 * 
 * @author StartKingz
 */
@Version(version = 4)
public final class Reference
{

	/**
	 * This is the serialized version of Elec. This version is calculated via the
	 * version indicators : {@link fr.startkingz.elec.annotations.Version Version}.
	 * The addition of all these versions is then divided by the number of versions
	 * received: this gives the serialized version.
	 * 
	 * @see fr.startkingz.elec.annotations.Version
	 * @see fr.startkingz.elec.utils.ClassFinder
	 */
	public static double version()
	{
		int    numberOfVersion = 0;
		double sumOfVersion    = 0;

		try
		{
			for (final Class<?> CLASS : ClassFinder.getClasses("fr.startkingz.elec"))
			{
				final Version VERSION = CLASS.getAnnotation(Version.class);

				if (VERSION == null)
				{
					System.err.println("[Reference] The " + CLASS.getName() + " class has no version!");
					continue;
				}

				sumOfVersion += VERSION.version();
				numberOfVersion++;
			}
		} catch (ClassNotFoundException | IOException e)
		{
			e.printStackTrace();
		}

		return sumOfVersion / numberOfVersion;
	}
}
