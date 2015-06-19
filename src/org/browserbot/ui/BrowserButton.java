package org.browserbot.ui;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.JButton;

public abstract class BrowserButton extends JButton implements ActionListener {

	private static final long serialVersionUID = 6783756428355675616L;
	
	public BrowserButton(String name) {
		super(name);
		setPreferredSize(new Dimension(20, 20));
		setToolTipText(getHoverText());
		setIcon(getIcon());
		addActionListener(this);
	}
	
	public BrowserToolBar getToolBar() {
		return (BrowserToolBar) getParent();
	}

	public BrowserTabPane getTabPane() {
		Component parent = getParent();
		while (!(parent instanceof BrowserTabPane))
			parent = parent.getParent();
		return (BrowserTabPane) parent;
	}
	
	@Override
	public abstract Icon getIcon();
	
	public abstract String getHoverText();
}
