package org.browserbot.ui;

import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

/**
 * Represents a browser menu item.
 * 
 * @author Desmond Jackson
 */
public abstract class BrowserMenuItem extends JMenuItem implements ActionListener {

	/**
	 * The serial uid.
	 */
	private static final long serialVersionUID = 6354927302920523229L;
	
	/**
	 * Creates the browser menu item.
	 * 
	 * @param name The name of the browser menu item
	 */
	public BrowserMenuItem(String name) {
		super(name);
		addActionListener(this);
	}
	
	/**
	 * Gets the browser menu.
	 * 
	 * @return The browser menu
	 */
	public BrowserMenu getMenu() {
		return (BrowserMenu) ((JPopupMenu) getParent()).getInvoker();
	}
	
}
