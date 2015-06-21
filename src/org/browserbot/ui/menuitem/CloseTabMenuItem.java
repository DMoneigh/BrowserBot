package org.browserbot.ui.menuitem;

import java.awt.event.ActionEvent;

import org.browserbot.ui.BrowserMenuItem;
import org.browserbot.ui.BrowserTab;

/**
 * The "Close Tab" menu item.
 * 
 * @author Desmond Jackson
 */
public class CloseTabMenuItem extends BrowserMenuItem {

	/**
	 * The serial uid.
	 */
	private static final long serialVersionUID = -1606710130931128145L;

	/**
	 * Creates the "Close Tab" menu item.
	 */
	public CloseTabMenuItem() {
		super("Close Tab");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		BrowserTab tab = getMenu().getMenuBar().getWindow().getTabPane().getSelectedTab();
		tab.getTabPane().removeTab(tab);
	}

}
