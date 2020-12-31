package fr.startkingz.elec.utils.entities;

import java.awt.image.BufferedImage;

import fr.startkingz.elec.annotations.Version;

/**
 * This class contains the different properties about textures.
 * 
 * @author StartKingz
 */
@Version(version = 1)
public final class Texture
{
	private BufferedImage image;

	/**
	 * This constructor allows you to create a texture via a given image.
	 * 
	 * @param IMAGE The texture image.
	 */
	public Texture(final BufferedImage IMAGE)
	{
		image = IMAGE;
	}

	/**
	 * This function allows you to retrieve the texture image.
	 * 
	 * @return The texture image.
	 */
	public final BufferedImage getImage()
	{
		return image;
	}

	/**
	 * This function allows you to redefine the texture image.
	 */
	public final void setImage(final BufferedImage IMAGE)
	{
		image = IMAGE;
	}
}
