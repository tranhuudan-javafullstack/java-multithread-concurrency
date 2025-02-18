package iostream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileCopy {
	static public void fileCopy(String source, String dest) throws IOException {
		InputStream fis = new BufferedInputStream(new FileInputStream(source));
		OutputStream fos = new BufferedOutputStream(new FileOutputStream(dest));
		int data;
		long bt = System.currentTimeMillis();
		
		while((data = fis.read())!=-1) {
			fos.write(data);
		}
		long et = System.currentTimeMillis();
		
		System.out.println("Done in: " + (et-bt) + "ms");
		fis.close();
		fos.close();
	}
	static public void fileCopyArr(String source, String dest) throws IOException {
		InputStream fis =new FileInputStream(source);
		OutputStream fos = new FileOutputStream(dest);
		int data;
		long bt = System.currentTimeMillis();
		byte[] buff = new byte[100*1024];
		int byteread;
		while((byteread = fis.read(buff))!=-1) {
			fos.write(buff,0,byteread);
		}
		long et = System.currentTimeMillis();
		
		System.out.println("Done in: " + (et-bt) + "ms");
		fis.close();
		fos.close();
	}
	public static void main(String[] args) throws IOException {
		String source = "d:\\temp\\ltm\\JDBC.pdf";
		String dest = "d:\\temp\\ltm\\jdbc_copy.pdf";
		fileCopyArr(source, dest);
	}

}
