package org.browserbot.ui.button;

import java.awt.event.ActionEvent;

import javax.swing.Icon;

import org.browserbot.ui.BrowserButton;
import org.browserbot.ui.resource.ResourceManager;

/**
 * The new tab button.
 * 
 * @author Desmond Jackson
 */
public class NewTabButton extends BrowserButton {

	/**
	 * The serial uid.
	 */
	private static final long serialVersionUID = 8841430070337850004L;

	/**
	 * Creates the new tab button.
	 */
	public NewTabButton() {
		super(null);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		getTabPane().addTab();
	}
	
	@Override
	public Icon getIcon() {
		return ResourceManager.getImage("new-tab.png");
	}
	
	@Override
	public String getHoverText() {
		return "New tab";
	}

}
