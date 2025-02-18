package tcp_echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class Server_Process extends Thread{
Socket socket;
BufferedReader netIn;
PrintWriter netOut;
public Server_Process(Socket socket) throws IOException {
	this.socket = socket;
	netIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	netOut = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
}
@Override
	public void run() {
	netOut.println("Hello Client");
	netOut.flush();
	while (true) {
		String command;
		try {
			command = netIn.readLine();
		
		if (command.equalsIgnoreCase("QUIT")) {
			netOut.println("Bye Client");
			netOut.flush();
			netIn.close();
			netOut.close();
		}else {
			netOut.println("server respone: "+ command + "echo");
			netOut.flush();
			
		}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	}
}
