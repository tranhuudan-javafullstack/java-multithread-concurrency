package saveStudent1;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.List;

public class File2 {
	void save(List<Student> students, String path) throws IOException {

		RandomAccessFile dos = new RandomAccessFile(path, "rw");

		dos.writeInt(students.size());

		for (Student student : students) {
			dos.writeInt(student.id);
			dos.writeLong(0);

		}
		long pos = dos.getFilePointer();
		long hpos;

		for (int i = 0; i < students.size(); i++) {

			hpos = 4 + i * 12 + 4;
			dos.seek(hpos);
			dos.writeLong(pos);
			dos.seek(pos);
			students.get(i).save(dos);
			pos = dos.getFilePointer();
		}

		dos.close();

	}

	Student read(String path, int id) throws IOException {
		Student st = null;

		RandomAccessFile dis = new RandomAccessFile(path, "rw");

		int num = dis.readInt();
		if (id >= num) {
			dis.close();
			return null;

		}
		long hpos = 4 + id * 12 + 4;

		dis.seek(hpos);
		long pos = dis.readLong();
		dis.seek(pos);
		st = new Student();
		st.read(dis);

		dis.close();

		return st;
	}

	Student readById(String path, int id) throws IOException {
		Student st = null;

		RandomAccessFile dis = new RandomAccessFile(path, "rw");

		int num = dis.readInt();
		for (int i = 0; i < num; i++) {

			long hpos = 4 + i * 12;
			dis.seek(hpos);
			int stId = dis.readInt();
			if (stId != id)
				continue;
			dis.seek(hpos + 4);
			long pos = dis.readLong();
			dis.seek(pos);
			st = new Student();
			st.read(dis);
			break;
		}

		dis.close();

		return st;
	}
}
