package org.browserbot.ui.menu;

import org.browserbot.ui.BrowserMenu;
import org.browserbot.ui.menuitem.CloseTabMenuItem;
import org.browserbot.ui.menuitem.CloseWindowMenuItem;
import org.browserbot.ui.menuitem.NewTabMenuItem;
import org.browserbot.ui.menuitem.NewWindowMenuItem;

/**
 * The "File" menu.
 * 
 * @author Desmond Jackson
 */
public class FileMenu extends BrowserMenu {

	/**
	 * The serial uid.
	 */
	private static final long serialVersionUID = -6156709258701348809L;

	/**
	 * Creates the "File" menu.
	 */
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
