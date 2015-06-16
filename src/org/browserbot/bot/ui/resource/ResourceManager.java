package org.browserbot.bot.ui.resource;

import javax.swing.ImageIcon;

/**
 * Manages the resources of the user interface.
 * 
 * @author Desmond Jackson
 */
public class ResourceManager extends Object {
	
	/**
	 * Gets an image icon by file name.
	 * 
	 * @param fileName The name of the image icon file
	 * 
	 * @return An image icon by file name
	 */
	public static ImageIcon getIcon(String fileName) {
		return new ImageIcon(ResourceManager.class.getResource(fileName));
	}

}
