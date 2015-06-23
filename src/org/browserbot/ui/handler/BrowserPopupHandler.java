package org.browserbot.ui.handler;

import java.awt.Rectangle;

import javax.swing.SwingUtilities;

import org.browserbot.ui.BrowserWindow;

import com.teamdev.jxbrowser.chromium.Browser;
import com.teamdev.jxbrowser.chromium.PopupContainer;
import com.teamdev.jxbrowser.chromium.PopupHandler;
import com.teamdev.jxbrowser.chromium.PopupParams;

/**
 * The browser popup handler.
 * 
 * @author Desmond Jackson
 */
public class BrowserPopupHandler extends Object implements PopupHandler {
	
	/**
	 * Creates the browser popup handler.
	 */
	public BrowserPopupHandler() {
		super();
	}

	@Override
	public PopupContainer handlePopup(PopupParams params) {
		return new PopupContainer() {

			@Override
			public void insertBrowser(Browser arg0, Rectangle arg1) {
				SwingUtilities.invokeLater(new Runnable() {

					@Override
					public void run() {
						new BrowserWindow(params.getURL()).setVisible(true);
					}
					
				});
			}
			
		};
	}

}
