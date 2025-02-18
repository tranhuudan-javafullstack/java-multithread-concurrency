package fileClass;

import java.io.File;
import java.io.IOException;

public class Bai6 {
	boolean deleteAll(String path, String... ext) throws IOException {
		boolean rs = true;
		File f = new File(path);
		if (!f.exists())
			return true;
		if (f.isFile()) {
			if (Bai2.accept(f.getName(), ext))
				return f.delete();
		}
		if (f.isDirectory()) {
			File[] content = f.listFiles();
			if (content == null)
				return false;

			for (File f1 : content)
				rs &= deleteAll(f1.getCanonicalPath(), ext);
		}
		return rs;

	}

}
