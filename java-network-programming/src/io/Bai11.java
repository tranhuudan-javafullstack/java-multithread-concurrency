package io;

import java.io.File;

public class Bai11 {
public static String fileType(String fname) {
	File file = new File(fname);
	if (!file.exists()) return "file not found";
	if (file.isFile()) {
		if (fname.endsWith("zip")) {
			return "là file zip";
		}
		else if (fname.endsWith("doc")){
			return "là file doc";
		}
		
		
	}
	return "không phải là những file trên";
	
}
public static void main(String[] args) {
	String file = "C:\\Users\\TIEN\\Documents\\Zalo Received Files\\T.doc";
	System.out.println(fileType(file));
}
}
