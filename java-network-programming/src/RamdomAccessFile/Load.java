	package RamdomAccessFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public class Load {
	public static void load(String path, String mode, int index) {
		ArrayList<Student> studentArrayList = new ArrayList<>();
		File file = new File(path);
		try {
			RandomAccessFile raf = new RandomAccessFile(file, mode);
			int size = raf.readInt();
			if (size > 0) {
				System.out.println("Header : ");
				for (int i = 0; i < size; i++) {
					System.out.println(raf.readInt() + " index byte start " + raf.readLong());
				}
				raf.seek(8); // 4 btye is size list + 4 byte int(mssv of first student)
				raf.seek(raf.readLong()); // index of student
			}

			System.out.println("\nsố lượng sinh viên : " + size);
			for (int i = 0; i < size; i++) {

				Student student = new Student(raf.readInt(), raf.readUTF(), null);
				Subject subject = new Subject(raf.readUTF(), raf.readUTF(), raf.readDouble());
				Subject subject1 = new Subject(raf.readUTF(), raf.readUTF(), raf.readDouble());

				ArrayList<Subject> subjectArrayList = new ArrayList<Subject>();
				subjectArrayList.add(subject);
				subjectArrayList.add(subject1);
				student.setSubjects(subjectArrayList);
				studentArrayList.add(student);
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (Student s : studentArrayList) {
			System.out.println(s.toString());
		}

	}

	public static void main(String[] args) {
		String path = "C:\\Users\\TIEN\\Desktop\\test.txt";
		load(path, "r", 2);
	}
}
