package look_student_rmi;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
	public static void main(String[] args) throws RemoteException {
		Registry reg = LocateRegistry.createRegistry(3333);
		StudentImpl stImpl = new StudentImpl();
		reg.rebind("find", stImpl);
		System.out.println("Server is running");
	}
}
