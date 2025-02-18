package save_student;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Student {
	private int id;
	private String name;
	private int byear;
	private double avg;
	private List<Score> scores;

	public Student(int id, String name, int byear, double avg, List<Score> scores) {
		super();
		this.id = id;
		this.name = name;
		this.byear = byear;
		this.avg = avg;
		this.scores = scores;
	}

	public Student() {
		scores = new ArrayList<Score>();
	}


	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", byear=" + byear + ", avg=" + avg + ", scores=" + scores
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

	public double getAvg() {
		return avg;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}

	public void save(DataOutputStream dos) throws IOException {
		dos.writeInt(this.id);
		dos.writeUTF(this.name);
		dos.writeInt(this.byear);
		dos.writeDouble(this.avg);
		dos.writeInt(scores.size());
		for (int i = 0; i < scores.size(); i++) {
			dos.writeInt(scores.get(i).getId());
			dos.writeDouble(this.scores.get(i).getScore());
			dos.writeUTF(this.scores.get(i).getSubject());
		}

	}

	public void load(DataInputStream dis) throws IOException {
		id = dis.readInt();
		name = dis.readUTF();
		byear = dis.readInt();
		avg = dis.readDouble();
		int numberScore = dis.readInt();

		for (int j = 0; j < numberScore; j++) {
			Score sc = new Score();
			sc.load(dis);
			this.add(sc);
		}

	}

	public void add(Score s) {
		scores.add(s);
	}

}
