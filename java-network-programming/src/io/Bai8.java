package io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Bai8 {
	static boolean fileCopy(String sFile, String destFile, boolean moved) throws IOException {
		File f = new File(sFile);
		if(!f.exists()) return false;
		if (f.exists() && f.isFile()) {
			InputStream is = new BufferedInputStream(new FileInputStream(f));
			OutputStream os = new BufferedOutputStream(new FileOutputStream(destFile));
			byte[] b = new byte[1024];
			while(is.read() != -1)
				os.write(b);
			is.close();
			os.close();
			if (moved)
				f.delete();
		}
		return true;

//		File f = new File(sFile);
//
//		if (!f.exists())
//			return false;
//		if (f.exists() && f.isFile()) {
//			InputStream is = new BufferedInputStream(new FileInputStream(f));
//			OutputStream os = new BufferedOutputStream(new FileOutputStream(destFile));
//			byte[] b = new byte[1024];
//			while (is.read(b) != -1)
//				os.write(b);
//
//			is.close();
//			os.close();
//			if (moved)
//				f.delete();
//
//		}
//
//		return true;
	}
}
