package org.browserbot.ui.button;

import java.awt.event.ActionEvent;

import javax.swing.Icon;

import org.browserbot.ui.BrowserButton;
import org.browserbot.ui.BrowserTabComponent;
import org.browserbot.ui.resource.ResourceManager;

/**
 * The close tab button.
 * 
 * @author Desmond Jackson
 */
public class CloseTabButton extends BrowserButton {

	/**
	 * The serial uid.
	 */
	private static final long serialVersionUID = -2844672938766698342L;
	
	/**
	 * The browser tab component.
	 */
	private BrowserTabComponent tabComponent;

	/**
	 * Creates the close tab button.
	 * 
	 * @param tabComponent The browser tab component
	 */
	public CloseTabButton(BrowserTabComponent tabComponent) {
		super(null);
		this.tabComponent = tabComponent;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		getTabPane().removeTab(tabComponent.getTab());
	}
	
	@Override
	public Icon getIcon() {
		return ResourceManager.getImage("close-tab.png");
	}
	
	@Override
	public String getHoverText() {
		return "Close Tab";
	}

}
