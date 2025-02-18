package io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Bai9 {

	boolean folderCopy(String sFolder, String destFolder, boolean moved) throws IOException {
		File f = new File(sFolder);
		File f1 = new File(destFolder);
		if (!f1.exists())
			f1.mkdirs();
		if (!f.exists())
			return true;
		if (f.isFile()) {
			byte[] b = new byte[1024];
			
		}
		
		return true;

//		File f = new File(sFolder);
//		File f1 = new File(destFolder);
//
//		if (!f1.exists())
//			f1.mkdirs();
//		if (!f.exists())
//			return true;
//
//		if (f.isFile()) {
//			byte[] b = new byte[1024];
//			File dest = new File(destFolder + "/" + f.getName());
//
//			InputStream is = new BufferedInputStream(new FileInputStream(f));
//			OutputStream os = new BufferedOutputStream(new FileOutputStream(dest));
//			while (is.read(b) != -1)
//				os.write(b);
//
//			is.close();
//			os.close();
//
//			if (moved)
//				f.delete();
//
//		}
//		if (f.isDirectory()) {
//			File fn = new File(destFolder + "/" + f.getName());
//			if (!fn.exists()) {
//				fn.mkdirs();
//			}
//			File[] content = f.listFiles();
//			for (File f2 : content) {
//
//				folderCopy(f2.getCanonicalPath(), fn.getCanonicalPath(), moved);
//			}
//
//		}
//
//		return true;
	}

}
