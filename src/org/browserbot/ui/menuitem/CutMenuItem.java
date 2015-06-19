package org.browserbot.ui.menuitem;

import java.awt.event.ActionEvent;

import org.browserbot.ui.BrowserMenuItem;

import com.teamdev.jxbrowser.chromium.EditorCommand;

public class CutMenuItem extends BrowserMenuItem {

	private static final long serialVersionUID = -9146743698426641802L;

	public CutMenuItem() {
		super("Cut");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		getMenu().getMenuBar().getWindow().getTabPane().getSelectedTab().getDisplay().getBrowser()
		.executeCommand(EditorCommand.CUT);
	}

}
