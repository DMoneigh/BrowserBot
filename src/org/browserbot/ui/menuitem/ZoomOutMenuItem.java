package org.browserbot.ui.menuitem;

import java.awt.event.ActionEvent;

import org.browserbot.ui.BrowserMenuItem;

public class ZoomOutMenuItem extends BrowserMenuItem {

	private static final long serialVersionUID = 3673174035702652647L;

	public ZoomOutMenuItem() {
		super("Zoom Out");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		getMenu().getMenuBar().getWindow().getTabPane().getSelectedTab().getDisplay().getBrowser().zoomOut();
	}

}
