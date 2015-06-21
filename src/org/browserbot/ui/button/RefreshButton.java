package org.browserbot.ui.button;

import java.awt.event.ActionEvent;

import javax.swing.Icon;

import org.browserbot.ui.BrowserButton;
import org.browserbot.ui.resource.ResourceManager;

/**
 * The refresh button.
 * 
 * @author Desmond Jackson
 */
public class RefreshButton extends BrowserButton {

	/**
	 * The serial uid.
	 */
	private static final long serialVersionUID = -3520046794525428134L;

	/**
	 * Creates the refresh button.
	 */
	public RefreshButton() {
		super(null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		getToolBar().getTab().getDisplay().getBrowser().reload();
	}

	@Override
	public Icon getIcon() {
		return ResourceManager.getImage("refresh.png");
	}

	@Override
	public String getHoverText() {
		return "Refresh";
	}

}
