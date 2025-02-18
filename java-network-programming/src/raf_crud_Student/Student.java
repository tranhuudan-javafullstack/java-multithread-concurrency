package raf_crud_Student;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

public class Student {
	private int id;
	private String name;
	private int byear;

	public Student(int id, String name, int byear) {
		super();
		this.id = id;
		this.name = name;
		this.byear = byear;
	}

	public Student() {
	}


	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", byear=" + byear + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getByear() {
		return byear;
	}

	public void setByear(int byear) {
		this.byear = byear;
	}


	public void writeStudent(DataOutput dos, int len) throws IOException {
	 dos.writeInt(id);
	 writeFixLenghName(dos, len);
	 dos.writeInt(byear);
		
	}

	private void writeFixLenghName(DataOutput dos, int len) throws IOException {
		char c;
		for (int i = 0; i < len; i++) {
			 c= (i<name.length())? name.charAt(i): 0;
			 dos.writeChar(c);
		}
	
		
	}

	public void read(DataInput dis, int len) throws IOException {
		this.id = dis.readInt();
		this.name =  readFixLenghName(dis, len);
		this.byear = dis.readInt();
		
		
	}

	private String readFixLenghName(DataInput dis, int len) throws IOException {
		String res = "";
		char c;
		for (int i = 0; i < len; i++) {
			c = dis.readChar();
			if(c != 0) res += c;
		}
		return res;
	}

	

}
