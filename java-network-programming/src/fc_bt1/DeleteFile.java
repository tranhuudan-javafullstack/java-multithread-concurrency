package fc_bt1;

import java.io.File;

public class DeleteFile {
	static public boolean delete(String path) {
		File file = new File(path);
		if (!file.exists())
			return true;
		if (file.isDirectory()) {
			File[] files = file.listFiles();
			for (File f : files) {
				return delete(f.getAbsolutePath());
			}
		}
		if (file.isFile())
			return file.delete();
		return false;
	}

	public static void main(String[] args) {
		String path = "C:\\Users\\TIEN\\Documents\\Zalo Received Files\\test";
		System.out.println(delete(path));
	}
}
