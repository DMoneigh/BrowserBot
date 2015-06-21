package org.browserbot.ui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

import org.browserbot.ui.button.BackButton;
import org.browserbot.ui.button.ForwardButton;
import org.browserbot.ui.button.RefreshButton;
import org.browserbot.ui.button.StopButton;
import org.browserbot.ui.textfield.AddressBarTextField;

import com.teamdev.jxbrowser.chromium.Browser;

/**
 * The browser tool bar.
 * 
 * @author Desmond Jackson
 */
public class BrowserToolBar extends JPanel {

	/**
	 * The serial uid.
	 */
	private static final long serialVersionUID = -141313182399975395L;
	
	/**
	 * The back button.
	 */
	private BackButton backButton = new BackButton();
	
	/**
	 * The forward button.
	 */
	private ForwardButton forwardButton = new ForwardButton();
	
	/**
	 * The stop button.
	 */
	private StopButton stopButton = new StopButton();
	
	/**
	 * The address bar.
	 */
	private AddressBarTextField addressBar = new AddressBarTextField();
	
	/**
	 * Creates the browser tool bar.
	 */
	public BrowserToolBar() {
		super(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridy = 1;
		add(backButton, gbc);
		add(forwardButton, gbc);
		add(new RefreshButton(), gbc);
		add(stopButton, gbc);
		gbc.weightx = 1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		add(addressBar, gbc);
	}
	
	/**
	 * Toggles the navigation buttons.
	 */
	public void toggleNavigationButtons() {
		Browser browser = getTab().getDisplay().getBrowser();
		backButton.setEnabled(browser.canGoBack());
		forwardButton.setEnabled(browser.canGoForward());
	}
	
	/**
	 * Gets the address bar.
	 * 
	 * @return The address bar
	 */
	public AddressBarTextField getAddressBar() {
		return addressBar;
	}
	
	/**
	 * Gets the stop button.
	 * 
	 * @return The stop button
	 */
	public StopButton getStopButton() {
		return stopButton;
	}
	
	/**
	 * Gets the forward button.
	 * 
	 * @return The forward button
	 */
	public ForwardButton getForwardButton() {
		return forwardButton;
	}
	
	/**
	 * Gets the back button.
	 * 
	 * @return The back button
	 */
	public BackButton getBackButton() {
		return backButton;
	}
	
	/**
	 * Gets the browser tab.
	 * 
	 * @return The browser tab
	 */
	public BrowserTab getTab() {
		return (BrowserTab) getParent();
	}

}
