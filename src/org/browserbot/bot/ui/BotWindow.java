package org.browserbot.bot.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

import org.browserbot.Configuration;
import org.browserbot.bot.Bot;
import org.browserbot.bot.ui.resource.ResourceManager;

/**
 * The "BrowserBot" window.
 * 
 * @author Desmond Jackson
 */
public class BotWindow extends JFrame implements WindowListener {

	/**
	 * The serial uid.
	 */
	private static final long serialVersionUID = -7261328061786037529L;
	
	/**
	 * The bot instance.
	 */
	private Bot bot;
	
	/**
	 * The bot menu bar.
	 */
	private BotMenuBar menuBar = new BotMenuBar(this);
	
	/**
	 * The bot tab pane.
	 */
	private BotTabPane tabPane = new BotTabPane(this);
	
	/**
	 * Creates the "BrowserBot" window.
	 * 
	 * @param bot The bot instance
	 */
	public BotWindow(Bot bot) {
		super("BrowserBot v" + Configuration.BOT_VERSION_MAJOR + "." + Configuration.BOT_VERSION_MINOR);
		this.bot = bot;
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setIconImage(ResourceManager.getIcon("logo.png").getImage());
		setSize(new Dimension(Configuration.BOT_UI_WIDTH, Configuration.BOT_UI_HEIGHT));
		setResizable(false);
		setJMenuBar(menuBar);
		add(tabPane, BorderLayout.CENTER);
		addWindowListener(this);
		setVisible(true);
	}
	
	/**
	 * Gets the bot tab pane.
	 * 
	 * @return The bot tab pane
	 */
	public BotTabPane getTabPane() {
		return tabPane;
	}
	
	/**
	 * Gets the bot instance.
	 * 
	 * @return The bot instance
	 */
	public Bot getBot() {
		return bot;
	}

	@Override
	public void windowOpened(WindowEvent e) {}

	@Override
	public void windowClosing(WindowEvent e) {}

	@Override
	public void windowClosed(WindowEvent e) {
		tabPane.removeAllTabs();
	}

	@Override
	public void windowIconified(WindowEvent e) {}

	@Override
	public void windowDeiconified(WindowEvent e) {}

	@Override
	public void windowActivated(WindowEvent e) {}

	@Override
	public void windowDeactivated(WindowEvent e) {}

}
