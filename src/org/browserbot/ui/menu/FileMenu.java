package org.browserbot.ui.menu;

import org.browserbot.ui.BrowserMenu;
import org.browserbot.ui.menuitem.CloseTabMenuItem;
import org.browserbot.ui.menuitem.CloseWindowMenuItem;
import org.browserbot.ui.menuitem.NewTabMenuItem;
import org.browserbot.ui.menuitem.NewWindowMenuItem;

public class FileMenu extends BrowserMenu {

	private static final long serialVersionUID = -6156709258701348809L;

	public FileMenu() {
		super("File");
	}

	@Override
	public void addMenuItems() {
		add(new NewTabMenuItem());
		add(new NewWindowMenuItem());
		add(new CloseWindowMenuItem());
		add(new CloseTabMenuItem());
	}

}
