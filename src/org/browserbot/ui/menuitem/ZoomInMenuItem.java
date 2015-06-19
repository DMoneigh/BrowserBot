package org.browserbot.ui.menuitem;

import java.awt.event.ActionEvent;

import org.browserbot.ui.BrowserMenuItem;

public class ZoomInMenuItem extends BrowserMenuItem {

	private static final long serialVersionUID = 132390574731410437L;

	public ZoomInMenuItem() {
		super("Zoom In");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		getMenu().getMenuBar().getWindow().getTabPane().getSelectedTab().getDisplay().getBrowser().zoomIn();
	}

}
