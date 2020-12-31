package fr.startkingz.elec.engine;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import fr.startkingz.elec.annotations.Version;
import fr.startkingz.elec.utils.entities.ClassOfTwoValues;

/**
 * This class is used to manage the window.
 * 
 * @author StartKingz
 */
@Version(version = 4)
public final class Frame extends JFrame
{

	/**
	 * Auto generated UID.
	 */
	private static final long               serialVersionUID = -4602672985985770253L;

	private final ClassOfTwoValues<Integer> SIZE;

	/**
	 * This constructor allows you to create a window with a well defined size.<br>
	 * <br>
	 * - By default, the window will be displayed in the middle of the screen.<br>
	 * - The loop stops when the window has been closed.
	 * 
	 * @param SIZE The size of the window (WIDTH, HEIGHT).
	 * @see fr.startkingz.elec.utils.entities.ClassOfTwoValues
	 */
	public Frame(final ClassOfTwoValues<Integer> SIZE)
	{
		super();
		this.SIZE = SIZE;
		this.setSize(SIZE.getX(), SIZE.getY());
		this.setLocationRelativeTo(null);
	}

	/**
	 * This class is used to create the display of this window as well as to create
	 * its loop.<br>
	 * <br>
	 * It creates a Panel and a Loop for this Frame.
	 * 
	 * @return Returns the created loop.
	 * @see fr.startkingz.elec.engine.Loop
	 * @see fr.startkingz.elec.engine.Panel
	 */
	public final Loop create()
	{
		final Panel  PANEL = new Panel();
		final JFrame FRAME = this;
		final Loop   LOOP  = new Loop(PANEL)
							{
								@Override
								protected void initialize()
								{
									super.initialize();
									FRAME.setVisible(true);
								}
							};

		return create(LOOP);
	}

	/**
	 * This function allows you to initialize the window with a given loop.
	 * 
	 * @param LOOP The given loop.
	 * @return The Returns the given loop.
	 * @see fr.startkingz.elec.engine.Loop
	 */
	public final Loop create(final Loop LOOP)
	{
		LOOP.PANEL.setSize(SIZE.getX(), SIZE.getY());
		this.add(LOOP.PANEL);

		this.addWindowListener(new WindowAdapter()
		{
			@Override
			public void windowClosing(WindowEvent e)
			{
				super.windowClosing(e);
				LOOP.finish();
			}
		});

		return LOOP;
	}

	/**
	 * This function allows you to recover the dimension of this window (WIDTH,
	 * HEIGHT).
	 * 
	 * @return The dimension of this window.
	 * @see fr.startkingz.elec.utils.entities.ClassOfTwoValues
	 */
	public ClassOfTwoValues<Integer> getDimension()
	{
		return SIZE;
	}

}
