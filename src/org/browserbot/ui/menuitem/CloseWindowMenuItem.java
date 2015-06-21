package org.browserbot.ui.menuitem;

import java.awt.event.ActionEvent;

import org.browserbot.ui.BrowserMenuItem;

/**
 * The "Close Window" menu item.
 * 
 * @author Desmond Jackson
 */
public class CloseWindowMenuItem extends BrowserMenuItem {

	/**
	 * The serial uid.
	 */
	private static final long serialVersionUID = 6883843762852634804L;

	/**
	 * Creates the "Close Window" menu item.
	 */
	public CloseWindowMenuItem() {
		super("Close Window");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		getMenu().getMenuBar().getWindow().dispose();
	}

}
