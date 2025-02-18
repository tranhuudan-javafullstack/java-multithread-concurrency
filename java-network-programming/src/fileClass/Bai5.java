
package fileClass;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Bai5 {
	void dirStat(String path, int n) throws IOException {

		File f = new File(path);
		if (!f.exists())
			return;
		if (f.isFile())
			System.out.println(indention(1, n * DEFAULT_TAB_SIZE) + "|-" + f.getName() + " (" + f.length() + ")");
		if (f.isDirectory()) {
			File[] content = f.listFiles();
			System.out.println(indention(1, n++ * DEFAULT_TAB_SIZE) + "|+" + f.getName() + " (" + sum(f) + ")");
			if (content != null)
				for (File f1 : content)

					dirStat(f1.getCanonicalPath(), n);
		}

	}

	Long sum(File f) {
		return sum(f, 0L);
	}

	Long sum(File f, Long sum) {
		File[] fs = f.listFiles();

		for (int i = 0; i < fs.length; i++) {
			if (fs[i].isFile())

				sum += fs[i].length();
			else if (fs[i].isDirectory()) {
				if (fs[i].getParentFile().isDirectory())
					sum = sum(fs[i], sum);

			}
		}

		return sum;
	}

	void dirTree(String path) throws IOException {
		dirStat(path, 0);
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
