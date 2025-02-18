package exr1_delete;

import java.io.File;

public class FileOperation {
	static public boolean remove(String path) {
		File file = new File(path);
		if (!file.exists())
			return true;

		File[] list = file.listFiles();
		if (list != null)
			for (File f : list)
				remove(f.getAbsolutePath());

		return file.delete();
	}

	public static void main(String[] args) {
		String path = "D:\\TEMP\\LTM\\test";
		System.out.println(remove(path));

	}

}
