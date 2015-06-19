package org.browserbot.ui;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.browserbot.script.Script;
import org.browserbot.script.ScriptClassLoader;
import org.browserbot.util.FileManager;

public class BrowserScriptSelector extends JFileChooser {

	private static final long serialVersionUID = 8882314008818717850L;
	
	public BrowserScriptSelector() {
		super(FileManager.COMPILED_DIR);
		setFileFilter(getScriptFileFilter());
	}
	
	private FileFilter getScriptFileFilter() {
		return new FileNameExtensionFilter("Scripts", new String[] {"class"});
	}

	public Script getSelectedScript() {
		if (showOpenDialog(null) == 0)
			return new ScriptClassLoader(getSelectedFile()).getScript();
		return null;
	}
}
