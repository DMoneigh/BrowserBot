package org.browserbot.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

import org.browserbot.BrowserBot;
import org.browserbot.ui.resource.ResourceManager;

/**
 * The browser window.
 * 
 * @author Desmond Jackson
 */
public class BrowserWindow extends JFrame implements WindowListener {

	/**
	 * The serial uid.
	 */
	private static final long serialVersionUID = 882385961396552922L;
	
	/**
	 * The browser tab pane.
	 */
	private BrowserTabPane tabPane = new BrowserTabPane();
	
	/**
	 * Creates the browser window.
	 */
	public BrowserWindow() {
		super("BrowserBot v" + BrowserBot.MAJOR_VERSION + "." + BrowserBot.MINOR_VERSION);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setIconImage(ResourceManager.getImage("logo.png").getImage());
		setSize(new Dimension(1024, 700));
		setJMenuBar(new BrowserMenuBar());
		add(tabPane, BorderLayout.CENTER);
		addWindowListener(this);
	}
	
	/**
	 * Gets the browser tab pane.
	 * 
	 * @return The browser tab pane
	 */
	public BrowserTabPane getTabPane() {
		return tabPane;
	}
	
	@Override
	public void windowOpened(WindowEvent e) {}

	@Override
	public void windowClosing(WindowEvent e) {}

	@Override
	public void windowClosed(WindowEvent e) {
		tabPane.removeAllTabs();
	}

	@Override
	public void windowIconified(WindowEvent e) {}

	@Override
	public void windowDeiconified(WindowEvent e) {}

	@Override
	public void windowActivated(WindowEvent e) {}

	@Override
	public void windowDeactivated(WindowEvent e) {}

}
