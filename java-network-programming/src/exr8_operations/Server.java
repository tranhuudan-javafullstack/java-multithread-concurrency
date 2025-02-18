package exr8_operations;

import java.io.IOException;
import java.net.*;

public class Server {

	public static void main(String[] args) throws IOException {
		ServerSocket s = new ServerSocket(12345);
		while(true) {
			Socket socket = s.accept();
			ServerThread thread = new ServerThread(socket);
			thread.start();
		}

	}

}
