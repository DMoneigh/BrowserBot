package org.browserbot.ui.menuitem;

import java.awt.event.ActionEvent;

import org.browserbot.ui.BrowserMenuItem;

public class UpdateMenuItem extends BrowserMenuItem {

	private static final long serialVersionUID = -3026566547363892903L;

	public UpdateMenuItem() {
		super("Update");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		getMenu().getMenuBar().getWindow().getTabPane().getSelectedTab().getDisplay().getBrowser()
		.loadURL("http://www.browserbot.org/downloads/");
	}

}
