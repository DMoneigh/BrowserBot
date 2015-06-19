package org.browserbot.ui.menuitem;

import java.awt.event.ActionEvent;

import org.browserbot.ui.BrowserMenuItem;
import org.browserbot.ui.BrowserWindow;

public class NewWindowMenuItem extends BrowserMenuItem {

	private static final long serialVersionUID = 4466111814292279286L;

	public NewWindowMenuItem() {
		super("New window");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		new BrowserWindow().setVisible(true);
	}

}
