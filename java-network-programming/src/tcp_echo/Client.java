package tcp_echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
BufferedReader userIn;
BufferedReader netIn;
PrintWriter netOut;
Socket socket;
	public Client() throws UnknownHostException, IOException {
		socket = new Socket("localhost", 2222);
		netIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		netOut = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
	}
public void main_Process() throws IOException {
	String greeting = netIn.readLine();
	System.out.println(greeting);
	while (true) {
		userIn = new BufferedReader(new InputStreamReader(System.in));
		String command = userIn.readLine();
		netOut.println(command);
		netOut.flush();
		String respone = netIn.readLine();
		System.out.println(respone);
		if (respone.equalsIgnoreCase("Bye Client")) {
			netIn.close();
			netOut.close();
			userIn.close();
			break;
		}
	}
	
}
public static void main(String[] args) throws UnknownHostException, IOException {
	new Client().main_Process();
}
}
