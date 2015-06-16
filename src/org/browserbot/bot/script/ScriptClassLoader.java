package org.browserbot.bot.script;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * The script class loader.
 * 
 * @author Desmond Jackson
 */
public class ScriptClassLoader extends ClassLoader {
	
	/**
	 * The name of the script.
	 */
	private String name;
	
	/**
	 * The bytes of the script
	 */
	private byte[] bytes;
	
	/**
	 * Creates the script class loader.
	 * 
	 * @param classFile The class file to derive the script from
	 */
	public ScriptClassLoader(File classFile) {
		super();
		try {
			name = classFile.getName().split("\\.")[0];
			InputStream in = new FileInputStream(classFile);
			byte[] buffer = new byte[1024];
			int count = 0;
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			while ((count = in.read(buffer)) != -1)
				baos.write(buffer, 0, count);
			in.close();
			bytes = baos.toByteArray();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Gets the script that was loaded.
	 * 
	 * @return null if the script could not be loaded
	 */
	public Script getScript() {
		try {
			return defineClass(name, bytes, 0, bytes.length).asSubclass(Script.class).newInstance();
		} catch (InstantiationException | IllegalAccessException
				| ClassFormatError e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
