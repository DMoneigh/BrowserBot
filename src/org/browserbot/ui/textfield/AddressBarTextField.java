package org.browserbot.ui.textfield;

import java.awt.event.ActionEvent;

import org.browserbot.ui.BrowserTextField;
import org.browserbot.ui.BrowserToolBar;

public class AddressBarTextField extends BrowserTextField {

	private static final long serialVersionUID = -6158836587320083062L;

	@Override
	public void actionPerformed(ActionEvent e) {
		((BrowserToolBar) getParent()).getTab().getDisplay().getBrowser().loadURL(getText());
	}

}
