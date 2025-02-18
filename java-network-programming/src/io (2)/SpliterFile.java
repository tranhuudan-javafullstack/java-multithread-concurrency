package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class SpliterFile {
	public static void slitFile(String path, long size) throws IOException {
		File fileSource = new File(path);
		if (!fileSource.exists())
			return;
		if (fileSource.isFile()) {
			FileInputStream fis = new FileInputStream(fileSource);
			long totalSize = fileSource.length();
			int countFile = (int) (totalSize / size);
			int remainder = (int) (totalSize % size);
			System.out.println(totalSize);
			System.out.println(countFile);
			System.out.println(remainder);
			File new_folder = new File(fileSource.getParent() + "\\slit");
			new_folder.mkdir();
			for (int i = 0; i < countFile; i++) {
				FileOutputStream fos = new FileOutputStream(fileSource.getParent() + "\\slit\\slit" + (i + 1));
				for (int j = 0; j < size; j++) {
					fos.write(fis.read());
				}
				fos.close();
			}
			if (remainder > 0) {
				FileOutputStream fos = new FileOutputStream(fileSource.getParent() + "\\slit\\slit_end");
				for (int i = 0; i < remainder; i++) {
					fos.write(fis.read());
				}
				fos.close();
			}

		}
	}

	public static void joinFile(String pathFolder, String ext) throws FileNotFoundException, IOException {
		FileInputStream fis;
		File folder = new File(pathFolder);
		if (!folder.exists())
			return;
		if (folder.isDirectory()) {
			File[] files = folder.listFiles();
			FileOutputStream fos = new FileOutputStream(folder.getCanonicalPath() + "\\join." + ext);
			for (int i = 0; i < files.length; i++) {
				if (i == files.length - 1) {
					fis = new FileInputStream(folder.getCanonicalPath() + "\\slit_end");

				} else {
					fis = new FileInputStream(folder.getAbsolutePath() + "\\slit" + (i + 1));
					System.out.println(folder.getAbsolutePath() + "\\slit" + (i + 1));
				}
				int byteRead;
				while ((byteRead = fis.read()) != -1) {
					fos.write(byteRead);
				}
				fis.close();

			}
			fos.close();
		}
	}

	public static void main(String[] args) throws IOException {
//	String path = "C:\\Users\\TIEN\\Documents\\Zalo Received Files\\2- Module 1 - IO.pdf";
//	slitFile(path, 1024 * 1000);
		String path = "C:\\Users\\TIEN\\Documents\\Zalo Received Files\\slit";
		joinFile(path, "pdf");
	}
}
