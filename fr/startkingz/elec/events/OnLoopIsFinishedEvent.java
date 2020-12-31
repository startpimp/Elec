package fr.startkingz.elec.events;

import fr.startkingz.elec.annotations.Version;
import fr.startkingz.elec.engine.Loop;

/**
 * This class is called when a loop calls the function "finish".
 *
 * @author StartKingz
 * @see fr.startkingz.elec.engine.Loop#finish
 */
@Version(version = 1)
public final class OnLoopIsFinishedEvent extends GeneralLoopEvent
{
	/**
	 * When the "finish" function of Loop is executed, this constructor is called.
	 *
	 * @param LOOP The Loop.
	 * @see fr.startkingz.elec.events.GeneralLoopEvent
	 * @see fr.startkingz.elec.engine.Loop
	 */
	public OnLoopIsFinishedEvent(final Loop LOOP)
	{
		super(LOOP);
	}

}
