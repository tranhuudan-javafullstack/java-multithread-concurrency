package save_student;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Score {
	private int id;
	private double score;
	private String subject;

	public Score(int id, double score, String subject) {
		super();
		this.id = id;
		this.score = score;
		this.subject = subject;
	}
	

	@Override
	public String toString() {
		return "Score [id=" + id + ", score=" + score + ", subject=" + subject + "]";
	}


	public Score() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public void load(DataInputStream in) throws IOException {
		this.id = in.readInt();
		this.score = in.readDouble();
		this.subject = in.readUTF();
	}

}
