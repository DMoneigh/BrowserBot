package org.browserbot.ui.menuitem;

import java.awt.event.ActionEvent;

import org.browserbot.ui.BrowserMenuItem;

/**
 * The "Reload This Page" menu item.
 * 
 * @author Desmond Jackson
 */
public class ReloadThisPageMenuItem extends BrowserMenuItem {

	/**
	 * The serial uid.
	 */
	private static final long serialVersionUID = -4625099856635152748L;

	/**
	 * Creates the "Reload This Page" menu item.
	 */
	public ReloadThisPageMenuItem() {
		super("Reload This Page");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		getMenu().getMenuBar().getWindow().getTabPane().getSelectedTab().getDisplay().getBrowser().reload();
	}

}
