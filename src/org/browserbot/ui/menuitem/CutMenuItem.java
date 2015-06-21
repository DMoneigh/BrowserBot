package org.browserbot.ui.menuitem;

import java.awt.event.ActionEvent;

import org.browserbot.ui.BrowserMenuItem;

import com.teamdev.jxbrowser.chromium.EditorCommand;

/**
 * The "Cut" menu item.
 * 
 * @author Desmond Jackson
 */
public class CutMenuItem extends BrowserMenuItem {

	/**
	 * The serial uid.
	 */
	private static final long serialVersionUID = -9146743698426641802L;

	/**
	 * Creates the "Cut" menu item.
	 */
	public CutMenuItem() {
		super("Cut");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		getMenu().getMenuBar().getWindow().getTabPane().getSelectedTab().getDisplay().getBrowser()
		.executeCommand(EditorCommand.CUT);
	}

}
