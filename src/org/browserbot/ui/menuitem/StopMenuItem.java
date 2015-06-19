package org.browserbot.ui.menuitem;

import java.awt.event.ActionEvent;

import org.browserbot.ui.BrowserMenuItem;

public class StopMenuItem extends BrowserMenuItem {

	private static final long serialVersionUID = 5696931695393713446L;

	public StopMenuItem() {
		super("Stop");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		getMenu().getMenuBar().getWindow().getTabPane().getSelectedTab().getDisplay().getBrowser().stop();
	}

}
