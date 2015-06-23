package org.browserbot.ui.menuitem;

import java.awt.event.ActionEvent;

import org.browserbot.ui.BrowserMenuItem;

/**
 * The "Back" popup menu item.
 * 
 * @author Desmond Jackson
 */
public class BackPopupMenuItem extends BrowserMenuItem {

	/**
	 * The serial uid.
	 */
	private static final long serialVersionUID = -4739860507159684815L;

	/**
	 * Creates the "Back" popup menu item.
	 */
	public BackPopupMenuItem() {
		super("Back");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		getDisplay().getBrowser().goBack();
	}

}
