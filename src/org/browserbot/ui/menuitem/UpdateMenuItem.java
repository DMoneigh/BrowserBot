package org.browserbot.ui.menuitem;

import java.awt.event.ActionEvent;

import org.browserbot.ui.BrowserMenuItem;

/**
 * The "Update" menu item.
 * 
 * @author Desmond Jackson
 */
public class UpdateMenuItem extends BrowserMenuItem {

	/**
	 * The serial uid.
	 */
	private static final long serialVersionUID = -3026566547363892903L;

	/**
	 * Creates the "Update" menu item.
	 */
	public UpdateMenuItem() {
		super("Update");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		getMenu().getMenuBar().getWindow().getTabPane().getSelectedTab().getDisplay().getBrowser()
		.loadURL("http://www.browserbot.org/downloads/");
	}

}
