package org.browserbot.ui.menuitem;

import java.awt.event.ActionEvent;

import org.browserbot.ui.BrowserMenuItem;

public class ForwardMenuItem extends BrowserMenuItem {

	private static final long serialVersionUID = 5160869639753609654L;

	public ForwardMenuItem() {
		super("Forward");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		getMenu().getMenuBar().getWindow().getTabPane().getSelectedTab().getDisplay().getBrowser().goBack();
	}

}
