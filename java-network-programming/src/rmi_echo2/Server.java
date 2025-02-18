package rmi_echo2;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
public static void main(String[] args) throws RemoteException {
	Registry reg = LocateRegistry.createRegistry(2222);
	EchoIml echoIml = new EchoIml();
	reg.rebind("echo", echoIml);
	System.out.println("Server is running");
}
}
