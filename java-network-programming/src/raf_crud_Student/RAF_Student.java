package raf_crud_Student;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RAF_Student {
	static final int NAME_SIZE = 25;
	RandomAccessFile raf;
	int count = 0;
	int contentSize;
	int len;
	File file;
	int Hsize = 8;

	public RAF_Student(String path) throws IOException {
		this.file = new File(path);
		if (!this.file.exists())
			file.createNewFile();
		if (file.isDirectory())
			System.out.println("file is Directory");
		this.raf = new RandomAccessFile(file, "rw");
		if (raf.length() > 0) { // exists content
			this.count = raf.readInt();
			this.contentSize = raf.readInt();
			this.len = (contentSize - 8) / 2;

		} else {
			this.count = 0;
			this.contentSize = NAME_SIZE * 2 + 8;
			this.len = NAME_SIZE;
			raf.writeInt(count);
			raf.writeInt(contentSize);
		}

	}

	public void add(Student st) throws IOException {
		raf.seek(raf.length());
		st.writeStudent(raf, len);
		count++;
		raf.seek(0);
		raf.writeInt(count);

	}

	public Student get(int index) throws IOException {
		if (index > count)
			System.out.println("index not exists");
		long pos = Hsize + (index * contentSize);
		raf.seek(pos);
		Student s = new Student();
		s.read(raf, len);
		return s;

	}

	public void update(Student s, int index) throws IOException {
		if (index > count)
			System.out.println("index not exists");
		long pos = Hsize + (index * contentSize);
		raf.seek(pos);
		s.writeStudent(raf, len);

	}

	public void close() throws IOException {
		raf.close();
	}

	public static void main(String[] args) throws IOException {
		String path = "C:\\Users\\TIEN\\Documents\\Zalo Received Files\\dDir\\T.txt";
		RAF_Student rs = new RAF_Student(path);
		rs.add(new Student(1, "tien", 21));
		rs.add(new Student(2, "lan", 21));
		rs.add(new Student(3, "nhi", 21));

		rs.add(new Student(4, "ngoc", 21));

		System.out.println(rs.get(1));
		rs.close();

	}
}
