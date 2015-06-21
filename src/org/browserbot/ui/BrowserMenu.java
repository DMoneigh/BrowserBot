package org.browserbot.ui;

import javax.swing.JMenu;

/**
 * Represents a browser menu.
 * 
 * @author Desmond Jackson
 */
public abstract class BrowserMenu extends JMenu {

	/**
	 * The serial uid.
	 */
	private static final long serialVersionUID = 1409205906963748933L;
	
	/**
	 * Creates a browser menu.
	 * 
	 * @param name The name of the menu
	 */
	public BrowserMenu(String name) {
		super(name);
		addMenuItems();
	}
	
	/**
	 * Gets the browser menu bar.
	 * 
	 * @return The browser menu bar
	 */
	public BrowserMenuBar getMenuBar() {
		return (BrowserMenuBar) getParent();
	}
	
	/**
	 * Appends menu items to the menu.
	 */
	public abstract void addMenuItems();
	
}
