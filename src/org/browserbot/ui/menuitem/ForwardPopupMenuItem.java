package org.browserbot.ui.menuitem;

import java.awt.event.ActionEvent;

import org.browserbot.ui.BrowserMenuItem;

/**
 * The "Forward" popup menu item.
 * 
 * @author Desmond Jackson
 */
public class ForwardPopupMenuItem extends BrowserMenuItem {

	/**
	 * The serial uid.
	 */
	private static final long serialVersionUID = 5353163740548680207L;

	/**
	 * Creates the "Forward" popup menu item.
	 */
	public ForwardPopupMenuItem() {
		super("Foward");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		getDisplay().getBrowser().goForward();
	}

}
