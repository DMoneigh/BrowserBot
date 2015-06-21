package org.browserbot.ui.menuitem;

import java.awt.event.ActionEvent;

import org.browserbot.ui.BrowserMenuItem;

/**
 * The "Home" menu item.
 * 
 * @author Desmond Jackson
 */
public class HomeMenuItem extends BrowserMenuItem {

	/**
	 * The serial uid.
	 */
	private static final long serialVersionUID = 6049289111587908986L;

	/**
	 * Creates the "Home" menu item.
	 */
	public HomeMenuItem() {
		super("Home");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		getMenu().getMenuBar().getWindow().getTabPane().getSelectedTab().getDisplay().getBrowser()
		.loadURL("http://forums.browserbot.org");
	}

}
