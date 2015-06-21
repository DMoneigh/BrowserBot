package org.browserbot.ui.menuitem;

import java.awt.event.ActionEvent;

import org.browserbot.ui.BrowserMenuItem;
import org.browserbot.ui.BrowserTab;

/**
 * The "Stop Script" menu item.
 * 
 * @author Desmond Jackson
 */
public class StopScriptMenuItem extends BrowserMenuItem {

	/**
	 * The serial uid.
	 */
	private static final long serialVersionUID = 4430052699130644031L;

	/**
	 * Creates the "Stop Script" menu item.
	 */
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
