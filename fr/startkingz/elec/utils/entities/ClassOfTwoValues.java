package fr.startkingz.elec.utils.entities;

import fr.startkingz.elec.annotations.Version;

/**
 * This class contains two values as primitive type.
 * 
 * @author StartKingz
 * @param <PT> The primitive type to be used to create a class of tow values.
 */
@Version(version = 3)
public final class ClassOfTwoValues<PT>
{
	private PT x, y;

	/**
	 * This constructor allows you to create a point with defined and mandatory
	 * coordinates.
	 * 
	 * @param X The X position.
	 * @param Y The Y position.
	 */
	public ClassOfTwoValues(final PT X, final PT Y)
	{
		x = X;
		y = Y;
	}

	/**
	 * This function allows you to retrieve the X position.
	 * 
	 * @return The X position.
	 */
	public final PT getX()
	{
		return x;
	}

	/**
	 * This function allows you to retrieve the Y position.
	 * 
	 * @return The Y position.
	 */
	public final PT getY()
	{
		return y;
	}

	/**
	 * This function allows you to redefine the X position.
	 */
	public final void setX(final PT X)
	{
		x = X;
	}

	/**
	 * This function allows you to redefine the Y position.
	 */
	public final void setY(final PT Y)
	{
		y = Y;
	}
}
