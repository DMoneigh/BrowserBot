package org.browserbot.bot.script;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.util.CheckClassAdapter;

/**
 * The script class loader.
 * 
 * @author Desmond Jackson
 */
public class ScriptClassLoader extends ClassLoader {
	
	/**
	 * The script class node.
	 */
	private ClassNode node = new ClassNode();
	
	/**
	 * Creates the script class loader.
	 * 
	 * @param classFile The class file to derive the script from
	 */
	public ScriptClassLoader(File classFile) {
		super();
		try {
			InputStream in = new FileInputStream(classFile);
			byte[] buffer = new byte[1024];
			int count = 0;
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			while ((count = in.read(buffer)) != -1)
				baos.write(buffer, 0, count);
			in.close();
			ClassReader reader = new ClassReader(baos.toByteArray());
			reader.accept(node, ClassReader.SKIP_DEBUG | ClassReader.SKIP_FRAMES);
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
		ClassWriter writer = new ClassWriter(ClassWriter.COMPUTE_MAXS);
		node.accept(new CheckClassAdapter(writer, true));
		byte[] bytes = writer.toByteArray();
		try {
			return defineClass(node.name, bytes, 0, bytes.length).asSubclass(Script.class).newInstance();
		} catch (InstantiationException | IllegalAccessException
				| ClassFormatError e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
