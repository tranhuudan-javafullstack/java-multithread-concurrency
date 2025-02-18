package fileClass1;
import java.io.*;
public class Folder {
	public static String getFileWithExt(String folder, String ext) {
		String res = "";
		ext = "." + ext;
		ext = ext.toLowerCase();
		File dir = new File(folder);
		File[] files = dir.listFiles();
		for(File f:files) {
			if (f.isFile()) {
				String name = f.getAbsolutePath().toLowerCase();
				if (name.endsWith(ext)) 
					res = res + f.getAbsolutePath() + "\n";
			}
		}
		return res;
	}
	
	public static String[] getFileByFilter(String folder, String ext) {
		File dir = new File(folder);
		return dir.list(new MyExt(ext));
	
	}
	
	static class MyExt implements FilenameFilter{
		private String ext;
		public MyExt (String ext) {
			this.ext = "." + ext;
		}
		@Override
		public boolean accept(File dir, String name) {
			return name.endsWith(ext);
		}
		
	}
public static void main(String[] args) {
	String folder = "C:\\\\Users\\\\TIEN\\\\Documents\\\\Zalo Received Files";
	String ext = "pdf";
	
	String[] files = getFileByFilter(folder, ext);
	for(String f:files) System.out.println(f);

}
}
