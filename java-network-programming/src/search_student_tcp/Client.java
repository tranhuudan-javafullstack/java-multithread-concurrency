//package search_student_tcp;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.io.PrintWriter;
//import java.net.Socket;
//import java.net.UnknownHostException;
//
//public class Client {
//	public static void main(String[] args) throws UnknownHostException, IOException {
//		Socket socket = new Socket("127.0.0.1", 2222);
//		BufferedReader netIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//		BufferedReader userIn = new BufferedReader(new InputStreamReader(System.in));
//		PrintWriter netOut = new PrintWriter(socket.getOutputStream(), true);
//		String command;
//		while (true) {
//			command = userIn.readLine();
//			netOut.println(command);
//			if (command.equalsIgnoreCase("EXIT"))break;
//			
//			
//		}
//	}
//}
