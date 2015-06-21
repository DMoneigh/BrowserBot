package org.browserbot.script;

import com.teamdev.jxbrowser.chromium.Browser;

/**
 * Represents a script.
 * 
 * @author Desmond Jackson
 */
public abstract class Script extends Thread {
	
	/**
	 * The state of whether the script exit was requested.
	 */
	private boolean stopRequested = false;
	
	/**
	 * The browser that controls the script.
	 */
	protected Browser browser;
	
	/**
	 * Sets the browser for the script.
	 * 
	 * @param browser The browser to set
	 */
	public void setBrowser(Browser browser) {
		this.browser = browser;
	}
	
	/**
	 * Changes the state of whether the script exit was requested to true.
	 */
	public void requestStop() {
		stopRequested = true;
	}
	
	/**
	 * Sleeps the script thread for a specified time in milliseconds.
	 * 
	 * @param ms The amount of milliseconds to sleep
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
			halt(loop());
		onStop();
	}
	
	/**
	 * Called when the script is started.
	 */
	public abstract void onStart();
	
	/**
	 * Called when the script is exited.
	 */
	public abstract void onStop();
	
	/**
	 * Called every specified milliseconds.
	 * 
	 * @return The amount of milliseconds to wait before calling the method again
	 */
	public abstract int loop();

}
