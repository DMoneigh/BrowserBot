package org.browserbot.bot;

import org.browserbot.bot.ui.BotWindow;

/**
 * Represents a bot instance.
 * 
 * @author Desmond Jackson
 */
public class Bot extends Object {
	
	/**
	 * The bot window.
	 */
	private BotWindow window = new BotWindow(this);
	
	/**
	 * Creates the bot instance.
	 */
	public Bot() {
		super();
	}
	
	/**
	 * Gets the bot window.
	 * 
	 * @return The bot window
	 */
	public BotWindow getWindow() {
		return window;
	}

}
