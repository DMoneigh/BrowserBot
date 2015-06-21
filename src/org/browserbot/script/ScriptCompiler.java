package org.browserbot.script;

import java.io.File;

import javax.swing.JOptionPane;
import javax.tools.ToolProvider;

import org.browserbot.util.FileManager;

/**
 * The script compiler.
 * 
 * @author Desmond Jackson
 */
public class ScriptCompiler extends Object {
	
	/**
	 * Attempts to compile all scripts in the "Source" directory.
	 */
	public static void compileScripts() {
		int count = 0;
		for (File file : new File(FileManager.SOURCE_DIR).listFiles()) {
			String name = file.getName();
			System.out.println(name);
			if (name.endsWith(".java")) {
				if (ToolProvider.getSystemJavaCompiler().run(null, null, null, file.getAbsolutePath()) == 0) {
					File compiled = new File(file.getAbsolutePath().toString().replace(".java", ".class"));
					compiled.renameTo(new File(FileManager.COMPILED_DIR + File.separator + compiled.getName()));
					count++;
				}
			}
		}
		JOptionPane.showMessageDialog(null, count + " scripts compiled!");
	}

}
