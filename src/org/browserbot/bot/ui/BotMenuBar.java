package org.browserbot.bot.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import org.browserbot.Configuration;
import org.browserbot.bot.Bot;
import org.browserbot.bot.script.Script;
import org.browserbot.bot.script.ScriptCompiler;

import com.teamdev.jxbrowser.chromium.Browser;
import com.teamdev.jxbrowser.chromium.EditorCommand;

/**
 * The bot menu bar.
 * 
 * @author Desmond Jackson
 */
public class BotMenuBar extends JMenuBar implements ActionListener {

	/**
	 * The serial uid.
	 */
	private static final long serialVersionUID = -5966924833651576206L;

	/**
	 * The bot window.
	 */
	private BotWindow window;

	/**
	 * The "File" menu.
	 */
	private JMenu fileMenu = new JMenu("File");

	/**
	 * The "New tab" menu item.
	 */
	private JMenuItem newTabMenuItem = new JMenuItem("New tab");

	/**
	 * The "New window" menu item.
	 */
	private JMenuItem newWindowMenuItem = new JMenuItem("New window");

	/**
	 * The "Close Window" menu item.
	 */
	private JMenuItem closeWindowMenuItem = new JMenuItem("Close Window");

	/**
	 * The "Close Tab" menu item.
	 */
	private JMenuItem closeTabMenuItem = new JMenuItem("Close Tab");

	/**
	 * The "Edit" menu.
	 */
	private JMenu editMenu = new JMenu("Edit");

	/**
	 * The "Cut" menu item.
	 */
	private JMenuItem cutMenuItem = new JMenuItem("Cut");

	/**
	 * The "Copy" menu item.
	 */
	private JMenuItem copyMenuItem = new JMenuItem("Copy");

	/**
	 * The "Paste" menu item.
	 */
	private JMenuItem pasteMenuItem = new JMenuItem("Paste");

	/**
	 * The "View" menu.
	 */
	private JMenu viewMenu = new JMenu("View");

	/**
	 * The "Stop" menu item.
	 */
	private JMenuItem stopMenuItem = new JMenuItem("Stop");

	/**
	 * The "Reload This Page.." menu item.
	 */
	private JMenuItem reloadMenuItem = new JMenuItem("Reload This Page..");

	/**
	 * The "Actual Size" menu item.
	 */
	private JMenuItem actualSizeMenuItem = new JMenuItem("Actual Size");

	/**
	 * The "Zoom In" menu item.
	 */
	private JMenuItem zoomInMenuItem = new JMenuItem("Zoom In");

	/**
	 * The "Zoom Out" menu item.
	 */
	private JMenuItem zoomOutMenuItem = new JMenuItem("Zoom Out");

	/**
	 * The "History" menu.
	 */
	private JMenu historyMenu = new JMenu("History");

	/**
	 * The "Home" menu item.
	 */
	private JMenuItem homeMenuItem = new JMenuItem("Home");

	/**
	 * The "Back" menu item.
	 */
	private JMenuItem backMenuItem = new JMenuItem("Back");

	/**
	 * The "Forward" menu item.
	 */
	private JMenuItem forwardMenuItem = new JMenuItem("Forward");

	/**
	 * The "Script" menu.
	 */
	private JMenu scriptMenu = new JMenu("Script");
	
	/**
	 * The "Compile Scripts" menu item.
	 */
	private JMenuItem compileScriptsMenuItem = new JMenuItem("Compile Scripts");

	/**
	 * The "Start Script" menu item.
	 */
	private JMenuItem startScriptMenuItem = new JMenuItem("Start Script");

	/**
	 * The "Stop Script" menu item.
	 */
	private JMenuItem stopScriptMenuItem = new JMenuItem("Stop Script");

	/**
	 * Creates the bot menu bar.
	 * 
	 * @param window The bot window
	 */
	public BotMenuBar(BotWindow window) {
		super();
		this.window = window;

		fileMenu.add(newTabMenuItem);
		newTabMenuItem.addActionListener(this);
		fileMenu.add(newWindowMenuItem);
		newWindowMenuItem.addActionListener(this);
		fileMenu.add(closeWindowMenuItem);
		closeWindowMenuItem.addActionListener(this);
		fileMenu.add(closeTabMenuItem);
		closeTabMenuItem.addActionListener(this);
		add(fileMenu);

		editMenu.add(cutMenuItem);
		cutMenuItem.addActionListener(this);
		editMenu.add(copyMenuItem);
		copyMenuItem.addActionListener(this);
		editMenu.add(pasteMenuItem);
		pasteMenuItem.addActionListener(this);
		add(editMenu);

		viewMenu.add(stopMenuItem);
		stopMenuItem.addActionListener(this);
		viewMenu.add(reloadMenuItem);
		reloadMenuItem.addActionListener(this);
		viewMenu.add(actualSizeMenuItem);
		actualSizeMenuItem.addActionListener(this);
		viewMenu.add(zoomInMenuItem);
		zoomInMenuItem.addActionListener(this);
		viewMenu.add(zoomOutMenuItem);
		zoomOutMenuItem.addActionListener(this);
		add(viewMenu);

		historyMenu.add(homeMenuItem);
		homeMenuItem.addActionListener(this);
		historyMenu.add(backMenuItem);
		backMenuItem.addActionListener(this);
		historyMenu.add(forwardMenuItem);
		forwardMenuItem.addActionListener(this);
		add(historyMenu);

		scriptMenu.add(compileScriptsMenuItem);
		compileScriptsMenuItem.addActionListener(this);
		scriptMenu.add(startScriptMenuItem);
		startScriptMenuItem.addActionListener(this);
		scriptMenu.add(stopScriptMenuItem);
		stopScriptMenuItem.addActionListener(this);
		add(scriptMenu);
	}

	/**
	 * Gets the bot window.
	 * 
	 * @return The bot window
	 */
	public BotWindow getWindow() {
		return window;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		BotTabPane tabPane = window.getTabPane();
		BotTab tab = (BotTab) tabPane.getSelectedComponent();
		Browser browser = tab.getView().getBrowser();
		if (source.equals(newTabMenuItem))
			tabPane.addTab();
		else if (source.equals(newWindowMenuItem))
			new Bot();
		else if (source.equals(closeWindowMenuItem))
			tabPane.getWindow().dispose();
		else if (source.equals(closeTabMenuItem))
			tabPane.removeTab(tab);
		else if (source.equals(cutMenuItem))
			browser.executeCommand(EditorCommand.CUT);
		else if (source.equals(copyMenuItem))
			browser.executeCommand(EditorCommand.COPY);
		else if(source.equals(pasteMenuItem))
			browser.executeCommand(EditorCommand.PASTE);
		else if (source.equals(stopMenuItem))
			browser.stop();
		else if (source.equals(reloadMenuItem))
			browser.reload();
		else if (source.equals(actualSizeMenuItem))
			browser.zoomReset();
		else if (source.equals(zoomInMenuItem))
			browser.zoomIn();
		else if (source.equals(zoomOutMenuItem))
			browser.zoomOut();
		else if (source.equals(homeMenuItem))
			browser.loadURL(Configuration.HOME_URL);
		else if (source.equals(backMenuItem)) {
			if (browser.canGoBack())
				browser.goBack();
		} else if (source.equals(forwardMenuItem)) {
			if (browser.canGoForward())
				browser.goForward();
		} else if (source.equals(compileScriptsMenuItem))
			ScriptCompiler.compile();
		else if (source.equals(startScriptMenuItem)) {
			Script script = new BotScriptSelector(this).getSelectedScript();
			if (script != null)
				tab.startScript(script);
		} else if (source.equals(stopScriptMenuItem))
			tab.stopScript();
	}

}
