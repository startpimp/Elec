package fr.startkingz.elec.events;

import fr.startkingz.elec.annotations.Version;
import fr.startkingz.elec.engine.Loop;
import fr.startkingz.elec.engine.Panel;

/**
 * This class is called when a loop calls the function "render".
 * 
 * @author StartKingz
 * @see fr.startkingz.elec.engine.Loop#render
 */
@Version(version = 1)
public final class OnLoopIsRenderedEvent extends GeneralLoopEvent
{
	private Panel panel;

	/**
	 * When the "render" function of Loop is executed, this constructor is called.
	 *
	 * @param LOOP  The Loop.
	 * @param PANEL The Panel.
	 * @see fr.startkingz.elec.events.GeneralLoopEvent
	 * @see fr.startkingz.elec.engine.Loop
	 * @see fr.startkingz.elec.engine.Panel
	 */
	public OnLoopIsRenderedEvent(final Loop LOOP, final Panel PANEL)
	{
		super(LOOP);
		setPanel(PANEL);
	}

	/**
	 * This function is used to retrieve the Panel associated with the loop.
	 * 
	 * @return The Panel.
	 * @see fr.startkingz.elec.engine.Panel
	 */
	public final Panel getPanel()
	{
		return panel;
	}

	/**
	 * This function allows you to define a new Panel.
	 * 
	 * @param PANEL The Panel.
	 * @see fr.startkingz.elec.engine.Panel
	 */
	private void setPanel(final Panel PANEL)
	{
		this.panel = PANEL;
	}

}
