package org.browserbot.ui.menuitem;

import java.awt.event.ActionEvent;

import org.browserbot.script.Script;
import org.browserbot.ui.BrowserMenuItem;
import org.browserbot.ui.BrowserScriptSelector;

/**
 * The "Start Script" menu item.
 * 
 * @author Desmond Jackson
 */
public class StartScriptMenuItem extends BrowserMenuItem {

	/**
	 * The serial uid.
	 */
	private static final long serialVersionUID = -8766616909329954263L;

	/**
	 * Creates the "Start Script" menu item.
	 */
	public StartScriptMenuItem() {
		super("Start Script");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Script script = new BrowserScriptSelector().getSelectedScript();
		if (script != null) {
			getMenu().getMenuBar().getWindow().getTabPane().getSelectedTab().startScript(script);
			setEnabled(false);
		}
	}

}
