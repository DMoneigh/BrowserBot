package org.browserbot.bot.ui;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.browserbot.Configuration;
import org.browserbot.bot.script.Script;
import org.browserbot.bot.ui.resource.ResourceManager;

import com.teamdev.jxbrowser.chromium.Browser;

/**
 * The bot tool bar.
 * 
 * @author Desmond Jackson
 */
public class BotToolBar extends JPanel implements ActionListener {

	/**
	 * The serial uid.
	 */
	private static final long serialVersionUID = 1044552671363491232L;

	/**
	 * The bot tab.
	 */
	private BotTab tab;

	/**
	 * The back button.
	 */
	private JButton backButton = new JButton();

	/**
	 * The forward button.
	 */
	private JButton forwardButton = new JButton();

	/**
	 * The refresh button.
	 */
	private JButton refreshButton = new JButton();

	/**
	 * The stop button.
	 */
	private JButton stopButton = new JButton();

	/**
	 * The address bar.
	 */
	private JTextField addressBar = new JTextField();

	/**
	 * The start script button.
	 */
	private JButton startScriptButton = new JButton();

	/**
	 * The stop script button.
	 */
	private JButton stopScriptButton = new JButton();

	/**
	 * Creates the bot tool bar.
	 * 
	 * @param tab The bot tab
	 */
	public BotToolBar(BotTab tab) {
		super();
		this.tab = tab;

		setPreferredSize(new Dimension(Configuration.BOT_UI_WIDTH, 30));

		backButton.setIcon(ResourceManager.getIcon("back.png"));
		backButton.setToolTipText("Back");
		makeSmall(backButton);
		add(backButton);
		backButton.addActionListener(this);

		forwardButton.setIcon(ResourceManager.getIcon("forward.png"));
		forwardButton.setToolTipText("Forward");
		makeSmall(forwardButton);
		add(forwardButton);
		forwardButton.addActionListener(this);

		refreshButton.setIcon(ResourceManager.getIcon("refresh.png"));
		refreshButton.setToolTipText("Refresh");
		makeSmall(refreshButton);
		add(refreshButton);
		refreshButton.addActionListener(this);

		stopButton.setIcon(ResourceManager.getIcon("stop.png"));
		stopButton.setToolTipText("Stop");
		makeSmall(stopButton);
		add(stopButton);
		stopButton.addActionListener(this);

		addressBar.setPreferredSize(new Dimension(850, 27));
		add(addressBar);
		addressBar.addActionListener(this);

		startScriptButton.setIcon(ResourceManager.getIcon("start-script.png"));
		startScriptButton.setToolTipText("Start Script");
		makeSmall(startScriptButton);
		add(startScriptButton);
		startScriptButton.addActionListener(this);

		stopScriptButton.setIcon(ResourceManager.getIcon("stop-script.png"));
		stopScriptButton.setToolTipText("Stop Script");
		makeSmall(stopScriptButton);
		add(stopScriptButton);
		stopScriptButton.addActionListener(this);
	}

	/**
	 * Makes a component small.
	 * 
	 * @param component The component to make small
	 */
	private void makeSmall(Component component) {
		component.setPreferredSize(new Dimension(20, 20));
	}

	/**
	 * Sets the stop button enabled state.
	 * 
	 * @param bool The enabled state to set
	 */
	public void setStopButtonEnabled(boolean bool) {
		stopButton.setEnabled(bool);
	}

	/**
	 * Sets the address bar text.
	 * 
	 * @param text The text to set
	 */
	public void setAddressBarText(String text) {
		addressBar.setText(text);
	}

	/**
	 * Gets the bot tab.
	 * 
	 * @return The bot tab
	 */
	public BotTab getTab() {
		return tab;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		Browser browser = tab.getView().getBrowser();
		if (source.equals(backButton)) {
			if (browser.canGoBack())
				browser.goBack();
		} else if (source.equals(forwardButton)) {
			if (browser.canGoForward())
				browser.goForward();
		} else if (source.equals(refreshButton))
			browser.reload();
		else if (source.equals(stopButton)) {
			browser.stop();
			stopButton.setEnabled(false);
		} else if (source.equals(addressBar))
			browser.loadURL(addressBar.getText());
		else if (source.equals(startScriptButton)) {
			Script script = new BotScriptSelector(this).getSelectedScript();
			if (script != null)
				tab.startScript(script);
		} else if (source.equals(stopScriptButton))
			tab.stopScript();
	}


}
