package org.browserbot.ui.menuitem;

import java.awt.event.ActionEvent;

import org.browserbot.ui.BrowserMenuItem;

/**
 * The "Zoom In" menu item.
 * 
 * @author Desmond Jackson
 */
public class ZoomInMenuItem extends BrowserMenuItem {

	/**
	 * The serial uid.
	 */
	private static final long serialVersionUID = 132390574731410437L;

	/**
	 * Creates the "Zoom In" menu item.
	 */
	public ZoomInMenuItem() {
		super("Zoom In");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		getMenu().getMenuBar().getWindow().getTabPane().getSelectedTab().getDisplay().getBrowser().zoomIn();
	}

}
