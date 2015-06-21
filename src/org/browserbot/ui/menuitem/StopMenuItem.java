package org.browserbot.ui.menuitem;

import java.awt.event.ActionEvent;

import org.browserbot.ui.BrowserMenuItem;

/**
 * The "Stop" menu item.
 * 
 * @author Desmond Jackson
 */
public class StopMenuItem extends BrowserMenuItem {

	/**
	 * The serial uid.
	 */
	private static final long serialVersionUID = 5696931695393713446L;

	/**
	 * Creates the "Stop" menu item.
	 */
	public StopMenuItem() {
		super("Stop");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		getMenu().getMenuBar().getWindow().getTabPane().getSelectedTab().getDisplay().getBrowser().stop();
	}

}
