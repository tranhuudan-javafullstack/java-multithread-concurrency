package io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Bai10 {

	void FileSpliter(String path, long files) throws IOException {
		String name;

		InputStream is = new BufferedInputStream(new FileInputStream(path));
		boolean read = true;
		int count = 0;
		while (read) {

			name = path + ext(count);

			OutputStream os = new BufferedOutputStream(new FileOutputStream(name));
			read = copyFrom(is, os, files);
			count++;
			os.close();
		}
		is.close();

	}

	private String ext(int count) {
		// TODO Auto-generated method stub

		if (count < 10)
			return ".00" + count;
		else if (count < 100)
			return ".0" + count;
		else if (count < 1000)
			return "." + count;

		return null;
	}

	private static boolean copyFrom(InputStream is, OutputStream os, long pSize) throws IOException {

		byte[] data = new byte[102400];
		int byteRead;
		long remain = pSize;
		int mustRead;
		while (remain > 0) {
			mustRead = data.length < remain ? data.length : (int) remain;
			byteRead = is.read(data, 0, mustRead);
			if (byteRead == -1)
				return false;
			os.write(data, 0, byteRead);
			remain -= byteRead;

		}
		return true;

	}

	void FileJoiner(String path) throws IOException {

		String dest = path.substring(0, path.length() - 4);

		OutputStream os = new BufferedOutputStream(new FileOutputStream(dest));

		int count = 1;
		InputStream is;
		File f;
		while (true) {

			path = dest + ext(count);

			f = new File(path);

			if (!f.exists())
				break;
			is = new BufferedInputStream(new FileInputStream(path));

			copyFrom(is, os, f.length());
			count++;

			is.close();

		}

		os.close();
	}
}
