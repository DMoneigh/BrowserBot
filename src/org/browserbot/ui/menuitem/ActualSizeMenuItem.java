package org.browserbot.ui.menuitem;

import java.awt.event.ActionEvent;

import org.browserbot.ui.BrowserMenuItem;

/**
 * The "Actual Size" menu item.
 * 
 * @author Desmond Jackson
 */
public class ActualSizeMenuItem extends BrowserMenuItem {

	/**
	 * The serial uid.
	 */
	private static final long serialVersionUID = -2436306493324289313L;

	/**
	 * Creates the "Actual Size" menu item.
	 */
	public ActualSizeMenuItem() {
		super("Actual Size");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		getMenu().getMenuBar().getWindow().getTabPane().getSelectedTab().getDisplay().getBrowser().zoomReset();
	}

}
