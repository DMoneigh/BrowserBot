package org.browserbot.ui.menuitem;

import java.awt.event.ActionEvent;

import org.browserbot.ui.BrowserMenuItem;

/**
 * The "Back" menu item.
 * 
 * @author Desmond Jackson
 */
public class BackMenuItem extends BrowserMenuItem {

	/**
	 * The serial uid.
	 */
	private static final long serialVersionUID = 9203369814504754564L;

	/**
	 * Creates the "Back" menu item.
	 */
	public BackMenuItem() {
		super("Back");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		getMenu().getMenuBar().getWindow().getTabPane().getSelectedTab().getDisplay().getBrowser().goBack();
	}

}
