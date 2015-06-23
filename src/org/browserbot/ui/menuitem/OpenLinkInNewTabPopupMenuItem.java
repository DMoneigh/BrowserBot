package org.browserbot.ui.menuitem;

import java.awt.event.ActionEvent;

import org.browserbot.ui.BrowserMenuItem;

/**
 * The "Open link in new tab" popup menu item.
 * 
 * @author Desmond Jackson
 */
public class OpenLinkInNewTabPopupMenuItem extends BrowserMenuItem {

	/**
	 * The serial uid.
	 */
	private static final long serialVersionUID = 2885376398901000171L;
	
	/**
	 * The link url.
	 */
	private String linkUrl;

	/**
	 * Creates the "Open link in new tab" popup menu item.
	 * 
	 * @param linkUrl The link url
	 */
	public OpenLinkInNewTabPopupMenuItem(String linkUrl) {
		super("Open link in new tab");
		this.linkUrl = linkUrl;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		getDisplay().getTab().getTabPane().addTab(linkUrl);
	}

}
