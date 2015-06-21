package org.browserbot.ui.menuitem;

import java.awt.event.ActionEvent;

import org.browserbot.ui.BrowserMenuItem;

/**
 * The "New tab" menu item.
 * 
 * @author Desmond Jackson
 */
public class NewTabMenuItem extends BrowserMenuItem {

	/**
	 * The serial uid.
	 */
	private static final long serialVersionUID = -2435791950463449552L;

	/**
	 * Creates the "New tab" menu item.
	 */
	public NewTabMenuItem() {
		super("New tab");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		getMenu().getMenuBar().getWindow().getTabPane().addTab();
	}

}
