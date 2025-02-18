package exr6_text;

public class Student {
	int id;
	String name;
	int bYear;
	double grade;
	
	
	public Student(int id, String name, int bYear) {
		this.id = id;
		this.name = name;
		this.bYear = bYear;
	}

	

	public void setGrade(double grade) {
		this.grade = grade;
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



	public int getbYear() {
		return bYear;
	}



	public void setbYear(int bYear) {
		this.bYear = bYear;
	}



	public double getGrade() {
		return grade;
	}



	public String toString() {
		return "Id:" + id + ", Name:" + name + ", bYear:" + bYear + ", Grade:" + grade;
	}
}
