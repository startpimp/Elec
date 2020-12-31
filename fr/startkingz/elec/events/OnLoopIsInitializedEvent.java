package fr.startkingz.elec.events;

import fr.startkingz.elec.annotations.Version;
import fr.startkingz.elec.engine.Loop;

/**
 * This class is called when a loop calls the function "initialize".
 *
 * @author StartKingz
 * @see fr.startkingz.elec.engine.Loop#initialize
 */
@Version(version = 1)
public final class OnLoopIsInitializedEvent extends GeneralLoopEvent
{
	/**
	 * When the "initialize" function of Loop is executed, this constructor is called.
	 *
	 * @param LOOP The Loop.
	 * @see fr.startkingz.elec.events.GeneralLoopEvent
	 * @see fr.startkingz.elec.engine.Loop
	 */
	public OnLoopIsInitializedEvent(final Loop LOOP)
	{
		super(LOOP);
	}

}
