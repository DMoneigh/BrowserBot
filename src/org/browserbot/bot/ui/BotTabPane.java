package org.browserbot.bot.ui;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JTabbedPane;

/**
 * The bot tab pane.
 * 
 * @author Desmond Jackson
 */
public class BotTabPane extends JTabbedPane {

	/**
	 * The serial uid.
	 */
	private static final long serialVersionUID = 5207364836847493036L;
	
	/**
	 * The bot window.
	 */
	private BotWindow window;
	
	/**
	 * The bot tabs.
	 */
	private List<BotTab> tabs = new ArrayList<BotTab>();
	
	/**
	 * Creates the bot tab pane.
	 * 
	 * @param window The bot window
	 */
	public BotTabPane(BotWindow window) {
		super();
		this.window = window;
		addTab();
	}
	
	/**
	 * Appends a tab to the tab pane.
	 */
	public void addTab() {
		BotTab tab = new BotTab(this);
		tabs.add(tab);
		addTab(null, tab);
		int index = tabs.indexOf(tab);
		setTabComponentAt(index, tab.getTabComponent());
		setSelectedIndex(index);
	}
	
	/**
	 * Removes a bot tab from the bot tab pane.
	 * 
	 * @param tab The bot tab
	 */
	public void removeTab(BotTab tab) {
		int index = tabs.indexOf(tab);
		tabs.remove(index);
		removeTabAt(index);
		tab.destroy();
		if (tabs.isEmpty())
			window.dispose();
	}
	
	/**
	 * Removes all tabs from the tab pane.
	 */
	public void removeAllTabs() {
		for (int i = 0; i < tabs.size(); i++)
			removeTab(tabs.get(i));
	}
	
	/**
	 * Gets the bot window.
	 * 
	 * @return The bot window
	 */
	public BotWindow getWindow() {
		return window;
	}

}
