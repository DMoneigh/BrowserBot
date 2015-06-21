package org.browserbot.ui.menuitem;

import java.awt.event.ActionEvent;

import org.browserbot.ui.BrowserMenuItem;

/**
 * The "Zoom Out" menu item.
 * 
 * @author Desmond Jackson
 */
public class ZoomOutMenuItem extends BrowserMenuItem {

	/**
	 * The serial uid.
	 */
	private static final long serialVersionUID = 3673174035702652647L;

	/**
	 * Creates the "Zoom Out" menu item.
	 */
	public ZoomOutMenuItem() {
		super("Zoom Out");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		getMenu().getMenuBar().getWindow().getTabPane().getSelectedTab().getDisplay().getBrowser().zoomOut();
	}

}
