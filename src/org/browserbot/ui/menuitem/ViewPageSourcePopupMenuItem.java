package org.browserbot.ui.menuitem;

import java.awt.event.ActionEvent;

import org.browserbot.ui.BrowserMenuItem;

import com.teamdev.jxbrowser.chromium.Browser;

/**
 * The "View page source" menu item.
 * 
 * @author Desmond Jackson
 */
public class ViewPageSourcePopupMenuItem extends BrowserMenuItem {

	/**
	 * The serial uid.
	 */
	private static final long serialVersionUID = 7216932746669018008L;

	/**
	 * Creates the "View page source" popup menu item.
	 */
	public ViewPageSourcePopupMenuItem() {
		super("View page source");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Browser browser = getDisplay().getBrowser();
		browser.loadURL("view-source:" + browser.getURL());
	}

}
