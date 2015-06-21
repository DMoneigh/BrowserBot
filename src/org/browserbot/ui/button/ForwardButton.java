package org.browserbot.ui.button;

import java.awt.event.ActionEvent;

import javax.swing.Icon;

import org.browserbot.ui.BrowserButton;
import org.browserbot.ui.resource.ResourceManager;

/**
 * The forward button.
 * 
 * @author Desmond Jackson
 */
public class ForwardButton extends BrowserButton {

	/**
	 * The serial uid.
	 */
	private static final long serialVersionUID = 4255131397124759082L;

	/**
	 * Creates the forward button.
	 */
	public ForwardButton() {
		super(null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		getToolBar().getTab().getDisplay().getBrowser().goForward();
	}

	@Override
	public Icon getIcon() {
		return ResourceManager.getImage("forward.png");
	}

	@Override
	public String getHoverText() {
		return "Forward";
	}

}
