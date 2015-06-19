package org.browserbot.script;

import com.teamdev.jxbrowser.chromium.Browser;

public abstract class Script extends Thread {
	
	private boolean stopRequested = false;
	
	protected Browser browser;
	
	public void setBrowser(Browser browser) {
		this.browser = browser;
	}
	
	public void requestStop() {
		stopRequested = true;
	}
	
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
	
	public abstract void onStart();
	
	public abstract void onStop();
	
	public abstract int loop();

}
