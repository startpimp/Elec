package fr.startkingz.elec.engine;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import fr.startkingz.elec.abstracts.Entity;
import fr.startkingz.elec.abstracts.Tile;
import fr.startkingz.elec.annotations.Version;

/**
 * This class contains the screen as well as some components of the engine.
 * 
 * @author StartKingz
 */
@Version(version = 2)
public final class Panel extends JPanel
{

	/**
	 * Auto generated UID.
	 */
	private static final long serialVersionUID = -1338433005985730460L;

	/**
	 * This is where all the tiles in this loop are stored.
	 */
	public final List<Tile>   TILES            = new ArrayList<>();

	/**
	 * This is where all the entities in this loop are stored.
	 */
	public final List<Entity> ENTITIES         = new ArrayList<>();

	@Override
	public void paint(final Graphics GRAPHICS)
	{
		super.paint(GRAPHICS);

		TILES.forEach((tile) -> tile.render(GRAPHICS));

		ENTITIES.forEach((entity) -> entity.render(GRAPHICS));
	}

}
