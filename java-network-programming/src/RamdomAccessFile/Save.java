package RamdomAccessFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

public class Save {
	public static void save(String path, String mode, ArrayList<Student> ListStudent) {
		File file = new File(path);
		try {
			RandomAccessFile data = new RandomAccessFile(file, mode);
			List<Long> pointers = new ArrayList<Long>();
			long indexH = 0;

			data.writeInt(ListStudent.size());

			// Header include : MSSV + INDEX
			for (Student student : ListStudent) {
				indexH += data.getFilePointer() - indexH;
				pointers.add(indexH);
				data.writeInt(student.getMssv());
				data.writeLong(0);
			}
			
			System.out.println("index begin write content " + data.getFilePointer());

			for (int i = 0; i < ListStudent.size(); i++) {
				data.seek(data.getFilePointer());
				long indexS = data.getFilePointer();// save index pointer(byte) each write start
				long indexN = 0; // new pointer when write done a student

				data.writeInt(ListStudent.get(i).getMssv());
				data.writeUTF(ListStudent.get(i).getName());
				for (Subject subject : ListStudent.get(i).getSubjects()) {
					data.writeUTF(subject.getSubID());
					data.writeUTF(subject.getSubName());
					data.writeDouble(subject.getCredit());
				}

				indexN = data.getFilePointer();
				data.seek(((long) pointers.get(i) + 4l)); // move pointer to header
				data.writeLong(indexS); // write index a student
				data.seek(indexN); // move pointer to end

				System.out.println("Index write done student " + (i + 1) + " " + indexN);
			}

			data.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		Subject s1 = new Subject("MH1", "Toán", 10.0);
		Subject s2 = new Subject("MH2", "Anh", 8.0);
		Subject s3 = new Subject("MH4", "Văn", 9.0);

		List<Subject> subjectList = new ArrayList<Subject>();
		subjectList.add(s1);
		subjectList.add(s3);

		List<Subject> subjectList2 = new ArrayList<Subject>();
		subjectList2.add(s1);
		subjectList2.add(s2);

		Student st1 = new Student(20130245, "Tân", subjectList);
		Student st2 = new Student(21130246, "Hạo", subjectList2);
		Student st3 = new Student(21130247, "Linh", subjectList2);
		ArrayList<Student> studentList = new ArrayList<Student>();
		studentList.add(st1);
		studentList.add(st2);
		studentList.add(st3);

		String path = "C:\\Users\\TIEN\\Documents\\Zalo Received Files\\T.doc";
		save(path, "rw", studentList);
	}
}
