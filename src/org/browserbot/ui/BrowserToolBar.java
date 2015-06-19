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

public class BrowserToolBar extends JPanel {

	private static final long serialVersionUID = -141313182399975395L;
	
	private BackButton backButton = new BackButton();
	
	private ForwardButton forwardButton = new ForwardButton();
	
	private StopButton stopButton = new StopButton();
	
	private AddressBarTextField addressBar = new AddressBarTextField();
	
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
	
	public void toggleNavigationButtons() {
		Browser browser = getTab().getDisplay().getBrowser();
		backButton.setEnabled(browser.canGoBack());
		forwardButton.setEnabled(browser.canGoForward());
	}
	
	public AddressBarTextField getAddressBar() {
		return addressBar;
	}
	
	public StopButton getStopButton() {
		return stopButton;
	}
	
	public ForwardButton getForwardButton() {
		return forwardButton;
	}
	
	public BackButton getBackButton() {
		return backButton;
	}
	
	public BrowserTab getTab() {
		return (BrowserTab) getParent();
	}

}
