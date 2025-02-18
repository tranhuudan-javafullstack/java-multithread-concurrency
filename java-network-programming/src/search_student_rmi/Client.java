package search_student_rmi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Client {
	public static void main(String[] args) throws RemoteException, NotBoundException {
		Registry reg = LocateRegistry.getRegistry("127.0.0.1", 1111);
		ISearch dao = (ISearch) reg.lookup("search");

		BufferedReader netIn = new BufferedReader(new InputStreamReader(System.in));
		String command = null;
		String action, value;
		String username = null;
		boolean isLogin = false;

		while (true) {

			try {
				if (isLogin) {
					break;
				}
				command = netIn.readLine();
				if (command.equalsIgnoreCase("QUIT"))
					break;
				StringTokenizer st = new StringTokenizer(command);
				if (st.countTokens() != 2)
					System.out.println("sai cu phap");
				action = st.nextToken().toUpperCase();
				value = st.nextToken();
				System.out.println(action);
				System.out.println(value);
				switch (action) {
				case "USER":
					if (dao.checkUsername(value)) {
						System.out.println("OK Username");
						username = value;
						continue;
					} else {
						System.out.println("ERROR Usename");
					}

					break;
				case "PASS":
					if (dao.login(username, value)) {
						System.out.println("OK pass");
						isLogin = true;
						break;
					} else {
						System.out.println("ERROR pass");
					}

					break;
				default:
					break;
				}

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		List<Student> students = new ArrayList<Student>();
		while (isLogin) {
			try {
				command = netIn.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (command.equalsIgnoreCase("QUIT"))
				break;
			StringTokenizer st = new StringTokenizer(command);
			if (st.countTokens() != 2)
				System.out.println("sai cu phap");
			action = st.nextToken().toUpperCase();
			value = st.nextToken();
			System.out.println(action);
			switch (action) {
			case "FIND_ID":
				students = dao.searchById(Integer.parseInt(value));
				Print(students);
				break;
			case "FIND_NAME":
				students = dao.searchByName(value);
				Print(students);
				break;
			case "FIND_AGE":
				students = dao.searchByAge(Integer.parseInt(value));
				Print(students);
				break;

			default:
				break;
			}
		}

	}

	public static void Print(List<Student> students) {
		if (students.isEmpty())
			System.out.println("No data");
		for (Student s : students) {
			System.out.println(s.toString());
		}
	}

}
