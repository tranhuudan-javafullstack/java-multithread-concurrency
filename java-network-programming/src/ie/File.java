package ie;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

import saveStudent1.Student;

public class File {

	static List<Student> importT(String path, String cs) throws IOException {

		List<Student> list = new ArrayList<>();
		Student student = null;
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(path)));
		String lineString;
		StringTokenizer s;
		while ((lineString = bufferedReader.readLine()) != null) {
			s = new StringTokenizer(lineString, "\t");
//			System.out.println(Arrays.toString(lineString.split("\t")));
			student = new Student(Integer.parseInt(lineString.split("\t")[0]), lineString.split("\t")[1],
					Integer.parseInt(lineString.split("\t")[2]), Double.parseDouble(lineString.split("\t")[3]));

			list.add(student);

		}
		bufferedReader.close();

		return list;

	}

	static void exportT(List<Student> list, String path, String cs)
			throws FileNotFoundException, UnsupportedEncodingException {

		PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(new FileOutputStream(path), cs));
		for (Student student : list) {

			printWriter.println(student.id + "\t" + student.name + "\t" + student.bYear + "\t" + student.avg);
		}

		printWriter.close();

	}

	public static void main(String[] args) throws IOException {

		List<Student> l = new ArrayList<Student>();
		l.add(new Student(1, "em be", 2002, 10.0));
		l.add(new Student(2, "em be 2", 2002, 9.0));
		l.add(new Student(3, "em be 3", 2002, 9.5));

//		exportT(l, "C:\\Users\\dell\\OneDrive - st.hcmuaf.edu.vn\\Desktop\\test\\test.txt", "UTF-8");

		System.out.println(importT("C:\\Users\\dell\\OneDrive - st.hcmuaf.edu.vn\\Desktop\\test\\test.txt", "UTF-8"));

	}

}
