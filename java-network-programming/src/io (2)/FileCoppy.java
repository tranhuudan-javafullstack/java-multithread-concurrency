package io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileCoppy {
	public static void coppyFile(String source, String dest ) throws IOException {
		InputStream fis = new BufferedInputStream(new FileInputStream(source));
		OutputStream fos = new BufferedOutputStream(new FileOutputStream(dest));
		int data;
		long st = System.currentTimeMillis();
		while ((data = fis.read()) != -1) {
			fos.write(data);
		}
		long et = System.currentTimeMillis();
		System.out.println("Done in :"+ (et - st) );
		fis.close();
		fos.close();
		
	}
	public static void coppyFileArr(String source, String dest) throws IOException {
		InputStream fis = new BufferedInputStream(new FileInputStream(source));
		OutputStream fos = new BufferedOutputStream(new FileOutputStream(dest));
		long st = System.currentTimeMillis();
		byte[] bytesToRead = new byte[100*2024];
		int byteRead;
		while ((byteRead = fis.read(bytesToRead)) != -1) {
			fos.write(bytesToRead, 0, byteRead);
		}
		long et = System.currentTimeMillis();
		System.out.println("Done in :"+ (et - st) );
		fis.close();
		fos.close();
	}
	public static void main(String[] args) throws IOException {
		String source = "C:\\Users\\TIEN\\Documents\\Zalo Received Files\\tien.docx";
		String dest = "C:\\Users\\TIEN\\Documents\\Zalo Received Files\\t.doc";
//		coppyFile(source, dest);
		coppyFileArr(source, dest);
	}
}
