package sl_student_raf;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

public class Student {
	private int id;
	private String name;
	private int byear;
	private List<Score> scores;

	public Student(int id, String name, int byear, List<Score> scores) {
		super();
		this.id = id;
		this.name = name;
		this.byear = byear;
		this.scores = scores;
	}

	public Student() {
		scores = new ArrayList<Score>();
	}


	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", byear=" + byear + " scores=" + scores
				+ "]";
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

	public List<Score> getScores() {
		return scores;
	}

	public void setScores(List<Score> scores) {
		this.scores = scores;
	}

	public Student load(RandomAccessFile raf) throws IOException {

	        id = raf.readInt();

	            name = raf.readUTF();
	      

	        byear = raf.readInt();
	        int sScore = raf.readInt();

	        for (int i = 0; i < sScore; i++) {
	       
	                Score s = new Score();
	                s.load(raf);
	                scores.add(s);
	         
	        }
	  
	    return this;
	}



	

}
