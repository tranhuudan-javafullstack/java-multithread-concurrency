package exr11_stInfo_db;
import java.security.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Dao {
	
	private Connection conn=null;
	public void cloeConnection() throws SQLException {
		if (conn!=null) conn.close();
	}
	public Dao() throws SQLException, ClassNotFoundException {
		String driver = "net.ucanaccess.jdbc.UcanaccessDriver";
		String url = "jdbc:ucanaccess://D:\\students.mdb";
		Class.forName(driver);
		conn = DriverManager.getConnection(url);
	}

	public boolean checkUserName(String name) throws SQLException {
		String sql = "select * from user where username = ?";
		PreparedStatement stat = conn.prepareStatement(sql);
		stat.setString(1, name);
		ResultSet res = stat.executeQuery();
		boolean c = res.next();
		System.out.println(c);
		if (c) System.out.println(res.getString(1) + res.getString(2));
		return c;
	}

	public boolean login(String name, String password) throws SQLException {
		String sql = "select * from user where username = ? and password = ?";
		PreparedStatement stat = conn.prepareStatement(sql);
		stat.setString(1, name);
		stat.setString(2, password);
		ResultSet res = stat.executeQuery();
		return res.next();
	}
	
	public String findById(String id) throws SQLException{
		int stId = Integer.parseInt(id);
		String sql = "select * from student where ID = ?";
		PreparedStatement stat = conn.prepareStatement(sql);
		stat.setInt(1, stId);
		ResultSet rs = stat.executeQuery();
		String res = null;
		if (rs.next()) {
			res = rs.getString("ID") + "\t" + rs.getString("stname");
		}
		return res;	
	}
	public String findByName(String partName) throws SQLException{
		String sql = "select * from student where stname like ?";
		PreparedStatement stat = conn.prepareStatement(sql);
		stat.setString(1, "%" + partName);
		ResultSet rs = stat.executeQuery();
		String res = "";
		while (rs.next()) {
			res += rs.getString("ID") + "\t" + rs.getString("stname") + "\n";
		}
		if (res.isEmpty()) res = null;
		return res;	
	}
}
