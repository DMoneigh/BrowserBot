package org.browserbot.ui.handler;

import java.awt.Point;

import org.browserbot.ui.BrowserDisplay;
import org.browserbot.ui.BrowserPopupMenu;

import com.teamdev.jxbrowser.chromium.ContextMenuHandler;
import com.teamdev.jxbrowser.chromium.ContextMenuParams;

/**
 * The browser context menu handler.
 * 
 * @author Desmond Jackson
 */
public class BrowserContextMenuHandler extends Object implements ContextMenuHandler {
	
	/**
	 * The browser display.
	 */
	private BrowserDisplay display;
	
	/**
	 * Creates the browser context menu handler.
	 * 
	 * @param display The browser display
	 */
	public BrowserContextMenuHandler(BrowserDisplay display) {
		super();
		this.display = display;
	}

	@Override
	public void showContextMenu(ContextMenuParams params) {
		BrowserPopupMenu popupMenu = new BrowserPopupMenu();
		Point location = params.getLocation();
		if (!params.getLinkText().isEmpty())
			popupMenu.addLinkMenuItems(params.getLinkURL());
		else
			popupMenu.addBaseMenuItems();
		popupMenu.show(display, location.x, location.y);
	}

}
