package org.browserbot.ui;

import java.awt.event.MouseListener;

import javax.swing.JLabel;

public abstract class BrowserLabel extends JLabel implements MouseListener {

	private static final long serialVersionUID = 1883610409043755528L;
	
	public BrowserLabel(String text) {
		super(text);
		addMouseListener(this);
	}

}
