package exr5_raf_list;

import java.io.IOException;
import java.io.RandomAccessFile;

public class RafList {
	static final int NAME_LEN=25;
	RandomAccessFile raf;
	int count = 0;
	int recSize;
	int len;
	int headSize = 8;
	public RafList(String file) throws IOException {
		this.raf = new RandomAccessFile(file, "rw");
		if (raf.length()>0) {//exist
			this.count = raf.readInt();
			this.recSize = raf.readInt();
			this.len = (recSize - 16)/2;
		} else {// create new file
			this.count = 0;
			this.recSize = NAME_LEN * 2 + 16;
			this.len = NAME_LEN;
			raf.writeInt(count);
			raf.writeInt(recSize);
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
		if (index>=count) return null;
		long pos = headSize + index * recSize;
		raf.seek(pos);
		Student st = new Student();
		st.readStudent(raf, len);
		return st;
	}
	public void update(int index, Student st) throws IOException {
		if (index>=count) return;
		long pos = headSize + index * recSize;
		raf.seek(pos);
		st.writeStudent(raf, len);
	}
	public Student findById(int id) {
		
		return null;
	}
	public void close() throws IOException {
		raf.close();
	}
	public static void main(String[] args) throws IOException {
		String file = "C:\\Users\\TIEN\\Documents\\Zalo Received Files\\dDir\\T1.txt";
		RafList list = new RafList(file);
		list.add(new Student(111, "Nguyễn A", 2005, 9.2));
		list.add(new Student(222, "Tráº§n VÄƒn NguyÃªn", 2005, 8.2));
		list.add(new Student(222, "LÃª Thá»‹ RiÃªng", 2005, 7.2));
		Student st = list.get(1);
		System.out.println(st);
//		System.out.println(list.get(2));
//		list.update(2, new Student(222, "LÃª Phi HÃ¹ng", 2005, 10));
//		System.out.println(list.get(2));
//		list.close();

	}

}
