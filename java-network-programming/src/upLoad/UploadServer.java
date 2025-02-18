package upLoad;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class UploadServer {
	public static void main(String[] args) throws IOException {
 ServerSocket s = new ServerSocket(2000);
 while(true) {
	 Socket socket = s.accept();
	 UploadProcess up = new UploadProcess(socket);
	 up.start();
 }

}
}