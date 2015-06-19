package org.browserbot.ui.menuitem;

import java.awt.event.ActionEvent;

import org.browserbot.ui.BrowserMenuItem;

import com.teamdev.jxbrowser.chromium.Browser;

public class ViewSourceMenuItem extends BrowserMenuItem {

	private static final long serialVersionUID = 2821751253696972086L;

	public ViewSourceMenuItem() {
		super("View source");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Browser browser = getMenu().getMenuBar().getWindow().getTabPane().getSelectedTab().getDisplay()
				.getBrowser();
		browser.loadURL("view-source:" + browser.getURL());
	}

}
