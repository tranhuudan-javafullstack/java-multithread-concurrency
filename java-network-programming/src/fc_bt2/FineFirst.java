package fc_bt2;

import java.io.File;

public class FineFirst {
	static public boolean findFirst(String path, String pattern) {
		File f = new File(path);
		if (!f.exists())
			return false;
		if (f.isFile()) {
			System.out.println(f.getName());
			return f.getName().contains(pattern);
		}
		if (f.isDirectory()) {
			File[] files = f.listFiles();
			for (File file : files) {
				return findFirst(file.getAbsolutePath(), pattern);
			}
		}

		return false;
	}

	public static void main(String[] args) {
		String path = "C:\\Users\\TIEN\\Documents\\Zalo Received Files\\test";
		String pattern = "pdf";
		System.out.println(findFirst(path, pattern));
	}
}
