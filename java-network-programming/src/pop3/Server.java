package pop3;

import java.io.IOException;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
public static void main(String[] args) throws IOException {
	ServerSocket server = new ServerSocket();
	
	while (true) {
		Socket socket = server.accept();
		
	}		
}
}
