package search_student_tcp;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
public static void main(String[] args) throws IOException {
	ServerSocket server = new ServerSocket(2222);
	System.out.println("Welcom Client");
	while (true) {
		Socket socket = server.accept();
		new ServerProcess(socket).start();
	}
}

}
