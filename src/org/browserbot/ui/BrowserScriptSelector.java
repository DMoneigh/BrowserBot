package org.browserbot.ui;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.browserbot.script.Script;
import org.browserbot.script.ScriptClassLoader;
import org.browserbot.util.FileManager;

/**
 * The browser script selector.
 * 
 * @author Desmond Jackson
 */
public class BrowserScriptSelector extends JFileChooser {

	/**
	 * The serial uid.
	 */
	private static final long serialVersionUID = 8882314008818717850L;
	
	/**
	 * Creates the browser script selector.
	 */
	public BrowserScriptSelector() {
		super(FileManager.COMPILED_DIR);
		setFileFilter(getScriptFileFilter());
	}
	
	/**
	 * Gets the script file filter.
	 * 
	 * @return The script file filter
	 */
	private FileFilter getScriptFileFilter() {
		return new FileNameExtensionFilter("Scripts", new String[] {"class"});
	}

	/**
	 * Gets the selected script.
	 * 
	 * @return The selected script
	 */
	public Script getSelectedScript() {
		if (showOpenDialog(null) == 0)
			return new ScriptClassLoader(getSelectedFile()).getScript();
		return null;
	}
}
