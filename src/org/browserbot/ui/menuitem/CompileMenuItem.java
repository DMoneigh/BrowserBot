package org.browserbot.ui.menuitem;

import java.awt.event.ActionEvent;

import org.browserbot.script.ScriptCompiler;
import org.browserbot.ui.BrowserMenuItem;

/**
 * The "Compile" menu item.
 * 
 * @author Desmond Jackson
 */
public class CompileMenuItem extends BrowserMenuItem {

	/**
	 * The serial uid.
	 */
	private static final long serialVersionUID = 8720527169823507800L;

	/**
	 * Creates the "Compile" menu item.
	 */
	public CompileMenuItem() {
		super("Compile");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ScriptCompiler.compileScripts();
	}

}
