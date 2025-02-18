package search_student_rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DAO extends UnicastRemoteObject implements ISearch {
	
	private Connection conn;
	int counter = 0;
	private Map<String, Long> sessions;

	protected DAO() throws RemoteException, ClassNotFoundException{
		sessions = new HashMap<String, Long>();
		String driver = "net.ucanaccess.jdbc.UcanaccessDriver";
		String url="jdbc:ucanaccess://C:/labSearch.accdb";
	try {
		Class.forName(driver);
		this.conn = DriverManager.getConnection(url);
		
	} catch (Exception e) {
		e.printStackTrace();
		throw new RemoteException(e.getMessage());
	}
		
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public boolean checkUsername(String username) {
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement("select * from user where username=?");
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			return rs.next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean login(String name, String pass) {
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement("select * from user where username =? and pass =?");
			ps.setString(1, name);
			ps.setString(2, pass);
			ResultSet rs = ps.executeQuery();
			return rs.next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public List<Student> searchByName(String name) {
		List<Student> students = new ArrayList<Student>();
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement("select * from Student where name=? ");
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Student s = new Student(rs.getInt("id"), rs.getString("name"), rs.getInt("age"), rs.getDouble("score"));
				students.add(s);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return students;
	}

	@Override
	public List<Student> searchByAge(int age) {
		List<Student> students = new ArrayList<Student>();
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement("select * from Student where age =? ");
			ps.setInt(1, age);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Student s = new Student(rs.getInt("id"), rs.getString("name"), rs.getInt("age"), rs.getDouble("score"));
				students.add(s);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return students;
	}

	@Override
	public List<Student> searchById(int id) {
		List<Student> students = new ArrayList<Student>();
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement("select * from Student where id =? ");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Student s = new Student(rs.getInt("id"), rs.getString("name"), rs.getInt("age"), rs.getDouble("score"));
				students.add(s);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return students;
	}

}
