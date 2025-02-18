package saveStudent;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

public class File {
	void save(List<Student> students, String path) throws IOException {

		DataOutputStream dos = new DataOutputStream(new FileOutputStream(path));
		
		dos.writeInt(students.size());
		
		for (int i = 0; i < students.size(); i++) {
			students.get(i).save(dos);

		}

		dos.close();

	}

	List<Student> read(String path) throws IOException {
		List<Student> rs = new ArrayList<Student>();

		DataInputStream dis = new DataInputStream(new FileInputStream(path));

		int num = dis.readInt();
		Student st;
		for (int i = 0; i < num; i++) {
			st = new Student();
			st.read(dis);
			rs.add(st);
		}

		dis.close();

		return rs;

	}
}
