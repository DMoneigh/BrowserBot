package org.browserbot.ui;

import javax.swing.JMenu;

public abstract class BrowserMenu extends JMenu {

	private static final long serialVersionUID = 1409205906963748933L;
	
	public BrowserMenu(String name) {
		super(name);
		addMenuItems();
	}
	
	public BrowserMenuBar getMenuBar() {
		return (BrowserMenuBar) getParent();
	}
	
	public abstract void addMenuItems();
	
}
