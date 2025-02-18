package tcp_echo;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(2222);
		System.out.println("Waiting for client");
		while (true) {
			Socket socket = server.accept();
			new Server_Process(socket).start();
			System.out.println("Client "+ socket.getInetAddress()+ "connected");
			
			
		}
	}
	
	
}
