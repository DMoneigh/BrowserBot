package org.browserbot.ui;

import java.awt.Dimension;

import javax.swing.JPanel;

import org.browserbot.ui.button.CloseTabButton;
import org.browserbot.ui.label.TitleLabel;

public class BrowserTabComponent extends JPanel {

	private static final long serialVersionUID = -8946031337634506161L;
	
	private BrowserTab tab;
	
	private TitleLabel titleLabel = new TitleLabel(this);
	
	private CloseTabButton closeTabButton = new CloseTabButton(this);
	
	public BrowserTabComponent(BrowserTab tab) {
		this.tab = tab;
		titleLabel.setPreferredSize(new Dimension(80, 20));
		add(titleLabel);
		add(closeTabButton);
	}
	
	public TitleLabel getTitleLabel() {
		return titleLabel;
	}
	
	public BrowserTab getTab() {
		return tab;
	}

}
