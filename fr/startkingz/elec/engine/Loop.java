package fr.startkingz.elec.engine;

import fr.startkingz.elec.abstracts.Entity;
import fr.startkingz.elec.abstracts.Tile;
import fr.startkingz.elec.annotations.Version;
import fr.startkingz.elec.events.OnLoopIsEndedEvent;
import fr.startkingz.elec.events.OnLoopIsFinishedEvent;
import fr.startkingz.elec.events.OnLoopIsInitializedEvent;
import fr.startkingz.elec.events.OnLoopIsRenderedEvent;
import fr.startkingz.elec.events.OnLoopIsUpdatedEvent;
import fr.startkingz.elec.interfaces.IHasObject;

/**
 * This class allows you to create as many loops as you need.
 * 
 * @author StartKingz
 * @see java.lang.Thread
 */
@Version(version = 4)
public abstract class Loop extends Thread
{

	public final Panel PANEL;
	private int        maxFPS    = 60;
	private int        maxTPS    = 10;
	private int        FPS, TPS;
	private long       millisFPS = 1_000_000_000 / maxFPS;
	private long       millisTPS = 1_000_000_000 / maxTPS;

	/**
	 * This constructor allows you to link a screen (Panel) to this loop.<br>
	 * <br>
	 * The beginning of a loop consists of an initialization followed by a first
	 * update of the loop, then the loop is created.
	 * 
	 * @param PANEL The screen (Panel) to be linked.
	 * @see fr.startkingz.elec.engine.Panel
	 */
	protected Loop(final Panel PANEL)
	{
		this.PANEL = PANEL;
	}

	private boolean isRunning = false;

	@Override
	public void run()
	{
		super.run();

		long   previousTime = System.nanoTime();
		long   currentTime;
		long   timer        = System.currentTimeMillis();
		int    pastFPS, pastTPS;
		double deltaFPS, deltaTPS;

		pastFPS  = pastTPS = 0;
		deltaFPS = deltaTPS = 0.0;
		FPS      = TPS = 0;

		initialize();
		update();
		while (isRunning)
		{
			currentTime   = System.nanoTime();
			deltaFPS     += (double) (currentTime - previousTime) / millisFPS;
			deltaTPS     += (double) (currentTime - previousTime) / millisTPS;
			previousTime  = currentTime;

			if (deltaTPS >= 1)
			{
				update();

				pastTPS++;
				deltaTPS--;
			}

			if (deltaFPS >= 1)
			{
				render();

				pastFPS++;
				deltaFPS--;
			}

			if (System.currentTimeMillis() - timer > 1000)
			{
				FPS      = pastFPS;
				TPS      = pastTPS;
				pastFPS  = pastTPS = 0;
				timer   += 1000;
			}
		}
		end();
	}

	/**
	 * This function allows you to update each logical element of this loop.
	 */
	protected void update()
	{
		PANEL.ENTITIES.forEach(Entity::update);

		new OnLoopIsUpdatedEvent(this);
	}

	/**
	 * This function makes it possible to render all the graphic elements of this
	 * loop on the screen.
	 * 
	 * @see fr.startkingz.elec.engine.Panel
	 */
	protected void render()
	{
		PANEL.repaint();

		new OnLoopIsRenderedEvent(this, PANEL);
	}

	/**
	 * This function is executed before starting the loop.
	 */
	protected void initialize()
	{
		isRunning = true;

		PANEL.TILES.forEach(IHasObject::initialize);

		PANEL.ENTITIES.forEach(IHasObject::initialize);

		new OnLoopIsInitializedEvent(this);
	}

	/**
	 * This function is used to end this loop.
	 */
	protected final void finish()
	{
		isRunning = false;

		new OnLoopIsFinishedEvent(this);
	}

	/**
	 * This function is executed before stopping the loop completely.
	 */
	protected void end()
	{
		new OnLoopIsEndedEvent(this);

		System.err.println("[Loop ; " + this.getName() + "] The loop has stopped.");
	}

	/**
	 * This function allows you to add an entity to this loop.
	 * 
	 * @param ENTITY The entity to be added.
	 * @deprecated This function is deprecated because entities are automatically
	 *             added to this loop as soon as they are created.
	 * @see fr.startkingz.elec.abstracts.Entity
	 */
	@Deprecated(since = "1")
	public final void addEntity(final Entity ENTITY)
	{
		PANEL.ENTITIES.add(ENTITY);
	}

	/**
	 * This function allows you to add an tile to this loop.
	 * 
	 * @param TILE The tile to be added.
	 * @deprecated This function is deprecated because tiles are automatically added
	 *             to this loop as soon as they are created.
	 * @see fr.startkingz.elec.abstracts.Tile
	 */
	@Deprecated(since = "1")
	public final void addTile(final Tile TILE)
	{
		PANEL.TILES.add(TILE);
	}

	/**
	 * FPS: Frames Per Second<br>
	 * This function gives you the maximum number of FPS in this loop.
	 * 
	 * @return Returns the maximum number of FPS.
	 */
	public final int getMaxFPS()
	{
		return maxFPS;
	}

	/**
	 * TPS: Ticks Per Second<br>
	 * This function allows you to define a new maximum TPS.<br>
	 * Default is 10 TPSs.
	 * 
	 * @param MAX_TPS The new maximum TPS.
	 */
	public final void setMaxTPS(final int MAX_TPS) throws ArithmeticException
	{
		if (MAX_TPS <= 0)
			throw new ArithmeticException("Impossible to have a TPS below or equal to 0.");

		this.maxTPS = MAX_TPS;
		millisTPS   = 1_000_000_000 / MAX_TPS;
	}

	/**
	 * FPS: Frames Per Second<br>
	 * This function allows you to define a new maximum FPS.<br>
	 * Default is 60 FPSs.
	 * 
	 * @param MAX_FPS The new maximum FPS.
	 */
	public final void setMaxFPS(final int MAX_FPS)
	{
		if (MAX_FPS <= 0)
			throw new ArithmeticException("Impossible to have a FPS below or equal to 0.");

		this.maxFPS = MAX_FPS;
		millisFPS   = 1_000_000_000 / MAX_FPS;
	}

	/**
	 * TPS: Ticks Per Second<br>
	 * This function gives you the maximum number of TPS in this loop.
	 * 
	 * @return Returns the maximum number of TPS.
	 */
	public final int getMaxTPS()
	{
		return maxTPS;
	}

	/**
	 * FPS: Frames Per Second<br>
	 * This function gives you the number of FPS of each loop.
	 * 
	 * @return Returns the number of FPS.
	 */
	public final int getFPS()
	{
		return FPS;
	}

	/**
	 * TPS: Ticks Per Second<br>
	 * This function gives you the number of TPS of each loop.
	 * 
	 * @return Returns the number of TPS.
	 */
	public final int getTPS()
	{
		return TPS;
	}
}
