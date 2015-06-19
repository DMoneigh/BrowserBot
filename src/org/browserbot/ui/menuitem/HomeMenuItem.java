package org.browserbot.ui.menuitem;

import java.awt.event.ActionEvent;

import org.browserbot.ui.BrowserMenuItem;

public class HomeMenuItem extends BrowserMenuItem {

	private static final long serialVersionUID = 6049289111587908986L;

	public HomeMenuItem() {
		super("Home");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		getMenu().getMenuBar().getWindow().getTabPane().getSelectedTab().getDisplay().getBrowser()
		.loadURL("http://forums.browserbot.org");
	}

}
