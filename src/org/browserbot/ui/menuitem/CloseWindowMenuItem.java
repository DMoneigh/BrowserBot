package org.browserbot.ui.menuitem;

import java.awt.event.ActionEvent;

import org.browserbot.ui.BrowserMenuItem;

public class CloseWindowMenuItem extends BrowserMenuItem {

	private static final long serialVersionUID = 6883843762852634804L;

	public CloseWindowMenuItem() {
		super("Close Window");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		getMenu().getMenuBar().getWindow().dispose();
	}

}
