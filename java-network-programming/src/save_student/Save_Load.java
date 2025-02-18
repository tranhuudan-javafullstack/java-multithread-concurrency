package save_student;

import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Save_Load {
	public static void save(String path, List<Student> students) throws IOException {
		DataOutputStream dos = new DataOutputStream(new FileOutputStream(path));
		dos.writeInt(students.size());
		for (int i = 0; i < students.size(); i++) {
			students.get(i).save(dos);
		}
	}

	public static List<Student> load(String path) throws IOException {
		List<Student> students = new ArrayList<Student>();
		File file = new File(path);
		if (!file.exists())
			return null;
		DataInputStream dis = new DataInputStream(new FileInputStream(file));
		int numberStudent = dis.readInt();
		Student s;
		for (int i = 0; i < numberStudent; i++) {
			s = new Student();
			s.load(dis);
			students.add(s);
		}
		return students;
	}

	public static void main(String[] args) throws IOException {
		List<Student> students = new ArrayList<Student>();
		List<Score> scores = new ArrayList<Score>();
		Score s = new Score(1, 9, "LTM");
		Score s1 = new Score(1, 9, "LTM1");
		Score s2 = new Score(1, 9, "LTM2");
		scores.add(s);
		scores.add(s1);
		scores.add(s2);

		Student st = new Student(1, "Tien", 21, 9, scores);
		Student st1 = new Student(1, "Tien2", 21, 9, scores);
		Student st2 = new Student(1, "Tien3", 21, 9, scores);
		students.add(st);
		students.add(st1);
		students.add(st2);
		String path = "C:\\Users\\TIEN\\Documents\\Zalo Received Files\\T.doc";
//		save(path, students);
		System.out.println(load(path));
	}
}
