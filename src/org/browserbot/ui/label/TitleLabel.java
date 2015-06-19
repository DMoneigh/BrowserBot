package org.browserbot.ui.label;

import java.awt.event.MouseEvent;

import org.browserbot.ui.BrowserLabel;
import org.browserbot.ui.BrowserTabComponent;

public class TitleLabel extends BrowserLabel {

	private static final long serialVersionUID = -7965756574305992562L;
	
	private BrowserTabComponent tabComponent;

	public TitleLabel(BrowserTabComponent tabComponent) {
		super("tab");
		this.tabComponent = tabComponent;
	}
	
	public void setToolandText(String text) {
		setText(text);
		setToolTipText(text);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		tabComponent.getTab().getTabPane().setSelectedComponent(tabComponent.getTab());
	}

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}

}
