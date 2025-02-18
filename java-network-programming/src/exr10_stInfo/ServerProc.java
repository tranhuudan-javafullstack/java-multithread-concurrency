package exr10_stInfo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ServerProc extends Thread {
	Socket socket;
	PrintWriter netOut;
	BufferedReader netIn;
	Dao  dao;
	
	public ServerProc(Socket socket) throws IOException {
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
			List<Student> res = new ArrayList<Student>();
			while (isLogin) {
				res.clear();
				line = netIn.readLine();
				if (line==null ||"QUIT".equalsIgnoreCase(line)) break;
				StringTokenizer st = new StringTokenizer(line);
				com = st.nextToken().toUpperCase();
				param = st.nextToken();
				switch(com) {
				case "FINDBYID":
					res = dao.findById(param);
					response = makeResponse(res);
					break;
				case "FINDBYNAME":
					param = line.substring(com.length()).trim();
					res = dao.findByName(param);
					response = makeResponse(res);
					break;
				default:
					response = "Lenh khong hop le";
					break;
			}
			netOut.println(response);
				
			}
			netOut.println("Service is closed");
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private String makeResponse(List<Student> res) {
		if (res.isEmpty()) {
			return "Khong tim thay";
		}
		String s = "";
		for(Student st: res) s  += st;
		return s;
	}

}
