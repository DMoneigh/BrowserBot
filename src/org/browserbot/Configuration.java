package org.browserbot;

import java.io.File;

/**
 * The BrowserBot configuration class.
 * 
 * @author Desmond Jackson
 */
public class Configuration extends Object {

	/**
	 * The bot name.
	 */
	public static final String BOT_NAME = "BrowserBot";

	/**
	 * The bot major version.
	 */
	public static final int BOT_VERSION_MAJOR = 0;

	/**
	 * The bot minor version.
	 */
	public static final int BOT_VERSION_MINOR = 2;

	/**
	 * The bot user interface width.
	 */
	public static final int BOT_UI_WIDTH = 1024;

	/**
	 * The bot user interface height.
	 */
	public static final int BOT_UI_HEIGHT = 768;

	/**
	 * The bot storage directory.
	 */
	public static final String STORAGE_DIR = System.getProperty("user.home") + File.separator + BOT_NAME;

	/**
	 * The bot "Default" directory.
	 */
	public static final String DEFAULT_DIR = STORAGE_DIR + File.separator + "Default";

	/**
	 * The bot "Scripts" directory.
	 */
	public static final String SCRIPTS_DIR = STORAGE_DIR + File.separator + "Scripts";
	
	/**
	 * The bot "Compiled" directory.
	 */
	public static final String COMPILED_DIR = SCRIPTS_DIR + File.separator + "Compiled";
	
	/**
	 * The bot "Source" directory.
	 */
	public static final String SOURCE_DIR = SCRIPTS_DIR + File.separator + "Source";
	
	/**
	 * The bot home url.
	 */
	public static final String HOME_URL = "http://forums.browserbot.org";

	/**
	 * Creates all bot directories.
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
