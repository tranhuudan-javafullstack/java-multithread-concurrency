package upload;

import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.StringTokenizer;

public class UploadProcess extends Thread {
	Socket socket;
	DataInputStream netIn;
	DataOutputStream netOut;
	OutputStream outputStream;
	String path = "C:\\Users\\dell\\OneDrive - st.hcmuaf.edu.vn\\Desktop\\test\\test.txt";

	public UploadProcess(Socket socket) throws IOException {
		this.socket = socket;
		netIn = new DataInputStream(socket.getInputStream());
		netOut = new DataOutputStream(socket.getOutputStream());
	}

	public void run() {
		try {
			String line;
			while (true) {
				netOut.writeUTF("welcom");
				line = netIn.readUTF();
				
				if (line.equalsIgnoreCase("QUIT"))
					break;
				StringTokenizer st = new StringTokenizer(line);
				st.nextToken(" ");
				st.nextToken(" ");
				String dfile = st.nextToken(" ");
				long size = netIn.readLong();
				OutputStream fos = new BufferedOutputStream(new FileOutputStream(dfile));
				for (long i = 0; i < size; i++) {
					fos.write(netIn.read());
				}
				fos.close();
				System.out.println(netIn.readUTF());
			}
			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}