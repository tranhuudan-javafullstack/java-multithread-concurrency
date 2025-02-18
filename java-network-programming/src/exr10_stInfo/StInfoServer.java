package exr10_stInfo;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class StInfoServer {

	public static void main(String[] args) throws IOException {
		ServerSocket s = new ServerSocket(54321);
		while(true) {
			Socket socket = s.accept();
			ServerProc proc = new ServerProc(socket);
			proc.start();
		}

	}

}
