package fileClass;

import java.io.IOException;

import fileClass.Bai1;

public class Test {
	public static void main(String[] args) throws IOException {

//		System.out.println(Bai1.delete("C:\\Users\\dell\\OneDrive - st.hcmuaf.edu.vn\\Desktop\\bktest"));

		Bai2 f2 = new Bai2();

//		f2.findAll("C:\\Users\\dell\\OneDrive - st.hcmuaf.edu.vn\\Desktop\\test", new String[] { ".html",".pdf" });

		Bai3 f3 = new Bai3();

		f3.findAll("C:\\Users\\dell\\OneDrive - st.hcmuaf.edu.vn\\Desktop\\test", ".*");

		Bai4 f4 = new Bai4();
//		f4.dirTree("C:\\Users\\dell\\Downloads\\mayhutbui5");

		Bai5 f5 = new Bai5();

//		f5.dirTree("C:\\Users\\dell\\Downloads\\mayhutbui5");

		Bai6 f6 = new Bai6();

//		f6.deleteAll("C:\\Users\\dell\\OneDrive - st.hcmuaf.edu.vn\\Desktop\\test", new String[] { ".pdf" });

		Bai7 f7 = new Bai7();

//		f7.copyAll("C:\\Users\\dell\\OneDrive - st.hcmuaf.edu.vn\\Desktop\\test",
//				"C:\\Users\\dell\\OneDrive - st.hcmuaf.edu.vn\\Desktop\\bktest", new String[] { ".docx", ".pdf" });
	}

}
