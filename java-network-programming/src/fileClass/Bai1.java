package fileClass;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Bai1 {
//	public static boolean delete(String path) throws IOException {
//		File f = new File(path);
//		if (!f.exists()) return true;
//		if (f.isDirectory()) {
//			File[] list = f.listFiles();
//			for (File l : list)
//				delete(l.getCanonicalPath());
//		}
//		return f.delete();
////
////		File f = new File(path);
////		if (!f.exists())
////			return true;
////		if (f.isDirectory()) {
////			File[] content = f.listFiles();
////			for (File f1 : content)
////				delete(f1.getCanonicalPath());
////		}
////		return f.delete();
//
//	}
	
	public static String[] listFile(String pack) throws IOException {
		RandomAccessFile raf  = new RandomAccessFile(pack, "rw");
		int size = raf.readInt();
		String[] s = new String[size];
		for (int i =0; i<size; i++) {
			raf.readLong();
			s[i] = raf.readUTF();
		}
		return null;
	
	}

}
