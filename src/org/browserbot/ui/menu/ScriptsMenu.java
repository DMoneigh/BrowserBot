package org.browserbot.ui.menu;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.browserbot.ui.BrowserMenu;
import org.browserbot.ui.BrowserTab;
import org.browserbot.ui.menuitem.CompileMenuItem;
import org.browserbot.ui.menuitem.StartScriptMenuItem;
import org.browserbot.ui.menuitem.StopScriptMenuItem;

/**
 * The "Scripts" menu.
 * 
 * @author Desmond Jacskon
 */
public class ScriptsMenu extends BrowserMenu implements ChangeListener {

	/**
	 * The serial uid.
	 */
	private static final long serialVersionUID = -5018546515254966220L;
	
	/**
	 * The "Start Script" menu item.
	 */
	private StartScriptMenuItem startScriptMenuItem;
	
	/**
	 * The "Stop Script" menu item.
	 */
	private StopScriptMenuItem stopScriptMenuItem;

	/**
	 * Creates the "Scripts" menu.
	 */
	public ScriptsMenu() {
		super("Scripts");
		addChangeListener(this);
	}

	@Override
	public void addMenuItems() {
		add(new CompileMenuItem());
		startScriptMenuItem = new StartScriptMenuItem();
		add(startScriptMenuItem);
		stopScriptMenuItem = new StopScriptMenuItem();
		add(stopScriptMenuItem);
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		BrowserTab tab = getMenuBar().getWindow().getTabPane().getSelectedTab();
		startScriptMenuItem.setEnabled(!tab.isScriptRunning());
		stopScriptMenuItem.setEnabled(tab.isScriptRunning());
	}

}
