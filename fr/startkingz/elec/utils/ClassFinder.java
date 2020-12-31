package fr.startkingz.elec.utils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import fr.startkingz.elec.annotations.Version;

/**
 * @author user59634 AND StartKingz
 */
@Version(version = 3)
public final class ClassFinder
{

	/**
	 * Scans all classes accessible from the context class loader which belong to
	 * the given package and subpackages.
	 *
	 * @param packageName The base package
	 * @return The classes
	 * @throws ClassNotFoundException - if the class cannot be located
	 * @throws IOException            - If I/O errors occur
	 */
	public static Class<?>[] getClasses(String packageName) throws ClassNotFoundException, IOException
	{
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		assert classLoader != null;
		String           path      = packageName.replace('.', '/');
		Enumeration<URL> resources = classLoader.getResources(path);
		List<File>       dirs      = new ArrayList<>();
		while (resources.hasMoreElements())
		{
			URL resource = resources.nextElement();
			dirs.add(new File(resource.getFile()));
		}
		ArrayList<Class<?>> classes = new ArrayList<>();
		for (File directory : dirs)
		{
			classes.addAll(findClasses(directory, packageName));
		}
		return classes.toArray(new Class[0]);
	}

	/**
	 * Recursive method used to find all classes in a given directory and subdirs.
	 *
	 * @param directory   The base directory
	 * @param packageName The package name for classes found inside the base
	 *                    directory
	 * @return The classes
	 * @throws ClassNotFoundException - if the class cannot be located
	 */
	public static List<Class<?>> findClasses(File directory, String packageName) throws ClassNotFoundException
	{
		List<Class<?>> classes = new ArrayList<>();
		if (!directory.exists())
		{
			return classes;
		}
		File[] files = directory.listFiles();
		assert files != null;
		for (File file : files)
		{
			if (file.isDirectory())
			{
				assert !file.getName().contains(".");
				classes.addAll(findClasses(file, packageName + "." + file.getName()));
			} else if (file.getName().endsWith(".class"))
			{
				classes.add(
						Class.forName(packageName + '.' + file.getName().substring(0, file.getName().length() - 6))
				);
			}
		}
		return classes;
	}

}
