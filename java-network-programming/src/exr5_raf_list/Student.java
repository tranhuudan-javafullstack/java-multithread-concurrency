package exr5_raf_list;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class Student {
	int id;
	String name;
	int bYear;
	double grade;
	
	public Student() {}
	
	public Student(int id, String name, int bYear, double grade) {
		this.id = id;
		this.name = name;
		this.bYear = bYear;
		this.grade = grade;
	}
	//Writee name with lenx2 byte
	public void writeFixedLengthName(DataOutput dos, int len) throws IOException {
		char c;
		for(int i=0; i<len; i++) {
			c= (i<name.length())? name.charAt(i): 0;
			dos.writeChar(c);
		}
	}
	private String readFixedLengthName(DataInput dis, int len) throws IOException {
		String res = "";
		char c;
		for(int i=0; i<len; i++) {
			c = dis.readChar();
			if (c!=0) res += c;
		}
		return res;
	}

	
	public void writeStudent(DataOutput dos, int len) throws IOException {
		dos.writeInt(id);
		writeFixedLengthName(dos, len);
		dos.writeInt(bYear);
		dos.writeDouble(grade);
	}
	
	public void readStudent(DataInput dis, int len) throws IOException {
		id = dis.readInt();
		name = readFixedLengthName(dis, len);
		bYear = dis.readInt();
		grade = dis.readDouble();
	}


	public String toString() {
		return "Id:" + id + ", Name:" + name + ", bYear:" + bYear + ", Grade:" + grade;
	}
}
