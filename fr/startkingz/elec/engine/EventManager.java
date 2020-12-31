package fr.startkingz.elec.engine;

import java.util.ArrayList;
import java.util.List;

import fr.startkingz.elec.abstracts.Event;
import fr.startkingz.elec.annotations.Version;
import fr.startkingz.elec.interfaces.EventListener;

/**
 * This class allows you to manage each Event and EventListener.
 *
 * @author StartKingz
 */
@Version(version = 2)
public final class EventManager
{

	private static final List<EventListener> EVENTS = new ArrayList<>();

	/**
	 * This function allows you to add an EventListener.
	 *
	 * @param EVENT_LISTENER The EventListener.
	 * @see fr.startkingz.elec.interfaces.EventListener
	 */
	public static void addEventListener(final EventListener EVENT_LISTENER)
	{
		EVENTS.add(EVENT_LISTENER);
	}

	/**
	 * This function will be called when an Event is created and will send this
	 * Event to all {@link fr.startkingz.elec.interfaces.EventListener
	 * EventListener}s.
	 * 
	 * @param EVENT The created Event.
	 * @see fr.startkingz.elec.abstracts.Event
	 */
	public static void onEvent(final Event EVENT)
	{
		EVENTS.forEach((listener) -> listener.onEvent(EVENT));
	}
}
