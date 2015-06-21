package org.browserbot.ui;

import java.awt.event.ActionListener;

import javax.swing.JTextField;

/**
 * Represents a browser text field.
 * 
 * @author Desmond Jackson
 */
public abstract class BrowserTextField extends JTextField implements ActionListener {

	/**
	 * The serial uid.
	 */
	private static final long serialVersionUID = 3983393975544546111L;
	
	/**
	 * Creates the browser text field.
	 */
	public BrowserTextField() {
		super();
		addActionListener(this);
	}
	
}
