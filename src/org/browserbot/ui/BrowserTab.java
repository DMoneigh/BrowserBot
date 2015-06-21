package org.browserbot.ui;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JPanel;

import org.browserbot.script.Script;

/**
 * The browser tab.
 * 
 * @author Desmond Jackson
 */
public class BrowserTab extends JPanel {

	/**
	 * The serial uid.
	 */
	private static final long serialVersionUID = 6616800650556116436L;

	/**
	 * The browser tab component.
	 */
	private BrowserTabComponent tabComponent = new BrowserTabComponent(this);

	/**
	 * The browser tool bar.
	 */
	private BrowserToolBar toolBar = new BrowserToolBar();

	/**
	 * The browser display.
	 */
	private BrowserDisplay display = new BrowserDisplay();

	/**
	 * The script that the tab controls.
	 */
	private Script script = null;

	/**
	 * Creates the browser tab.
	 */
	public BrowserTab() {
		super(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.anchor = GridBagConstraints.NORTH;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.weightx = 1;
		gbc.weighty = 1;
		add(toolBar, gbc);
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = new Insets(25, 0, 0, 0);
		add(display, gbc);
	}

	/**
	 * Starts a script for the browser tab.
	 * 
	 * @param script The script to start
	 */
	public void startScript(Script script) {
		this.script = script;
		script.setBrowser(display.getBrowser());
		script.start();
		tabComponent.setBackground(Color.GREEN);
	}

	/**
	 * Stops the script running on the browser tab.
	 */
	public void stopScript() {
		script.requestStop();
		while (script.isAlive())
			script.halt(1000);
		script = null;
		tabComponent.setBackground(null);
	}

	/**
	 * Destroys the tab.
	 */
	public void destroy() {
		if (script != null) {
			script.interrupt();
			script = null;
		}
		display.getBrowser().dispose();
		display = null;
		toolBar = null;
		tabComponent = null;
	}

	/**
	 * Checks whether there is a script running on the browser tab.
	 * 
	 * @return true if a script is running on the browser tab
	 */
	public boolean isScriptRunning() {
		return script != null;
	}

	/**
	 * Gets the browser display.
	 * 
	 * @return The browser display
	 */
	public BrowserDisplay getDisplay() {
		return display;
	}

	/**
	 * Gets the browser tool bar.
	 * 
	 * @return The browser tool bar
	 */
	public BrowserToolBar getToolBar() {
		return toolBar;
	}

	/**
	 * Gets the browser tab component.
	 * 
	 * @return The browser tab component
	 */
	public BrowserTabComponent getTabComponent() {
		return tabComponent;
	}

	/**
	 * Gets the browser tab pane.
	 * 
	 * @return The browser tab pane
	 */
	public BrowserTabPane getTabPane() {
		return (BrowserTabPane) getParent();
	}
}
