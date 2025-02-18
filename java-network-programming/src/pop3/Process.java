package pop3;

import java.net.Socket;

public class Process extends Thread{
	Socket socket;

	public Process(Socket socket) {
		super();
		this.socket = socket;
	}
	
}
