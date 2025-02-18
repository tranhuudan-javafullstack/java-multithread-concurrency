package Student_tcp;

import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
	public List<Student> listStudent(){
		List<Student> ls = new ArrayList<Student>();
		ls.add(new Student(1, "Pham Thuy tien", 21, 9.0));
		ls.add(new Student(2, "Pham Thuy dan", 21, 9.0));
		ls.add(new Student(3, "Pham Thuy nga", 21, 9.0));
		ls.add(new Student(4, "Pham Thuy bich", 21, 9.0));
		return ls;
	}
	public List<User> listUser(){
		List<User> lu = new ArrayList<User>();
		lu.add(new User(1, "Dan", "123"));
		lu.add(new User(2, "Dan", "123"));
		lu.add(new User(3, "nga", "123"));
		lu.add(new User(4, "bich", "123"));
		return lu;
	}
	public boolean check(String param) {
		List<User> lUser = listUser();
		for (User s : lUser) {
			
			return s.getUserName().equals(param);
		}
		return false;
	}
	public boolean login(String username, String pass) {
		List<User> lUser = listUser();
		for (User s : lUser) {
		if ( s.getUserName().equals(username) && s.getPassword().equals(pass) )
			return true;
		}
		return false;
	}
	public List<Student> findByName(String name){
		List<Student> ls = new ArrayList<Student>();
		List<Student> listStudent = listStudent();
		for (Student s :listStudent ) {
			if (s.getName().toUpperCase().contains(name.toUpperCase()))
				ls.add(s);
		}
		return ls;
	}
	public List<Student> findByAge(int age){
		List<Student> ls = new ArrayList<Student>();
		List<Student> listStudent = listStudent();
		for (Student s :listStudent ) {
			if (s.getbYear() == age)
				ls.add(s);
		}
		return ls;
	}
	public List<Student> findByScore(double score){
		List<Student> ls = new ArrayList<Student>();
		List<Student> listStudent = listStudent();
		for (Student s :listStudent ) {
			if (s.getScore() == score)
				ls.add(s);
		}
		return ls;
	}
}
