package upload;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.StringTokenizer;

public class Client {
	public static void main(String[] args) throws UnknownHostException, IOException {
//	Socket socket = new Socket("127.0.0.1", 2000);
//	String path = "C:\\Users\\TIEN\\Desktop\\test.txt";
		String ip = "127.0.0.1";
		int port = 2000;
		Socket socket = new Socket(ip, port);
		DataOutputStream netOut = new DataOutputStream(socket.getOutputStream());
		BufferedReader userIn = new BufferedReader(new InputStreamReader(System.in));
		DataInputStream netIn = new DataInputStream(socket.getInputStream());
		String line;
		while (true) {
			System.out.println(netIn.readUTF());
			line = userIn.readLine();
			netOut.writeUTF(line);
			netOut.flush();
			if (line.equalsIgnoreCase("QUIT")) {
				break;
			}
			StringTokenizer st = new StringTokenizer(line);
			st.nextToken(" ");
			String sfile = st.nextToken();
			File file = new File(sfile);
			netOut.writeLong(file.length());
			InputStream fis = new FileInputStream(file);

			byte[] data = new byte[102400];
			int byteread;
			while ((byteread = fis.read(data)) != -1)
				netOut.write(data, 0, byteread);
			netOut.flush();
			fis.close();
			netOut.writeUTF("done");
		}
		socket.close();

	}
}