package org.browserbot.ui.resource;

import javax.swing.ImageIcon;

/**
 * The resource manager.
 * 
 * @author Desmond Jackson
 */
public class ResourceManager extends Object {
	
	/**
	 * Gets an image by file name.
	 * 
	 * @param fileName The file name of the image
	 * 
	 * @return An image by file name
	 */
	public static ImageIcon getImage(String fileName) {
		return new ImageIcon(ResourceManager.class.getResource(fileName));
	}

}
