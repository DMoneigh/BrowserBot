package org.browserbot.ui.menuitem;

import java.awt.event.ActionEvent;

import javax.swing.SwingUtilities;

import org.browserbot.ui.BrowserMenuItem;
import org.browserbot.ui.BrowserWindow;

/**
 * The "Open link in new window" popup menu item.
 * 
 * @author Desmond Jackson
 */
public class OpenLinkInNewWindowPopupMenuItem extends BrowserMenuItem {

	/**
	 * The serial uid.
	 */
	private static final long serialVersionUID = -4733398425434726589L;

	/**
	 * The link url.
	 */
	private String linkUrl;
	
	/**
	 * Creates the "Open link in new window" popup menu item.
	 * 
	 * @param linkUrl The link url
	 */
	public OpenLinkInNewWindowPopupMenuItem(String linkUrl) {
		super("Open link in new window");
		this.linkUrl = linkUrl;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				new BrowserWindow(linkUrl).setVisible(true);
			}
		
		});
	}

}
