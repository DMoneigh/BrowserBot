package org.browserbot.ui.menuitem;

import java.awt.event.ActionEvent;

import org.browserbot.script.ScriptCompiler;
import org.browserbot.ui.BrowserMenuItem;

public class CompileMenuItem extends BrowserMenuItem {

	private static final long serialVersionUID = 8720527169823507800L;

	public CompileMenuItem() {
		super("Compile");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ScriptCompiler.compileScripts();
	}

}
