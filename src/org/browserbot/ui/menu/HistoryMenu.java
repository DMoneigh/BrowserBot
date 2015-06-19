package org.browserbot.ui.menu;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.browserbot.ui.BrowserMenu;
import org.browserbot.ui.menuitem.BackMenuItem;
import org.browserbot.ui.menuitem.ForwardMenuItem;
import org.browserbot.ui.menuitem.HomeMenuItem;

import com.teamdev.jxbrowser.chromium.Browser;

public class HistoryMenu extends BrowserMenu implements ChangeListener {

	private static final long serialVersionUID = 462523589227324681L;
	
	private BackMenuItem backMenuItem;
	
	private ForwardMenuItem forwardMenuItem;
	
	public HistoryMenu() {
		super("History");
		addChangeListener(this);
	}

	@Override
	public void addMenuItems() {
		add(new HomeMenuItem());
		backMenuItem = new BackMenuItem();
		add(backMenuItem);
		forwardMenuItem = new ForwardMenuItem();
		add(forwardMenuItem);
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		Browser browser = getMenuBar().getWindow().getTabPane().getSelectedTab().getDisplay().getBrowser();
		backMenuItem.setEnabled(browser.canGoBack());
		forwardMenuItem.setEnabled(browser.canGoForward());
	}

}
