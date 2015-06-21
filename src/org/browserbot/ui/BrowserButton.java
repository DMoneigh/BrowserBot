package org.browserbot.ui;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.JButton;

/**
 * Represents a browser button.
 * 
 * @author Desmond Jackson
 */
public abstract class BrowserButton extends JButton implements ActionListener {

	/**
	 * The serial uid.
	 */
	private static final long serialVersionUID = 6783756428355675616L;
	
	/**
	 * Creates a new browser button.
	 * 
	 * @param name The name of the browser button
	 */
	public BrowserButton(String name) {
		super(name);
		setPreferredSize(new Dimension(20, 20));
		setToolTipText(getHoverText());
		setIcon(getIcon());
		addActionListener(this);
	}
	
	/**
	 * Gets the browser tool bar.
	 * 
	 * @return The browser tool bar
	 */
	public BrowserToolBar getToolBar() {
		return (BrowserToolBar) getParent();
	}

	/**
	 * Gets the browser tab pane.
	 * 
	 * @return the browser tab pane
	 */
	public BrowserTabPane getTabPane() {
		Component parent = getParent();
		while (!(parent instanceof BrowserTabPane))
			parent = parent.getParent();
		return (BrowserTabPane) parent;
	}
	
	@Override
	public abstract Icon getIcon();
	
	/**
	 * Gets the text to display when component is hovered.
	 * 
	 * @return The text to display when the component is hovered
	 */
	public abstract String getHoverText();
}
