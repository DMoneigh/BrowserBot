package org.browserbot.ui.menu;

import org.browserbot.ui.BrowserMenu;
import org.browserbot.ui.menuitem.CopyMenuItem;
import org.browserbot.ui.menuitem.CutMenuItem;
import org.browserbot.ui.menuitem.PasteMenuItem;

public class EditMenu extends BrowserMenu {

	private static final long serialVersionUID = -3967355326155968741L;

	public EditMenu() {
		super("Edit");
	}

	@Override
	public void addMenuItems() {
		add(new CutMenuItem());
		add(new CopyMenuItem());
		add(new PasteMenuItem());
	}

}
