package coppy_file_tcp;

import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class ServerProcess extends Thread {
	DataInputStream dis;
	DataOutputStream dos;
	Socket socket;

	public ServerProcess(Socket socket) throws IOException {
		this.socket = socket;
		dis = new DataInputStream(socket.getInputStream());
		dos = new DataOutputStream(socket.getOutputStream());

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			String dFile = this.dis.readUTF();
			int error = 0;
			
				try {
					OutputStream fos = new BufferedOutputStream(new FileOutputStream(dFile)) ;
					this.dos.writeInt(error);
					this.dos.flush();
					byte[] buff = new byte[102400];
					int read;
					while ((read = this.dis.read(buff)) != -1)
						fos.write(buff, 0, read);
					
					fos.close();
					socket.close();

					System.out.println("xong coppy");
				} catch (FileNotFoundException e) {
					error = 1;
					this.dos.writeInt(error);
					this.dos.flush();
					this.socket.close();
					return;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("xong coppy 2");

	}

}
