package org.browserbot.ui.resource;

import javax.swing.ImageIcon;

/**
 * The resource manager.
 * 
 * @author Desmond Jackson
 */
public class ResourceManager {
	
	public static ImageIcon getImage(String fileName) {
		return new ImageIcon(ResourceManager.class.getResource(fileName));
	}

}
