package org.browserbot.bot.ui;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;

import org.browserbot.bot.script.Script;

/**
 * Represents a bot tab.
 * 
 * @author Desmond Jackson
 */
public class BotTab extends JPanel {

	/**
	 * The serial uid.
	 */
	private static final long serialVersionUID = -7466437789700134466L;

	/**
	 * The bot tab pane.
	 */
	private BotTabPane tabPane;

	/**
	 * The bot tab component.
	 */
	private BotTabComponent tabComponent = new BotTabComponent(this);

	/**
	 * The bot tool bar.
	 */
	private BotToolBar toolBar = new BotToolBar(this);

	/**
	 * The bot view.
	 */
	private BotView view = new BotView(this);

	/**
	 * The script for the bot tab.
	 */
	private Script script = null;

	/**
	 * Creates the bot tab.
	 * 
	 * @param tabPane The bot tab pane
	 */
	public BotTab(BotTabPane tabPane) {
		super();
		this.tabPane = tabPane;
		add(toolBar, BorderLayout.NORTH);
		add(view, BorderLayout.CENTER);
	}

	/**
	 * Destroys the bot tab.
	 */
	public void destroy() {
		tabPane = null;
		tabComponent = null;
		toolBar = null;
		view.getBrowser().dispose();
		view = null;
		if (script != null && script.isAlive())
			script.interrupt();
	}

	/**
	 * Starts and sets the script for the bot tab.
	 * 
	 * @param script The script to set
	 */
	public void startScript(Script script) {
		if (script != null)
			stopScript();
		this.script = script;
		script.setBrowser(view.getBrowser());
		script.start();
		tabComponent.setBackground(Color.GREEN);
	}

	/**
	 * Stops and unsets the script for the bot tab.
	 */
	public void stopScript() {
		if (script != null) {
			script.requestStop();
			while (script.isAlive())
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			script = null;
			tabComponent.setBackground(null);
		}
	}

	/**
	 * Gets the bot view.
	 * 
	 * @return The bot view
	 */
	public BotView getView() {
		return view;
	}

	/**
	 * Gets the bot tool bar.
	 * 
	 * @return The bot tool bar
	 */
	public BotToolBar getToolBar() {
		return toolBar;
	}

	/**
	 * Gets the bot tab component.
	 * 
	 * @return The bot tab component
	 */
	public BotTabComponent getTabComponent() {
		return tabComponent;
	}

	/**
	 * Gets the bot tab pane.
	 * 
	 * @return The bot tab pane
	 */
	public BotTabPane getTabPane() {
		return tabPane;
	}

}
