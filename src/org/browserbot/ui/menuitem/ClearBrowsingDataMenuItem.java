package org.browserbot.ui.menuitem;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import org.browserbot.ui.BrowserMenuItem;

import com.teamdev.jxbrowser.chromium.Browser;

public class ClearBrowsingDataMenuItem extends BrowserMenuItem {

	private static final long serialVersionUID = -2955700571647828667L;

	public ClearBrowsingDataMenuItem() {
		super("Clear browsing data...");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (JOptionPane.showConfirmDialog(null, "Do you wish to clear your browsing data?") == 0) {
			Browser browser = getMenu().getMenuBar().getWindow().getTabPane().getSelectedTab().getDisplay()
					.getBrowser();
			browser.getCacheStorage().clearCache();
			browser.getCookieStorage().deleteAll();
			JOptionPane.showMessageDialog(null, "Browsing data cleared.");
		}
	}

}
