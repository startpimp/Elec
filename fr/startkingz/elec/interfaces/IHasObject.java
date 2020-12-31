package fr.startkingz.elec.interfaces;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import fr.startkingz.elec.annotations.Version;
import fr.startkingz.elec.engine.Loop;
import fr.startkingz.elec.utils.entities.ClassOfTwoValues;
import fr.startkingz.elec.utils.entities.Texture;

/**
 * This class contains all the variables of a basic graphic element.
 * 
 * @author StartKingz
 */
@Version(version = 4)
public interface IHasObject
{

	/**
	 * This function allows this element to be initialized as soon as the Loop is
	 * switched on.
	 */
	void initialize();

	/**
	 * This constructor allows you to add this new object directly into the selected
	 * Loop.
	 * 
	 * @param loop The Loop where this object will be added.
	 */
	void construct(Loop loop);

	/**
	 * This function returns the texture of this tile. If none has been defined, the
	 * default tile will be a square with pink and black tiles.
	 * 
	 * @return The default texture of this tile.
	 */
	default Texture getTexture()
	{
		final BufferedImage IMAGE    = new BufferedImage(2, 2, BufferedImage.TYPE_INT_ARGB);
		final Graphics      GRAPHICS = IMAGE.getGraphics();

		// Top-right
		GRAPHICS.setColor(Color.MAGENTA);
		GRAPHICS.drawRect(0, 0, 1, 1);
		// Top-left
		GRAPHICS.setColor(Color.BLACK);
		GRAPHICS.drawRect(1, 0, 1, 1);
		// Bottom-right
		GRAPHICS.setColor(Color.BLACK);
		GRAPHICS.drawRect(0, 1, 1, 1);
		// Bottom-left
		GRAPHICS.setColor(Color.MAGENTA);
		GRAPHICS.drawRect(1, 1, 1, 1);

		return new Texture(IMAGE);
	}

	/**
	 * This function allows you to retrieve the position of this tile.<br>
	 * By default, the coordinates are X: 0 and Y: 0.
	 * 
	 * @return Returns the current position of the tile.
	 */
	default ClassOfTwoValues<Double> getPosition()
	{
		return new ClassOfTwoValues<>(0.0, 0.0);
	}

	/**
	 * This function is called as soon as the Loop is switched off.
	 */
	void end();
}
