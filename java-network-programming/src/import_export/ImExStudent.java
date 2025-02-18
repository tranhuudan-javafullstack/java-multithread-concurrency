package import_export;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ImExStudent {
	public static List<Student> imporStudent(String sFile, String gFile, String charset) throws IOException {
		if (!new File(sFile).exists()) {
			throw new FileNotFoundException("File not found");
		}
		if (!new File(gFile).exists()) {
			throw new FileNotFoundException();
		}
		List<Student> students = new ArrayList<Student>();
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(sFile), charset));
		String line;
		StringTokenizer st;
		int id;
		String name;
		int bYear;
		double grade;

		while ((line = reader.readLine()) != null) {
			st = new StringTokenizer(line, "\t");
			id = Integer.parseInt(st.nextToken());
			name = st.nextToken();
			bYear = Integer.parseInt(st.nextToken());
			students.add(new Student(id, name, bYear));
		}
		reader.close();

		reader = new BufferedReader(new InputStreamReader(new FileInputStream(gFile), charset));
		while ((line = reader.readLine()) != null) {
			st = new StringTokenizer(line, "\t");
			id = Integer.parseInt(st.nextToken());
			int count = 0;
			double value = 0;
			while (st.hasMoreElements()) {
				String s = st.nextToken();
				value += Double.parseDouble(s);
				count++;

			}
			grade = value / count;
			for (Student s : students) {
				if (s.getId() == id) {
					s.setGrade(grade);
				}
			}
		}
		reader.close();
		return students;
	}

	public static void export(List<Student> students, String dFile, String charset) throws FileNotFoundException {
		PrintWriter writer = new PrintWriter(new File(dFile));
		for (Student s : students) {
			String line = s.getId() + "," + s.getName() + "," + s.getbYear() + "," + s.getGrade();
			writer.println(line);
		}
		writer.close();

	}

	public static void main(String[] args) throws IOException {
//		String sFile = "C:\\Users\\TIEN\\Documents\\Zalo Received Files\\T.txt";
//		String gFile = "C:\\Users\\TIEN\\Documents\\Zalo Received Files\\Tcoppy.txt";
//		System.out.println(imporStudent(sFile, gFile, "UTF-8").toString());
		String dFile = "C:\\\\Users\\\\TIEN\\\\Documents\\\\Zalo Received Files\\\\T.txt";
		List<Student> students = new ArrayList<Student>();
		students.add(new Student(1, "Tien", 21));
		students.add(new Student(2, "Tien2", 20));
		export(students, dFile, "UTF-8");
	}
}
