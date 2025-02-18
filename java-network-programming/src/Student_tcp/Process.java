package Student_tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

public class Process extends Thread {
	Socket socket;
	BufferedReader netIn;
	PrintWriter netOut;
	StudentDAO studentDAO;

	public Process(Socket socket) throws IOException {
		this.socket = socket;
		netIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		netOut = new PrintWriter(socket.getOutputStream(), true);
		this.studentDAO = new StudentDAO();
	}

	@Override
	public void run() {
		String command;
		String key, value;
		boolean isLogin = false;
		String lastUser = null;

		try {
			netOut.println("Welcom Client");
			while (true) {
				try {
					command = netIn.readLine();
					StringTokenizer st = new StringTokenizer(command);
					key = st.nextToken();
					value = st.nextToken();
					if ("USER".equalsIgnoreCase(key)) {
						if (studentDAO.check(value)) {
							lastUser = value;
							netOut.println("OK Username");
						} else {
							netOut.println("Error Username");
							continue;
						}
					} else if ("PASS".equalsIgnoreCase(key)) {
						if (studentDAO.login(lastUser, value)) {
							netOut.println("OK login");
							isLogin = true;
							break;
						} else {
							netOut.println("Error pass");
						}
					} else {
						netOut.println("command no");

					}

				} catch (NoSuchElementException e) {
					netOut.println("not element");
				}
			}
			List<Student> listStudent = new ArrayList<Student>();
			while (isLogin) {
				listStudent.clear();
				try {
					command = netIn.readLine();
					StringTokenizer st1 = new StringTokenizer(command);
					key = st1.nextToken();
					value = st1.nextToken();
					if (key.equals("findByName")) {
						listStudent = studentDAO.findByName(value);
					} else if (key.equals("findByAge")) {
						listStudent = studentDAO.findByAge(Integer.parseInt(value));
						
					}else if (key.equals("findByScore")) {
						listStudent = studentDAO.findByScore(Double.parseDouble(value));
					}else {
						netOut.println("command no");
					}
					if (listStudent.isEmpty()) {
						netOut.println("No data");
						continue;
					}
					for (Student s :listStudent ) {
						netOut.println(s.toString());
					}
					
				} catch (NoSuchElementException e) {
					netOut.println("command no");
				}
			}

		} catch (IOException e) {
			// TODO: handle exception
		}
	}

}
