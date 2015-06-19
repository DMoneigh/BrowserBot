package org.browserbot.ui;

import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

public abstract class BrowserMenuItem extends JMenuItem implements ActionListener {

	private static final long serialVersionUID = 6354927302920523229L;
	
	public BrowserMenuItem(String name) {
		super(name);
		addActionListener(this);
	}
	
	public BrowserMenu getMenu() {
		return (BrowserMenu) ((JPopupMenu) getParent()).getInvoker();
	}
	
}
