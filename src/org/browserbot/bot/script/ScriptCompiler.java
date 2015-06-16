package org.browserbot.bot.script;

import java.io.File;

import javax.swing.JOptionPane;
import javax.tools.ToolProvider;

import org.browserbot.Configuration;

/**
 * The script compiler.
 * 
 * @author Desmond Jackson
 */
public class ScriptCompiler extends Object {

	/**
	 * Compiles all source script files.
	 */
	public static void compile() {
		int count = 0;
		for (File file : new File(Configuration.SOURCE_DIR).listFiles()) {
			String name = file.getName();
			if (name.endsWith(".java")) {
				if (ToolProvider.getSystemJavaCompiler().run(null, null, null, file.getAbsolutePath()) == 0) {
					File compiled = new File(file.getAbsolutePath().toString().replace(".java", ".class"));
					compiled.renameTo(new File(Configuration.COMPILED_DIR + "/" + compiled.getName()));
					count++;
				}
			}
		}
		JOptionPane.showMessageDialog(null, count + " scripts compiled!");
	}

}
