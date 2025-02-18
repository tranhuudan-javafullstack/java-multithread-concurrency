package look_student_rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class StudentImpl extends UnicastRemoteObject implements IFind {
	List<Student> students;

	protected StudentImpl() throws RemoteException {
		students = new ArrayList<Student>();
		students.add(new Student(1, "Pham Thuy Tien", 21, 9));
		students.add(new Student(2, "Pham Thuy nga", 21, 9));
		students.add(new Student(3, "Pham Thuy ngoc", 22, 9));
		students.add(new Student(4, "Pham Thuy Tien", 21, 9));
		
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public List<Student> findByName(String name) {
		List<Student> sl = new ArrayList<Student>();
		for (Student s : students) {
			if (s.getName().equals(name))
				sl.add(s);
		}
		return sl;
	}

	@Override
	public List<Student> fineByAge(int age) {
		List<Student> sl = new ArrayList<Student>();
		for (Student s : students) {
			if (s.getAge() == age)
				sl.add(s);
		}
		return sl;
	}

	@Override
	public List<Student> fineByScore(double score) {
		List<Student> sl = new ArrayList<Student>();
		for (Student s : students) {
			if (s.getScore() == score)
				sl.add(s);
		}
		return sl;
	}

}
