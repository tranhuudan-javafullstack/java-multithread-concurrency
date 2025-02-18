package search_student_tcp;

public class Student {
	
	private int mssv;
	private String name;
	private int bYear;
	private double score;
	public Student(int mssv, String name, int bYear, double score) {
		super();
		this.mssv = mssv;
		this.name = name;
		this.bYear = bYear;
		this.score = score;
	}
	public int getMssv() {
		return mssv;
	}
	public void setMssv(int mssv) {
		this.mssv = mssv;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getbYear() {
		return bYear;
	}
	public void setbYear(int bYear) {
		this.bYear = bYear;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	@Override
	public String toString() {
		return "Student [mssv=" + mssv + ", name=" + name + ", bYear=" + bYear + ", score=" + score + "]";
	}
	
	
}
