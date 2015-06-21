package org.browserbot.ui;

import java.awt.Dimension;

import javax.swing.JPanel;

import org.browserbot.ui.button.CloseTabButton;
import org.browserbot.ui.label.TitleLabel;

/**
 * The browser tab component.
 * 
 * @author Desmond Jackson
 */
public class BrowserTabComponent extends JPanel {

	/**
	 * The serial uid.
	 */
	private static final long serialVersionUID = -8946031337634506161L;
	
	/**
	 * The browser tab.
	 */
	private BrowserTab tab;
	
	/**
	 * The title label.
	 */
	private TitleLabel titleLabel = new TitleLabel(this);
	
	/**
	 * The close tab button.
	 */
	private CloseTabButton closeTabButton = new CloseTabButton(this);
	
	/**
	 * Creates the browser tab component.
	 * 
	 * @param tab The browser tab
	 */
	public BrowserTabComponent(BrowserTab tab) {
		super();
		this.tab = tab;
		titleLabel.setPreferredSize(new Dimension(80, 20));
		add(titleLabel);
		add(closeTabButton);
	}
	
	/**
	 * Gets the tab component title label.
	 * 
	 * @return The tab component title label
	 */
	public TitleLabel getTitleLabel() {
		return titleLabel;
	}
	
	/**
	 * Gets the browser tab.
	 * 
	 * @return The browser tab
	 */
	public BrowserTab getTab() {
		return tab;
	}

}
