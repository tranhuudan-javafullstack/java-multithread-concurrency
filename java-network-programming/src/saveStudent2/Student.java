package saveStudent2;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.PrimitiveIterator.OfDouble;

public class Student {
	public int id;
	public String name;
	public int bYear;
	public double avg;

	public Student(int id, String name, int bYear, double avg) {
		super();
		this.id = id;
		this.name = name;
		this.bYear = bYear;
		this.avg = avg;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", bYear=" + bYear + ", avg=" + avg + "]";
	}

	public void save(DataOutput dos, int nameLen) throws IOException {

		dos.writeInt(this.id);
		writeFixedLength(dos, nameLen);

		dos.writeInt(this.bYear);
		dos.writeDouble(this.avg);

	}

	public void read(DataInput dis, int nameLen) throws IOException {

		id = dis.readInt();
		name = readFixedLength(dis, nameLen);
		bYear = dis.readInt();
		avg = dis.readDouble();

	}

	private String readFixedLength(DataInput dos, int nameLen) throws IOException {
		String res = "";
		char c;
		for (int i = 0; i < nameLen; i++) {
			c = dos.readChar();
			if (c != 0)
				res += c;
		}
		return res;
	}

	private void writeFixedLength(DataOutput dos, int nameLen) throws IOException {
		char c;
		for (int i = 0; i < nameLen; i++) {
			c = i < name.length() ? name.charAt(i) : 0;
			dos.writeChar(c);
		}
	}

	public Student() {
		super();
	}

}
