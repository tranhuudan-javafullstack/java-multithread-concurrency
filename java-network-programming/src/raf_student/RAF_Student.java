package raf_student;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;



public class RAF_Student {
	static final int NAME_SIZE = 25;
	int count ;
	int countSize;
	int len;
	int Hsize = 8;
	RandomAccessFile raf;
	File file;
	public RAF_Student(String path) throws IOException {
		file = new File(path);
		if (!file.exists()) {
			file.createNewFile();
		}
		if (file.isDirectory()) System.out.println("File is Directory");
		raf = new RandomAccessFile(file, "rw");
		if (raf.length() > 0) { //exists content
			this.count = raf.readInt();
			this.countSize = raf.readInt();
			this.len = (countSize - 16)/2;
			
		}else {
			this.count = 0;
			this.countSize = NAME_SIZE * 2 + 16;
			this.len = NAME_SIZE;
			raf.writeInt(count);
			raf.writeInt(countSize);
		}
	}
	
	public void add(Student s) throws IOException {
		raf.seek(raf.length());
		s.writeStudent(raf, len);
		count++;
		raf.seek(0);
		raf.writeInt(count);
	}
	public Student get(int index) throws IOException {
		if (index > count) System.out.println("index not exsits");
		int pos = Hsize + index * countSize;
		raf.seek(pos);
		Student s = new Student();
		s.readStudent(raf, len);
		return s;
	}
	public void update(int index, Student s) throws IOException {
		if (index > count) System.out.println("not exists");
		int pos = Hsize + index * countSize;
		raf.seek(pos);
		s.writeStudent(raf, len);
	}
	public void close() throws IOException {
		raf.close();
	}
	public static void main(String[] args) throws IOException {
		String path = "C:\\Users\\TIEN\\Documents\\Zalo Received Files\\T.txt";
		RAF_Student rs = new RAF_Student(path);
		rs.add(new Student(1, "tien", 21, 9));
		rs.add(new Student(2, "lan", 21, 9));
		rs.add(new Student(3, "nhi", 21, 9));

		rs.add(new Student(4, "ngoc", 21,9));

		System.out.println(rs.get(1));
		rs.close();

	}
	
}
