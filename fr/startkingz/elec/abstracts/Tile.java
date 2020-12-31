package fr.startkingz.elec.abstracts;

import java.awt.Graphics;

import fr.startkingz.elec.annotations.Version;
import fr.startkingz.elec.engine.Loop;
import fr.startkingz.elec.interfaces.IHasObject;

/**
 * This class contains all the functions of a basic graphic element.
 * 
 * @author StartKingz
 */
@Version(version = 4)
public abstract class Tile implements IHasObject
{

	@Override
	public void construct(final Loop LOOP)
	{
		LOOP.PANEL.TILES.add(this);
	}

	/**
	 * This function allows the element to draw its own content on the screen. By
	 * default, this function draws the texture of the element.
	 * 
	 * @param GRAPHICS The graphics of the main screen.
	 */
	public void render(final Graphics GRAPHICS)
	{
		final int X = getPosition().getX().intValue();
		final int Y = getPosition().getY().intValue();
		GRAPHICS.drawImage(getTexture().getImage(), X, Y, null);
	}

}
