package org.browserbot.ui.menuitem;

import java.awt.event.ActionEvent;

import org.browserbot.ui.BrowserMenuItem;

public class NewTabMenuItem extends BrowserMenuItem {

	private static final long serialVersionUID = -2435791950463449552L;

	public NewTabMenuItem() {
		super("New tab");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		getMenu().getMenuBar().getWindow().getTabPane().addTab();
	}

}
