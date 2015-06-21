package org.browserbot.ui.menuitem;

import java.awt.event.ActionEvent;

import org.browserbot.ui.BrowserMenuItem;

import com.teamdev.jxbrowser.chromium.EditorCommand;

/**
 * The "Paste" menu item.
 * 
 * @author Desmond Jackson
 */
public class PasteMenuItem extends BrowserMenuItem {

	/**
	 * The serial uid.
	 */
	private static final long serialVersionUID = -8594927578630894888L;

	/**
	 * Creates the "Paste" menu item.
	 */
	public PasteMenuItem() {
		super("Paste");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		getMenu().getMenuBar().getWindow().getTabPane().getSelectedTab().getDisplay().getBrowser()
		.executeCommand(EditorCommand.PASTE);
	}

}
