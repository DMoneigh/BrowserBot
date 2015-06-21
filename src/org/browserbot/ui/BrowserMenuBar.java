package org.browserbot.ui;

import javax.swing.JMenuBar;

import org.browserbot.ui.menu.EditMenu;
import org.browserbot.ui.menu.FileMenu;
import org.browserbot.ui.menu.HistoryMenu;
import org.browserbot.ui.menu.ScriptsMenu;
import org.browserbot.ui.menu.ToolsMenu;
import org.browserbot.ui.menu.ViewMenu;

/**
 * The browser menu bar.
 * 
 * @author Desmond Jackson
 */
public class BrowserMenuBar extends JMenuBar {
	
	/**
	 * The serial uid.
	 */
	private static final long serialVersionUID = -5966924833651576206L;
	
	/**
	 * Creates the browser menu bar.
	 */
	public BrowserMenuBar() {
		super();
		add(new FileMenu());
		add(new EditMenu());
		add(new ViewMenu());
		add(new HistoryMenu());
		add(new ToolsMenu());
		add(new ScriptsMenu());
	}
	
	/**
	 * Gets the browser window.
	 * 
	 * @return The browser window
	 */
	public BrowserWindow getWindow() {
		return (BrowserWindow) getParent().getParent().getParent();
	}
	
}
