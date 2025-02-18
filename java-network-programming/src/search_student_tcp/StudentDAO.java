package search_student_tcp;

import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
	static List<Student> listStudent = new ArrayList<Student>();
	static {
		listStudent.add(new Student(1, "Pham Thuy Tien", 21, 9));
		listStudent.add(new Student(1, "Pham Thuy Tien", 21, 9));
		listStudent.add(new Student(1, "Pham Thuy Tien", 21, 9));
		listStudent.add(new Student(1, "Pham Thuy Tien", 21, 9));
		listStudent.add(new Student(1, "Pham Thuy Tien", 21, 9));
	}

	public static List<Student> findByName(String name) {
		List<Student> ls = new ArrayList<Student>();
		for (Student s : listStudent) {
			if (s.getName().toUpperCase().contains(name.toUpperCase())) {
				ls.add(s);
			}

		}
		return ls;
	}

	public static List<Student> findByAge(int age) {
		List<Student> ls = new ArrayList<Student>();
		for (Student s : listStudent) {
			if (s.getbYear() == age) {
				ls.add(s);
			}
		}
		return ls;

	}

	public static List<Student> findByScore(double score) {
		List<Student> ls = new ArrayList<Student>();
		for (Student s : listStudent) {
			if (s.getScore() == score) {
				ls.add(s);
			}
		}
		return ls;
	}
}
