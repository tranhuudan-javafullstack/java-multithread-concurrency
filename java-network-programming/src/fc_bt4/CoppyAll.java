package fc_bt4;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class CoppyAll {
	public static void coppyAll(String sDir, String dDir, String... ext ) throws IOException {
		File sf = new File(sDir);
		File df = new File(dDir);
		if (!df.exists()) df.mkdir();
		if (!sf.exists()) return;
		if (sf.isFile()) {
			if (accept(sf.getName(), ext)) {
				Files.copy(Paths.get(sf.getCanonicalPath()), Paths.get(df.getCanonicalPath() + (String) File.separator + sf.getName()), StandardCopyOption.REPLACE_EXISTING);
				System.out.println("coppied");
			}
			
		}
		if (sf.isDirectory()) {
			File[] files = sf.listFiles();
			for (File file : files) {
				coppyAll(file.getCanonicalPath(), dDir, ext);
			}
		}
	}

	private static boolean accept(String name, String[] ext) {
		for (String e : ext) {
			if (name.endsWith(e)) return true;
		}
		return false;
	}
	public static void main(String[] args) throws IOException {
		String sDir = "C:\\Users\\TIEN\\Documents\\Zalo Received Files";
		String dDir = "C:\\Users\\TIEN\\Documents\\Zalo Received Files\\dDir";
		String[] exts = new String[] {"doc"};
		coppyAll(sDir, dDir, exts);
	}

}
