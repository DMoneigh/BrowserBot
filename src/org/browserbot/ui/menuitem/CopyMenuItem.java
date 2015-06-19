package org.browserbot.ui.menuitem;

import java.awt.event.ActionEvent;

import org.browserbot.ui.BrowserMenuItem;

import com.teamdev.jxbrowser.chromium.EditorCommand;

public class CopyMenuItem extends BrowserMenuItem {

	private static final long serialVersionUID = -1856904886331789706L;

	public CopyMenuItem() {
		super("Copy");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		getMenu().getMenuBar().getWindow().getTabPane().getSelectedTab().getDisplay().getBrowser()
		.executeCommand(EditorCommand.COPY);
	}

}
