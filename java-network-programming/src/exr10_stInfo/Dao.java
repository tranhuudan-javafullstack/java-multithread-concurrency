package exr10_stInfo;

import java.util.ArrayList;
import java.util.List;

public class Dao {
	List<Student> los;
	List<User> lou;
	
	public Dao() {
		los = new ArrayList<Student>();
		los.add(new Student(111, "Trần Văn Ơn", 2000, 7.5));
		los.add(new Student(112, "Nguyễn Thị Như", 2002, 7.5));
		los.add(new Student(113, "Nguyen Thi Hong", 2002, 9));
		los.add(new Student(114, "Nguyen Thi Hoa Hong", 2003, 10));
		los.add(new Student(115, "Trần Văn Ơn", 2000, 7.5));
		
		lou = new ArrayList<User>();
		lou.add(new User("lphung", "12345"));
		lou.add(new User("pvthuan", "23456"));
	}

	public boolean checkUserName(String name) {
		for(User u:lou)
			if (u.name.equals(name)) return true;
		return false;
	}

	public boolean login(String name, String password) {
		for(User u:lou)
			if (u.name.equals(name) && u.password.equals(password)) return true;
		return false;
	}
	
	public List<Student> findById(String id){
		List<Student> list = new ArrayList<>();
		int stId = Integer.parseInt(id);
		for(Student st:los) {
			if (st.id==stId) {
				list.add(st);
				break;
			}
		}
		return list;	
	}
	public List<Student> findByName(String partName){
		List<Student> list = new ArrayList<>();
		for(Student st:los) {
			if (st.name.endsWith(partName)) {
				list.add(st);
			}
		}
		return list;	
	}
}
