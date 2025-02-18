package rmi_echo2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.NotBoundException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
	public void runProcess() throws NotBoundException, IOException {
		Registry reg = LocateRegistry.getRegistry("127.0.0.1", 2222);
		IEcho echo = (IEcho) reg.lookup("echo");
		BufferedReader userIn = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
		String line = userIn.readLine();
			System.out.println(echo.echo(line));
			if (line.equalsIgnoreCase("QUIT")) {
				break;
			}
		}

	}
	public static void main(String[] args) throws NotBoundException, IOException {
		new Client().runProcess();
	}
}
