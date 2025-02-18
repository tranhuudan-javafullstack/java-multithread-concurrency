package fileClass;

import java.io.File;
import java.io.IOException;
import java.util.regex.Pattern;

public class Bai3 {
	void findAll(String path, String pattern) throws IOException {

		File f = new File(path);
		if (!f.exists())
			return;
		if (f.isFile() && Pattern.compile(pattern).matcher(f.getName()).matches())
			System.out.println(f);
		if (f.isDirectory()) {
			File[] content = f.listFiles();
			if (content != null)
				for (File f1 : content)
					findAll(f1.getCanonicalPath(), pattern);
		}

	}

}
