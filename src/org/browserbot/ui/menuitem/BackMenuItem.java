package org.browserbot.ui.menuitem;

import java.awt.event.ActionEvent;

import org.browserbot.ui.BrowserMenuItem;

public class BackMenuItem extends BrowserMenuItem {

	private static final long serialVersionUID = 9203369814504754564L;

	public BackMenuItem() {
		super("Back");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		getMenu().getMenuBar().getWindow().getTabPane().getSelectedTab().getDisplay().getBrowser().goBack();
	}

}
