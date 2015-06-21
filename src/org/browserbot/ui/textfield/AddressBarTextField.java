package org.browserbot.ui.textfield;

import java.awt.event.ActionEvent;

import org.browserbot.ui.BrowserTextField;
import org.browserbot.ui.BrowserToolBar;

/**
 * The address bar.
 * 
 * @author Desmond Jackson
 */
public class AddressBarTextField extends BrowserTextField {

	/**
	 * The serial uid.
	 */
	private static final long serialVersionUID = -6158836587320083062L;

	@Override
	public void actionPerformed(ActionEvent e) {
		((BrowserToolBar) getParent()).getTab().getDisplay().getBrowser().loadURL(getText());
	}

}
