package fr.startkingz.elec.events;

import fr.startkingz.elec.abstracts.Event;
import fr.startkingz.elec.annotations.Version;
import fr.startkingz.elec.engine.Loop;

/**
 * This class gathers the different main information of a loop during an event.
 * 
 * @author StartKingz
 * @see fr.startkingz.elec.engine.Loop
 */
@Version(version = 1)
public abstract class GeneralLoopEvent extends Event
{

	private Loop loop;

	/**
	 * This constructor is used to define the different information of the loop.
	 * 
	 * @param LOOP The loop.
	 * @see fr.startkingz.elec.engine.Loop
	 */
	public GeneralLoopEvent(final Loop LOOP)
	{
		super();
		setLoop(LOOP);
	}

	/**
	 * This function is used to recover the loop.
	 * 
	 * @return the loop.
	 * @see fr.startkingz.elec.engine.Loop
	 */
	public final Loop getLoop()
	{
		return loop;
	}

	/**
	 * This function allows you to define the loop of this event.
	 * 
	 * @param LOOP the loop.
	 * @see fr.startkingz.elec.engine.Loop
	 */
	protected final void setLoop(final Loop LOOP)
	{
		this.loop = LOOP;
	}

}
