package upload_tcp;

import java.io.BufferedInputStream;
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

		Socket socket = new Socket("127.0.0.1", 2222);
		DataInputStream dis = new DataInputStream(socket.getInputStream());
		DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
		String greeting = dis.readUTF();
		System.out.println(greeting);

		BufferedReader userIn = new BufferedReader(new InputStreamReader(System.in));

		String line = userIn.readLine();
		StringTokenizer st = new StringTokenizer(line);
		String request = st.nextToken();
		String sFile = st.nextToken();
		String dFile = st.nextToken();
		File fileSource = new File(sFile);
		if (!fileSource.exists()) {
			dos.writeUTF("FileNotFound");
			dos.flush();
		} else {
			dos.writeUTF("FileCheckOK");
			dos.flush();
			dos.writeUTF(dFile);
			dos.flush();
			dos.writeLong(fileSource.length());
			dos.flush();
			InputStream fis = new BufferedInputStream(new FileInputStream(sFile));
			int read;
			byte[] buff = new byte[102400];
			while ((read = fis.read(buff)) != -1)
				dos.write(buff, 0, read);
			dos.flush();
			System.out.println(dis.readUTF());
			fis.close();
			socket.close();

		}

	}
}
