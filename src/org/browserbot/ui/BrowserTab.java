package org.browserbot.ui;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

import org.browserbot.script.Script;

public class BrowserTab extends JPanel {

	private static final long serialVersionUID = 6616800650556116436L;

	private BrowserTabComponent tabComponent = new BrowserTabComponent(this);

	private BrowserToolBar toolBar = new BrowserToolBar();

	private BrowserDisplay display = new BrowserDisplay();

	private Script script = null;

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
		add(display, gbc);
	}

	public void startScript(Script script) {
		this.script = script;
		script.setBrowser(display.getBrowser());
		script.start();
		tabComponent.setBackground(Color.GREEN);
	}

	public void stopScript() {
		script.requestStop();
		while (script.isAlive())
			script.halt(1000);
		script = null;
		tabComponent.setBackground(null);
	}

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

	public boolean isScriptRunning() {
		return script != null;
	}

	public BrowserDisplay getDisplay() {
		return display;
	}

	public BrowserToolBar getToolBar() {
		return toolBar;
	}

	public BrowserTabComponent getTabComponent() {
		return tabComponent;
	}

	public BrowserTabPane getTabPane() {
		return (BrowserTabPane) getParent();
	}
}
