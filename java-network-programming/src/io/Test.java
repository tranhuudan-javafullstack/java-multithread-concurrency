package io;

import java.io.IOException;

public class Test {
	public static void main(String[] args) throws IOException {

		Bai8 f = new Bai8();

//		System.out.println(f.fileCopy(
//				"C:\\Users\\dell\\OneDrive - st.hcmuaf.edu.vn\\Desktop\\test\\CV SINH VIÊN NĂM NHẤT NGÀNH MARKETING.pdf",
//				"C:\\Users\\dell\\OneDrive - st.hcmuaf.edu.vn\\Desktop\\bktest\\test.pdf", false));

		Bai9 f2 = new Bai9();
//		System.out.println(f2.folderCopy("C:\\Users\\dell\\OneDrive - st.hcmuaf.edu.vn\\Desktop\\test",
//				"C:\\Users\\dell\\OneDrive - st.hcmuaf.edu.vn\\Desktop\\bktest", false));

		Bai10 f3 = new Bai10();

		f3.FileSpliter(
				"C:\\Users\\dell\\OneDrive - st.hcmuaf.edu.vn\\Desktop\\test\\Neil, Theresa - Mobile Design Pattern Gallery_ UI Patterns for Mobile Applications-O'Reilly Media (2014).pdf",
				100000000);

	}
}
