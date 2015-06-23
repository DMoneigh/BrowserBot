package org.browserbot.ui.menuitem;

import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;

import org.browserbot.ui.BrowserMenuItem;

/**
 * The "Copy link address" popup menu item.
 * 
 * @author Desmond Jackson
 */
public class CopyLinkAddressPopupMenuItem extends BrowserMenuItem {

	/**
	 * The serial uid.
	 */
	private static final long serialVersionUID = 3310894851211655219L;
	
	/**
	 * The link url.
	 */
	private String linkUrl;

	/**
	 * Creates the "Copy link address" popup menu item.
	 */
	public CopyLinkAddressPopupMenuItem(String linkUrl) {
		super("Copy link address");
		this.linkUrl = linkUrl;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new StringSelection(linkUrl), null);
	}

}
