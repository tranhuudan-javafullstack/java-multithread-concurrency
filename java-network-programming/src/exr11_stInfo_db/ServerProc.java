package exr11_stInfo_db;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.SQLException;
import java.util.StringTokenizer;

public class ServerProc extends Thread {
	Socket socket;
	PrintWriter netOut;
	BufferedReader netIn;
	Dao  dao;
	
	public ServerProc(Socket socket) throws IOException, ClassNotFoundException, SQLException {
		this.socket = socket;
		netOut = new PrintWriter(socket.getOutputStream(),true);
		netIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		this.dao = new Dao();
	}

	public void run() {
		boolean isLogin = false;
		String com, param, response;
		String lastUserName = null;
		try {
			netOut.println("Ready...");
			String line;
			response = "";
			//login
			while(!isLogin) {
				line = netIn.readLine();
				if (line==null ||"QUIT".equalsIgnoreCase(line)) break;
				StringTokenizer st = new StringTokenizer(line);
				com = st.nextToken().toUpperCase();
				param = st.nextToken();
				switch(com) {
				case "USER":
					if (dao.checkUserName(param)){
						response = "Ok";
						lastUserName = param;
					} else {
						response = "Error invalid username";
					}
					break;
				case "PASS":
					if (lastUserName==null) {
						response = "Error: username first";
						break;
					} else {
						if (dao.login(lastUserName, param)){ //ok
							response = " Ok Login";
							isLogin = true;
						} else {
							response = "Error: invalid password";
						}
					}
					break;
				default:
						response = "Lenh khong hop le";
						break;
				}
				netOut.println(response);
			}
			//find
			String rs ;
			while (isLogin) {
				line = netIn.readLine();
				if (line==null ||"QUIT".equalsIgnoreCase(line)) break;
				StringTokenizer st = new StringTokenizer(line);
				com = st.nextToken().toUpperCase();
				param = st.nextToken();
				switch(com) {
				case "FINDBYID":
					rs =  dao.findById(param);
					if (rs==null) response = "Khong tim thay";
					else response = rs;

					break;
				case "FINDBYNAME":
					param = line.substring(com.length()).trim();
					rs = dao.findByName(param);
					if (rs==null) response = "Khong tim thay";
					else response = rs;
					break;
				default:
					response = "Lenh khong hop le";
					break;
			}
			netOut.println(response);
				
			}
			netOut.println("Service is closed");
			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
