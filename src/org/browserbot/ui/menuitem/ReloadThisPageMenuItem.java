package org.browserbot.ui.menuitem;

import java.awt.event.ActionEvent;

import org.browserbot.ui.BrowserMenuItem;

public class ReloadThisPageMenuItem extends BrowserMenuItem {

	private static final long serialVersionUID = -4625099856635152748L;

	public ReloadThisPageMenuItem() {
		super("Reload This Page");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		getMenu().getMenuBar().getWindow().getTabPane().getSelectedTab().getDisplay().getBrowser().reload();
	}

}
