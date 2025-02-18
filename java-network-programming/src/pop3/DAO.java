package pop3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO {
	private Connection conn;
	public DAO() {
		String driver = "net.ucanaccess.jdbc.UcanaccessDriver";
		String url = "jdbc:ucanaccess://";
		try {
			Class.forName(driver);
			this.conn = DriverManager.getConnection(url);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public boolean checkUsername(String username) {
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement("select * from user where username =? ");
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			return rs.next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}
	public boolean login(String username, String pass) {
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement("select * from user where username =? and pass =?");
			ps.setString(1, username);
			ps.setString(2, pass);
			ResultSet rs = ps.executeQuery();
			return rs.next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return false;
		
	}

}
