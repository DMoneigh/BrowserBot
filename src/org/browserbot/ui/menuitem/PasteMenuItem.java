package org.browserbot.ui.menuitem;

import java.awt.event.ActionEvent;

import org.browserbot.ui.BrowserMenuItem;

import com.teamdev.jxbrowser.chromium.EditorCommand;

public class PasteMenuItem extends BrowserMenuItem {

	private static final long serialVersionUID = -8594927578630894888L;

	public PasteMenuItem() {
		super("Paste");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		getMenu().getMenuBar().getWindow().getTabPane().getSelectedTab().getDisplay().getBrowser()
		.executeCommand(EditorCommand.PASTE);
	}

}
