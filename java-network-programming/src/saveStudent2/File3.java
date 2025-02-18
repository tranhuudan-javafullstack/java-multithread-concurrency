package saveStudent2;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.List;

public class File3 {
	public static final int NAME_LEN = 25;

	void save(List<Student> students, String path) throws IOException {

		RandomAccessFile raf = new RandomAccessFile(path, "rw");

		raf.writeInt(students.size()); // so luong
		int stsize = 4 + NAME_LEN * 2 + 4 + 8;
		raf.writeInt(stsize);
		raf.writeInt(NAME_LEN);

		for (Student st : students) {
			st.save(raf, NAME_LEN);

		}

		raf.close();

	}

	Student read(String path, int id) throws IOException {
		Student st = null;

		RandomAccessFile dis = new RandomAccessFile(path, "rw");

		int num = dis.readInt();
		int stSize = dis.readInt();
		int nameLen = dis.readInt();
		if (id >= num) {
			dis.close();
			return null;
		}
		long pos = 12 + id * stSize;
		dis.seek(pos);
		st = new Student();
		st.read(dis, nameLen);

		dis.close();

		return st;

		
	}
}
