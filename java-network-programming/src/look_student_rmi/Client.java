package look_student_rmi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.NotBoundException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Client {
	public static void main(String[] args) throws NotBoundException, IOException {
		Registry reg = LocateRegistry.getRegistry("127.0.0.1", 3333);
		IFind iFind = (IFind) reg.lookup("find");
		List<Student> students = new ArrayList<Student>();

		BufferedReader userIn = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			System.out.println("Welcome Client");
			String command = userIn.readLine();
			if (command.equalsIgnoreCase("QUIT"))
				break;
			StringTokenizer st = new StringTokenizer(command);

			if (st.countTokens() != 2) {
				System.out.println("Sai cu phap");
			} else {
				String action = st.nextToken();
				String value = st.nextToken();
				if (action.equalsIgnoreCase("findByName")) {
					students = iFind.findByName(value);
					printResult(students);
				} else if (action.equalsIgnoreCase("findByAge")) {
					students = iFind.fineByAge(Integer.parseInt(value));
					printResult(students);
				} else if (action.equalsIgnoreCase("findByScore")) {
					students = iFind.fineByScore(Double.parseDouble(value));
					printResult(students);
				}
			}

		}

	}

	public static void printResult(List<Student> students) {
		if (students.isEmpty())
			System.out.println("Khong tim thay sinh vien");
		for (Student s : students) {
			System.out.println(s.toString());
		}
	}
}
