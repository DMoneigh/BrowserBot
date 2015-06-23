package org.browserbot.ui;

import java.awt.Component;

import javax.swing.JPopupMenu;

import org.browserbot.ui.menuitem.BackPopupMenuItem;
import org.browserbot.ui.menuitem.CopyLinkAddressPopupMenuItem;
import org.browserbot.ui.menuitem.ForwardPopupMenuItem;
import org.browserbot.ui.menuitem.OpenLinkInNewTabPopupMenuItem;
import org.browserbot.ui.menuitem.OpenLinkInNewWindowPopupMenuItem;
import org.browserbot.ui.menuitem.ReloadPopupMenuItem;
import org.browserbot.ui.menuitem.ViewPageSourcePopupMenuItem;

import com.teamdev.jxbrowser.chromium.Browser;

/**
 * The browser popup menu.
 * 
 * @author Desmond Jackson
 */
public class BrowserPopupMenu extends JPopupMenu {
	
	/**
	 * The serial uid.
	 */
	private static final long serialVersionUID = 5346630880646544667L;
	
	/**
	 * The "Back" popup menu item.
	 */
	private BackPopupMenuItem backPopupMenuItem = new BackPopupMenuItem();
	
	/**
	 * The "Forward" popup menu item.
	 */
	private ForwardPopupMenuItem forwardPopupMenuItem = new ForwardPopupMenuItem();
	
	/**
	 * Creates the browser popup menu.
	 */
	public BrowserPopupMenu() {
		super();
	}
	
	/**
	 * Appends base menu items to the popup menu.
	 */
	public void addBaseMenuItems() {
		add(backPopupMenuItem);
		add(forwardPopupMenuItem);
		add(new ReloadPopupMenuItem());
		add(new ViewPageSourcePopupMenuItem());
	}
	
	/**
	 * Appends link menu item to the popup menu.
	 * 
	 * @param linkUrl The url of the link
	 */
	public void addLinkMenuItems(String linkUrl) {
		add(new OpenLinkInNewTabPopupMenuItem(linkUrl));
		add(new OpenLinkInNewWindowPopupMenuItem(linkUrl));
		add(new CopyLinkAddressPopupMenuItem(linkUrl));
	}
	
	@Override
	public void show(Component invoker, int x, int y) {
		Browser browser = ((BrowserDisplay) invoker).getBrowser();
		backPopupMenuItem.setEnabled(browser.canGoBack());
		forwardPopupMenuItem.setEnabled(browser.canGoForward());
		super.show(invoker, x, y);
	}
}
