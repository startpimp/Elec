package fr.startkingz.elec.abstracts;

import java.time.LocalDateTime;

import fr.startkingz.elec.annotations.Version;
import fr.startkingz.elec.engine.EventManager;

/**
 * This class contains the different functions used for events.
 * 
 * @author StartKingz
 */
@Version(version = 3)
public abstract class Event
{
	private long          creationTimeInMillis = 0L;
	private long          creationTimeInNano   = 0L;
	private LocalDateTime creationDate;

	/**
	 * This constructor makes it possible to define the different creation times of
	 * this event in the form of milliseconds and nanoseconds.<br>
	 * <br>
	 * The event is automatically added to the
	 * {@link fr.startkingz.elec.engine.EventManager EventManager} and called by all
	 * {@link fr.startkingz.elec.interfaces.EventListener EventListener}s.
	 */
	public Event()
	{
		setCreationTimeInMillis(System.currentTimeMillis());
		setCreationTimeInNano(System.nanoTime());
		setCreationDate(LocalDateTime.now());

		EventManager.onEvent(this);
	}

	/**
	 * This function recovers the creation time in milliseconds.
	 * 
	 * @return The creation time in milliseconds.
	 */
	public final long getCreationTimeInMillis()
	{
		return creationTimeInMillis;
	}

	/**
	 * This function allows you to set a creation time in milliseconds.
	 * 
	 * @param CREATION_TIME_IN_MILLIS The new creation time in milliseconds.
	 */
	protected final void setCreationTimeInMillis(final long CREATION_TIME_IN_MILLIS)
	{
		this.creationTimeInMillis = CREATION_TIME_IN_MILLIS;
	}

	/**
	 * This function recovers the creation time in nanoseconds.
	 * 
	 * @return The creation time in nanoseconds.
	 */
	public final long getCreationTimeInNano()
	{
		return creationTimeInNano;
	}

	/**
	 * This function allows you to set a creation time in nanoseconds.
	 * 
	 * @param CREATION_TIME_IN_NANO The new creation time in nanoseconds.
	 */
	protected final void setCreationTimeInNano(final long CREATION_TIME_IN_NANO)
	{
		this.creationTimeInNano = CREATION_TIME_IN_NANO;
	}

	/**
	 * This function recovers the creation date.
	 * 
	 * @return The creation date.
	 * @see java.time.LocalDateTime
	 */
	public final LocalDateTime getCreationDate()
	{
		return creationDate;
	}

	/**
	 * This function allows you to set a date.
	 * 
	 * @param CREATION_DATE The new date.
	 * @see java.time.LocalDateTime
	 */
	protected final void setCreationDate(final LocalDateTime CREATION_DATE)
	{
		this.creationDate = CREATION_DATE;
	}

}
