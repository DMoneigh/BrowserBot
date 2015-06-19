package org.browserbot.ui.menuitem;

import java.awt.event.ActionEvent;

import org.browserbot.ui.BrowserMenuItem;
import org.browserbot.ui.BrowserTab;

public class CloseTabMenuItem extends BrowserMenuItem {

	private static final long serialVersionUID = -1606710130931128145L;

	public CloseTabMenuItem() {
		super("Close Tab");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		BrowserTab tab = getMenu().getMenuBar().getWindow().getTabPane().getSelectedTab();
		tab.getTabPane().removeTab(tab);
	}

}
