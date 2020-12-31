package fr.startkingz.elec.abstracts;

import fr.startkingz.elec.annotations.Version;
import fr.startkingz.elec.engine.Loop;

/**
 * This class contains all the functions of a basic entity element.
 * 
 * @author StartKingz
 */
@Version(version = 3)
public abstract class Entity extends Tile
{
	@Override
	public void construct(final Loop LOOP) {
		super.construct(LOOP);
		LOOP.PANEL.ENTITIES.add(this);
	}

	/**
	 * This function allows the entity to be updated at each loop of the game.
	 */
	public abstract void update();
}
