package sl_student_raf;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

public class Save_Load_Student {
	public static ArrayList<Long> save(String path, List<Student> students, String mode) throws IOException {
		File file = new File(path);
		if (!file.exists())
			file.createNewFile();
		if (file.isDirectory())
			System.out.println("File is Directory");
		RandomAccessFile raf = new RandomAccessFile(file, mode);
		ArrayList<Long> pointers = new ArrayList<Long>();
		ArrayList<Long> p = new ArrayList<Long>();
		raf.writeInt(students.size());
		long Hsize;
		// HEADER AND INDEX
		for (int i = 0; i < students.size(); i++) {
			Hsize = raf.getFilePointer();
			System.out.println(Hsize);
			pointers.add(Hsize);
			raf.writeInt(students.get(i).getId());
			raf.writeLong(0);

		}
		System.out.println("Index begin write content" + raf.getFilePointer());
		for (int i = 0; i < students.size(); i++) {
			long sizeS = raf.getFilePointer();
			p.add(sizeS);
			raf.writeInt(students.get(i).getId());
			raf.writeUTF(students.get(i).getName());
			raf.writeInt(students.get(i).getByear());
			raf.writeInt(students.get(i).getScores().size());
			for (Score s : students.get(i).getScores()) {
				raf.writeInt(s.getId());
				raf.writeDouble(s.getScore());

			}
			long sizeD = raf.getFilePointer();
			System.out.println(pointers.get(i) + 4l);
			raf.seek(pointers.get(i) + 4l);
			raf.writeLong(sizeS);
			raf.seek(sizeD);
			System.out.println("Index write done student" + i + " " + raf.getFilePointer());
		}
		return p;
	}

	public static void load(ArrayList<Long> arrPosition,String path, String mode, int index) throws IOException {
        File file = new File(path);
        if (!file.exists() || file.isDirectory()) {
            System.out.println("File not found or is a directory");
        }
        	int arrList = index -1;
        	long position = arrPosition.get(arrList);
       RandomAccessFile raf = new RandomAccessFile(file, mode);
       	raf.seek(position);
       	Student s = new Student();
       	s.load(raf);
       	System.out.println(s.toString());
       	
    }

	public static void main(String[] args) throws IOException {
		Score s = new Score(1, 9);
		Score s1 = new Score(1, 9);
		Score s2 = new Score(1, 9);
		List<Score> scores = new ArrayList<Score>();
		scores.add(s);
		scores.add(s1);
		scores.add(s2);
		Student st = new Student(1, "tien", 21, scores);
		Student st1 = new Student(2, "tien", 21, scores);
		Student st2 = new Student(3, "tien", 21, scores);
		List<Student> students = new ArrayList<Student>();
		students.add(st);
		students.add(st1);
		students.add(st2);

		String path = "C:\\Users\\TIEN\\Documents\\Zalo Received Files\\T1.doc";
ArrayList<Long> arr =save(path, students, "rw");	
		load(arr, path, "rw", 4);
//		System.out.println(load(arr,path, "rw", 2).toString());
	}

}
