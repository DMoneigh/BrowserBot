package org.browserbot.ui.label;

import java.awt.event.MouseEvent;

import org.browserbot.ui.BrowserLabel;
import org.browserbot.ui.BrowserTabComponent;

/**
 * The title label.
 * 
 * @author Desmond Jackson
 */
public class TitleLabel extends BrowserLabel {

	/**
	 * The serial uid.
	 */
	private static final long serialVersionUID = -7965756574305992562L;
	
	/**
	 * The browser tab component.
	 */
	private BrowserTabComponent tabComponent;

	/**
	 * Creates the title label.
	 * 
	 * @param tabComponent The browser tab component
	 */
	public TitleLabel(BrowserTabComponent tabComponent) {
		super("tab");
		this.tabComponent = tabComponent;
	}
	
	/**
	 * Sets the title label tool and label text.
	 * 
	 * @param text The text to set
	 */
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
