package org.browserbot.bot.ui;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.browserbot.Configuration;
import org.browserbot.bot.script.Script;
import org.browserbot.bot.script.ScriptClassLoader;

/**
 * The bot script selector.
 * 
 * @author Desmond Jackson
 */
public class BotScriptSelector extends JFileChooser {

	/**
	 * The serial uid.
	 */
	private static final long serialVersionUID = -4767411334016710087L;

	/**
	 * The bot menu bar.
	 */
	private BotMenuBar menuBar;

	/**
	 * The bot tool bar.
	 */
	private BotToolBar toolBar;

	/**
	 * Creates the bot script selector.
	 * 
	 * @param menuBar The bot menu bar
	 */
	public BotScriptSelector(BotMenuBar menuBar) {
		super(Configuration.COMPILED_DIR);
		this.menuBar = menuBar;
		setFileFilter(getScriptFileFilter());
	}

	/**
	 * Creates the bot script selector.
	 * 
	 * @param toolBar The bot tool bar
	 */
	public BotScriptSelector(BotToolBar toolBar) {
		super(Configuration.COMPILED_DIR);
		this.toolBar = toolBar;
		setFileFilter(getScriptFileFilter());
	}

	/**
	 * Gets the selected script.
	 * 
	 * @return The selected script
	 */
	public Script getSelectedScript() {
		if (showOpenDialog(menuBar != null ? menuBar : toolBar) == 0)
			return new ScriptClassLoader(getSelectedFile()).getScript();
		return null;
	}

	/**
	 * Gets the script file filter.
	 * 
	 * @return The script file filter
	 */
	private FileFilter getScriptFileFilter() {
		return new FileNameExtensionFilter("Scripts", new String[] {"class"});
	}

}
