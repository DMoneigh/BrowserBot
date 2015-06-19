package org.browserbot.ui.menuitem;

import java.awt.event.ActionEvent;

import org.browserbot.ui.BrowserMenuItem;
import org.browserbot.ui.BrowserTab;

public class StopScriptMenuItem extends BrowserMenuItem {

	private static final long serialVersionUID = 4430052699130644031L;

	public StopScriptMenuItem() {
		super("Stop Script");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		BrowserTab tab = getMenu().getMenuBar().getWindow().getTabPane().getSelectedTab();
		if (tab.isScriptRunning()) {
			tab.stopScript();
			setEnabled(false);
		}
	}

}
