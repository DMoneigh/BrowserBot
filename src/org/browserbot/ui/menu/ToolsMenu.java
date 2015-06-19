package org.browserbot.ui.menu;

import org.browserbot.ui.BrowserMenu;
import org.browserbot.ui.menuitem.ClearBrowsingDataMenuItem;
import org.browserbot.ui.menuitem.UpdateMenuItem;
import org.browserbot.ui.menuitem.ViewSourceMenuItem;

public class ToolsMenu extends BrowserMenu {

	private static final long serialVersionUID = 5830804359368887428L;

	public ToolsMenu() {
		super("Tools");
	}

	@Override
	public void addMenuItems() {
		add(new ClearBrowsingDataMenuItem());
		add(new ViewSourceMenuItem());
		add(new UpdateMenuItem());
	}

}
