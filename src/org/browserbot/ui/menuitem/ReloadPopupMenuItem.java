package org.browserbot.ui.menuitem;

import java.awt.event.ActionEvent;

import org.browserbot.ui.BrowserMenuItem;

/**
 * The "Reload" popup menu item.
 * 
 * @author Desmond Jackson
 */
public class ReloadPopupMenuItem extends BrowserMenuItem {

	/**
	 * The serial uid.
	 */
	private static final long serialVersionUID = 680584190888275941L;

	/**
	 * Creates the "Reload" popup menu item.
	 */
	public ReloadPopupMenuItem() {
		super("Reload");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		getDisplay().getBrowser().reload();
	}

}
