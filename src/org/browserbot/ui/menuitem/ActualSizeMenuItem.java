package org.browserbot.ui.menuitem;

import java.awt.event.ActionEvent;

import org.browserbot.ui.BrowserMenuItem;

public class ActualSizeMenuItem extends BrowserMenuItem {

	private static final long serialVersionUID = -2436306493324289313L;

	public ActualSizeMenuItem() {
		super("Actual Size");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		getMenu().getMenuBar().getWindow().getTabPane().getSelectedTab().getDisplay().getBrowser().zoomReset();
	}

}
