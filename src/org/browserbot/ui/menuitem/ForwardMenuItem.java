package org.browserbot.ui.menuitem;

import java.awt.event.ActionEvent;

import org.browserbot.ui.BrowserMenuItem;

/**
 * The "Forward" menu item.
 * 
 * @author Desmond Jackson
 */
public class ForwardMenuItem extends BrowserMenuItem {

	/**
	 * The serial uid.
	 */
	private static final long serialVersionUID = 5160869639753609654L;

	/**
	 * Creates the "Forward" menu item.
	 */
	public ForwardMenuItem() {
		super("Forward");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		getMenu().getMenuBar().getWindow().getTabPane().getSelectedTab().getDisplay().getBrowser().goForward();
	}

}
