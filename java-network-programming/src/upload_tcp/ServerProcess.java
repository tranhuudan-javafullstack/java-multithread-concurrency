package upload_tcp;

import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class ServerProcess extends Thread {
Socket socket;
DataInputStream dis;
DataOutputStream dos;
public ServerProcess(Socket socket) throws IOException {
	this.socket = socket;
	dis = new DataInputStream(socket.getInputStream());
	dos = new DataOutputStream(socket.getOutputStream());
	
}
@Override
	public void run() {
	try {
		System.out.println("Client connected");
		dos.writeUTF("Hello Client");
		dos.flush();
		String command = dis.readUTF();
		if (command.equalsIgnoreCase("FileCheckOK")) {
			String dFile = dis.readUTF();
			long sizeFile = dis.readLong();
			OutputStream fos = new BufferedOutputStream(new FileOutputStream(dFile));
			int byteRead = 0;
			int data;
			byte[] buff = new byte[102400];
			while (byteRead <sizeFile ) {
			data = dis.read(buff);
					fos.write(buff, 0, data);
					byteRead += data;
				
		
			}
			dos.writeUTF("download success");
			fos.close();
			socket.close();
		}else if (command.equalsIgnoreCase("FileNotFound")) {
			dos.writeUTF(command);
			socket.close();
	
		}
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}
}
