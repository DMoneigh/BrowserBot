package org.browserbot;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.browserbot.ui.BrowserWindow;
import org.browserbot.util.FileManager;

/**
 * Java Browser Automation Software.
 * 
 * @version 0.3
 *
 * @see <a href="http://www.browserbot.org">BrowserBot</a>
 * 
 * @author Desmond Jackson
 */
public class BrowserBot {
	
	public static final int MAJOR_VERSION = 0;

	public static final int MINOR_VERSION = 3;
	
	public static void main(String[] args) {
		FileManager.mkdirs();
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		new BrowserWindow().setVisible(true);
	}

}
