package search_student_tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

public class ServerProcess extends Thread {
	Socket socket;
	BufferedReader netIn;
	PrintWriter netOut;

	public ServerProcess(Socket socket) throws IOException {
		this.socket = socket;
		netIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		netOut = new PrintWriter(socket.getOutputStream(), true);
		netOut.println("Welcom Client");

	}

	@Override
	public void run() {
		String command;
		String action, value = null;
		List<Student> listStudent = new ArrayList<Student>();
		try {
			while (true) {

				command = netIn.readLine();

				if (command.equalsIgnoreCase("EXIT")) {
					break;
				}
				StringTokenizer st = new StringTokenizer(command);

				action = st.nextToken();
				try {
					value = st.nextToken();

					if (action.equalsIgnoreCase("findByName")) {
						listStudent = StudentDAO.findByName(value);
					} else if (action.equalsIgnoreCase("findByAge")) {
						listStudent = StudentDAO.findByAge(Integer.parseInt(value));
					} else if (action.equalsIgnoreCase("findByScore")) {
						listStudent = StudentDAO.findByScore(Double.parseDouble(value));
					} else {
						netOut.println("Invalid action");
						continue;
					}

					netOut.println(listStudent.size());
					for (Student s : listStudent) {
						netOut.println(s.toString());
					}
				} catch (NoSuchElementException e) {
					if (!(action.equals("findByName") || action.equals("findByAge") || action.equals("findByScore"))) {
						netOut.println("Missing action");
					} else {
						netOut.println("Missing value");
					}
				} catch (NumberFormatException e) {
					netOut.println("Invalid numeric value");
				}

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
