package org.browserbot.script;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ScriptClassLoader extends ClassLoader {

	private String name;

	private byte[] bytes;

	public ScriptClassLoader(File classFile) {
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
