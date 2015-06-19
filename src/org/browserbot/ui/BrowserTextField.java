package org.browserbot.ui;

import java.awt.event.ActionListener;

import javax.swing.JTextField;

public abstract class BrowserTextField extends JTextField implements ActionListener {

	private static final long serialVersionUID = 3983393975544546111L;
	
	public BrowserTextField() {
		addActionListener(this);
	}
	
}
