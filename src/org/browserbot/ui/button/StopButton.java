package org.browserbot.ui.button;

import java.awt.event.ActionEvent;

import javax.swing.Icon;

import org.browserbot.ui.BrowserButton;
import org.browserbot.ui.resource.ResourceManager;

public class StopButton extends BrowserButton {

	private static final long serialVersionUID = 7158433344934615689L;

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
