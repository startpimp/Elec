package fr.startkingz.elec.interfaces;

import fr.startkingz.elec.abstracts.Event;
import fr.startkingz.elec.annotations.Version;

/**
 * This class contains every necessary function of the event managers.
 * 
 * @author StartKingz
 */
@Version(version = 1)
public interface EventListener
{
	/**
	 * This function is called when an event is created.
	 */
	void onEvent(Event event);
}
