package fileClass;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

public class Bai7 {

	void copyAll(String sDir, String dDir, String... ext) throws IOException {

		File f = new File(sDir);
		File f2 = new File(dDir);
		if (!f2.exists())
			f2.mkdirs();
		if (!f.exists())
			return;
		if (f.isFile())
			Files.copy(Paths.get(f.getCanonicalPath()), Paths.get(dDir + "/" + f.getName()),
					StandardCopyOption.REPLACE_EXISTING);

		if (f.isDirectory()) {
			File[] content = f.listFiles();
			if (content != null)
				for (File f1 : content)
					copyAll(f1.getCanonicalPath(), dDir, ext);
		}

	}

}
