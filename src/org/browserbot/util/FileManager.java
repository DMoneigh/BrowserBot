package org.browserbot.util;

import java.io.File;

/**
 * The file manager.
 * 
 * @author Desmond Jackson
 */
public class FileManager extends Object {

	/**
	 * The "BrowserBot" directory.
	 */
	public static final String STORAGE_DIR = System.getProperty("user.home") + File.separator + "BrowserBot";

	/**
	 * The "BrowserBot/Default" directory.
	 */
	public static final String DEFAULT_DIR = STORAGE_DIR + File.separator + "Default";
	
	/**
	 * The "BrowserBot/Scripts" directory.
	 */
	public static final String SCRIPTS_DIR = STORAGE_DIR + File.separator + "Scripts";
	
	/**
	 * The "BrowserBot/Compiled" directory.
	 */
	public static final String COMPILED_DIR = SCRIPTS_DIR + File.separator + "Compiled";
	
	/**
	 * The "BrowserBot/Source" directory.
	 */
	public static final String SOURCE_DIR = SCRIPTS_DIR + File.separator + "Source";
	
	/**
	 * Creates all directories.
	 */
	public static void mkdirs() {
		for (String directory : new String[] {STORAGE_DIR, DEFAULT_DIR, SCRIPTS_DIR, COMPILED_DIR,
				SOURCE_DIR}) {
			File file = new File(directory);
			if (!file.exists())
				file.mkdirs();
		}
	}
	

}
