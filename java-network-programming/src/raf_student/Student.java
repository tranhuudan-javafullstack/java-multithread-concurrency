package raf_student;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Student {
	private int id;
	private String name;
	private int age;
	private double score;
	public Student(int id, String name, int age, double score) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.score = score;
	}
	
	public Student() {
		super();
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + ", score=" + score + "]";
	}
	public void writeStudent(DataOutput dos, int len) throws IOException {
		dos.writeInt(id);
		writeFixName(dos, len);
		dos.writeInt(age);
		dos.writeDouble(score);
	}
	private void writeFixName(DataOutput dos, int len) throws IOException {
		char c;
		for (int i = 0; i < len; i++) {
			c = (i < this.name.length()) ? name.charAt(i) : 0;
			dos.writeChar(c);
		}
	}

	public void readStudent(DataInput dis, int len) throws IOException {
		this.id = dis.readInt();
		this.name = readFixName(dis, len);
		this.age = dis.readInt();
		this.score = dis.readDouble();
	}

	private String readFixName(DataInput dis, int len) throws IOException {
		String res ="";
		char c;
		for (int i = 0; i < len; i++) {
			c = dis.readChar();
			if (c!= 0)
				res+=c;
			
		}
	
		return res;
	}
	
	
	
}
