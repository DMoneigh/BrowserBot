package org.browserbot.bot.script;

import com.teamdev.jxbrowser.chromium.Browser;

/**
 * Represents a script.
 * 
 * @author Desmond Jackson
 */
public abstract class Script extends Thread {
	
	/**
	 * The state of whether the script stop was requested.
	 */
	private boolean stopRequested = false;
	
	/**
	 * The browser controlled by the script.
	 */
	protected Browser browser;
	
	/**
	 * Creates the script.
	 */
	public Script() {
		super();
	}
	
	/**
	 * Sets the browser controlled by the script.
	 * 
	 * @param browser The browser to set
	 */
	public void setBrowser(Browser browser) {
		this.browser = browser;
	}
	
	/**
	 * Sets the state of whether the script stop was requested to true.
	 */
	public void requestStop() {
		stopRequested = true;
	}
	
	/**
	 * Halts the script for an amount of time in milliseconds.
	 * 
	 * @param ms The amount of milliseconds to halt the script
	 */
	public void halt(long ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		onStart();
		while (!stopRequested && !Thread.interrupted())
			try {
				Thread.sleep(loop());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		onStop();
	}
	
	/**
	 * Executed when the script starts.
	 */
	public abstract void onStart();
	
	/**
	 * Executes every specified milliseconds.
	 * 
	 * @return The time in milliseconds of when to execute again
	 */
	public abstract int loop();
	
	/**
	 * Executed when the script stops.
	 */
	public abstract void onStop();

}
