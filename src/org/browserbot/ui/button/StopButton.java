package org.browserbot.ui.button;

import java.awt.event.ActionEvent;

import javax.swing.Icon;

import org.browserbot.ui.BrowserButton;
import org.browserbot.ui.resource.ResourceManager;

/**
 * The stop button.
 * 
 * @author Desmond Jackson
 */
public class StopButton extends BrowserButton {

	/**
	 * The serial uid.
	 */
	private static final long serialVersionUID = 7158433344934615689L;

	/**
	 * Creates the stop button.
	 */
	public StopButton() {
		super(null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		getToolBar().getTab().getDisplay().getBrowser().stop();
		setEnabled(false);
	}

	@Override
	public Icon getIcon() {
		return ResourceManager.getImage("stop.png");
	}

	@Override
	public String getHoverText() {
		return "Stop";
	}

}
