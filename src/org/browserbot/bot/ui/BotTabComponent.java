package org.browserbot.bot.ui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.browserbot.bot.ui.resource.ResourceManager;

/**
 * The bot tab component.
 * 
 * @author Desmond Jackson
 */
public class BotTabComponent extends JPanel implements ActionListener, MouseListener {

	/**
	 * The serial uid.
	 */
	private static final long serialVersionUID = -4310926145416552262L;

	/**
	 * The bot tab.
	 */
	private BotTab tab;

	/**
	 * The title label.
	 */
	private JLabel titleLabel = new JLabel("tab");

	/**
	 * The close button.
	 */
	private JButton closeButton = new JButton();

	/**
	 * The new tab button.
	 */
	private JButton newTabButton = new JButton();

	/**
	 * Creates the bot tab component.
	 * 
	 * @param tab The bot tab
	 */
	public BotTabComponent(BotTab tab) {
		super();
		this.tab = tab;
		setPreferredSize(new Dimension(150, 25));
		
		titleLabel.setPreferredSize(new Dimension(80, 20));
		add(titleLabel);
		titleLabel.addMouseListener(this);
		
		closeButton.setIcon(ResourceManager.getIcon("close.png"));
		closeButton.setToolTipText("Close Tab");
		closeButton.setPreferredSize(new Dimension(20, 20));
		add(closeButton);
		closeButton.addActionListener(this);
		
		newTabButton.setIcon(ResourceManager.getIcon("new-tab.png"));
		newTabButton.setToolTipText("New tab");
		newTabButton.setPreferredSize(new Dimension(20, 20));
		add(newTabButton);
		newTabButton.addActionListener(this);
	}
	
	/**
	 * Sets the title label text.
	 * 
	 * @param text The text to set
	 */
	public void setTitleLabelText(String text) {
		titleLabel.setText(text);
		titleLabel.setToolTipText(text);
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
		if (e.getSource().equals(closeButton))
			tab.getTabPane().removeTab(tab);
		else
			tab.getTabPane().addTab();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		tab.getTabPane().setSelectedComponent(tab);
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
