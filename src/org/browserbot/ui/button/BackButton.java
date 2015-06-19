package org.browserbot.ui.button;

import java.awt.event.ActionEvent;

import javax.swing.Icon;

import org.browserbot.ui.BrowserButton;
import org.browserbot.ui.resource.ResourceManager;

public class BackButton extends BrowserButton {

	private static final long serialVersionUID = 9099882215558951803L;

	public BackButton() {
		super(null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		getToolBar().getTab().getDisplay().getBrowser().goBack();
	}

	@Override
	public Icon getIcon() {
		return ResourceManager.getImage("back.png");
	}

	@Override
	public String getHoverText() {
		return "Back";
	}

}
