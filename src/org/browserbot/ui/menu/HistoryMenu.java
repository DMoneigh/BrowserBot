package org.browserbot.ui.menu;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.browserbot.ui.BrowserMenu;
import org.browserbot.ui.menuitem.BackMenuItem;
import org.browserbot.ui.menuitem.ForwardMenuItem;
import org.browserbot.ui.menuitem.HomeMenuItem;

import com.teamdev.jxbrowser.chromium.Browser;

/**
 * The "History" menu.
 * 
 * @author Desmond Jackson
 */
public class HistoryMenu extends BrowserMenu implements ChangeListener {

	/**
	 * The serial uid.
	 */
	private static final long serialVersionUID = 462523589227324681L;
	
	/**
	 * The "Back" menu item.
	 */
	private BackMenuItem backMenuItem;
	
	/**
	 * The "Forward" menu item.
	 */
	private ForwardMenuItem forwardMenuItem;
	
	/**
	 * Creates the "History" menu.
	 */
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
