package org.browserbot.ui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTabbedPane;

import org.browserbot.ui.button.NewTabButton;

/**
 * The browser tab pane.
 * 
 * @author Desmond Jackson
 */
public class BrowserTabPane extends JTabbedPane implements MouseListener {

	/**
	 * The serial uid.
	 */
	private static final long serialVersionUID = -6642032114386972204L;

	/**
	 * The tabs in the tab pane.
	 */
	private List<BrowserTab> tabs = new ArrayList<BrowserTab>();

	/**
	 * Creates the browser tab pane.
	 */
	public BrowserTabPane() {
		super();
		addTab(null, null);
		setTabComponentAt(0, new NewTabButton());
		addTab();
		addMouseListener(this);
	}

	/**
	 * Appends a tab to the tab pane.
	 */
	public void addTab() {
		BrowserTab tab = new BrowserTab();
		tabs.add(tab);
		int index = tabs.indexOf(tab);
		insertTab(null, null, tab, null, index);
		setTabComponentAt(index, tab.getTabComponent());
		setSelectedIndex(index);
	}
	
	/**
	 * Appends a tab and navigates to the specified url.
	 * 
	 * @param url The url to navigate to
	 */
	public void addTab(String url) {
		addTab();
		getSelectedTab().getDisplay().getBrowser().loadURL(url);
	}

	/**
	 * Removes a tab from the tab pane.
	 * 
	 * @param tab The tab to remove
	 */
	public void removeTab(BrowserTab tab) {
		int index = tabs.indexOf(tab);
		tabs.remove(tab);
		removeTabAt(index);
		tab.destroy();
		if (tabs.isEmpty())
			getWindow().dispose();
		else
			setSelectedIndex(tabs.size() - 1);
	}

	/**
	 * Removes all tabs from the tab pane.
	 */
	public void removeAllTabs() {
		for (int i = 0; i < tabs.size(); i++)
			removeTab(tabs.get(i));
	}

	/**
	 * Gets the selected browser tab.
	 * 
	 * @return The selected browser tab
	 */
	public BrowserTab getSelectedTab() {
		return tabs.get(getSelectedIndex());
	}

	/**
	 * Gets the browser window.
	 * 
	 * @return The browser window
	 */
	public BrowserWindow getWindow() {
		return (BrowserWindow) getParent().getParent().getParent().getParent();
	}

	@Override
	public void mouseClicked(MouseEvent e) {}

	@Override
	public void mousePressed(MouseEvent e) {
		if (getSelectedIndex() == tabs.size())
			addTab();
	}

	@Override
	public void mouseReleased(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}
}
