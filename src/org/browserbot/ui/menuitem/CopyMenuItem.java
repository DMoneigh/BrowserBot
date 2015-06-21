package org.browserbot.ui.menuitem;

import java.awt.event.ActionEvent;

import org.browserbot.ui.BrowserMenuItem;

import com.teamdev.jxbrowser.chromium.EditorCommand;

/**
 * The "Copy" menu item.
 * 
 * @author Desmond Jackson
 */
public class CopyMenuItem extends BrowserMenuItem {

	/**
	 * The serial uid.
	 */
	private static final long serialVersionUID = -1856904886331789706L;

	/**
	 * Creates the "Copy" menu item.
	 */
	public CopyMenuItem() {
		super("Copy");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		getMenu().getMenuBar().getWindow().getTabPane().getSelectedTab().getDisplay().getBrowser()
		.executeCommand(EditorCommand.COPY);
	}

}
