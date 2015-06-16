package org.browserbot;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.browserbot.bot.Bot;

/**
 * Java Browser Automation Software.
 * 
 * @author Desmond Jackson
 * 
 * @version 0.1
 * 
 * @see <a href="http://www.browserbot.org">BrowserBot</a>
 */
public class BrowserBot extends Object {
	
	/**
	 * The main method.
	 * 
	 * @param args String arguments
	 */
	public static void main(String[] args) {
		Configuration.mkdirs();
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		new Bot();
	}

}
