package org.browserbot.ui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTabbedPane;

import org.browserbot.ui.button.NewTabButton;

public class BrowserTabPane extends JTabbedPane implements MouseListener {

	private static final long serialVersionUID = -6642032114386972204L;
	
	private List<BrowserTab> tabs = new ArrayList<BrowserTab>();
	
	public BrowserTabPane() {
		addTab(null, null);
		setTabComponentAt(0, new NewTabButton());
		addTab();
		addMouseListener(this);
	}
	
	public void addTab() {
		BrowserTab tab = new BrowserTab();
		tabs.add(tab);
		int index = tabs.indexOf(tab);
		insertTab(null, null, tab, null, index);
		setTabComponentAt(index, tab.getTabComponent());
		setSelectedIndex(index);
	}
	
	public void removeTab(BrowserTab tab) {
		int index = tabs.indexOf(tab);
		tabs.remove(tab);
		removeTabAt(index);
		tab.destroy();
		if (tabs.isEmpty())
			getWindow().dispose();
	}
	
	public void removeAllTabs() {
		for (int i = 0; i < tabs.size(); i++)
			removeTab(tabs.get(i));
	}
	
	public BrowserTab getSelectedTab() {
		return tabs.get(getSelectedIndex());
	}
	
	public BrowserWindow getWindow() {
		return (BrowserWindow) getParent().getParent().getParent().getParent();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (getSelectedIndex() == tabs.size())
			addTab();
	}

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}
}
