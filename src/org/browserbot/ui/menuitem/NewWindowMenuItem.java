package org.browserbot.ui.menuitem;

import java.awt.event.ActionEvent;

import org.browserbot.ui.BrowserMenuItem;
import org.browserbot.ui.BrowserWindow;

/**
 * The "New window" menu item.
 * 
 * @author Desmond Jackson
 */
public class NewWindowMenuItem extends BrowserMenuItem {

	/**
	 * The serial uid.
	 */
	private static final long serialVersionUID = 4466111814292279286L;

	/**
	 * Creates the "New window" menu item.
	 */
	public NewWindowMenuItem() {
		super("New window");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		new BrowserWindow().setVisible(true);
	}

}
