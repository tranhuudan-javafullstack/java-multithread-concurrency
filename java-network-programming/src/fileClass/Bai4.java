package fileClass;

import java.io.File;
import java.io.IOException;

public class Bai4 {
	void dirTree(String path, int n) throws IOException {

		File f = new File(path);
		if (!f.exists())
			return;
		if (f.isFile())
			System.out.println(indention(1, n * DEFAULT_TAB_SIZE) + "|-" + f.getName());
		if (f.isDirectory()) {
			File[] content = f.listFiles();
			System.out.println(indention(1, n++ * DEFAULT_TAB_SIZE) + "|+" + f.getName());
			if (content != null)
				for (File f1 : content) {
					dirTree(f1.getCanonicalPath(), n);
				}
		}

	}

	void dirTree(String path) throws IOException {
		dirTree(path, 0);
	}

	public static final int DEFAULT_TAB_SIZE = 5;

	public static String indention(int level, int tabSize) {
		StringBuilder indention = new StringBuilder();
		for (int i = 0; i < level * tabSize; i++) {
			indention.append(" ");
		}
		return indention.toString();
	}

	public static String indention(int level) {
		return indention(level, DEFAULT_TAB_SIZE);
	}
}
