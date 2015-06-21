package org.browserbot.ui;

import java.awt.event.MouseListener;

import javax.swing.JLabel;

/**
 * Represents a browser label.
 * 
 * @author Desmond Jackson
 */
public abstract class BrowserLabel extends JLabel implements MouseListener {

	/**
	 * The serial uid.
	 */
	private static final long serialVersionUID = 1883610409043755528L;
	
	/**
	 * Creates a browser label.
	 * 
	 * @param text The text to appear on the label
	 */
	public BrowserLabel(String text) {
		super(text);
		addMouseListener(this);
	}

}
