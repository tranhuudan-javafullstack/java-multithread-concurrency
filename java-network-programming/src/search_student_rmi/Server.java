package search_student_rmi;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
	public static void main(String[] args) throws RemoteException, ClassNotFoundException {
		Registry reg = LocateRegistry.createRegistry(1111);
		DAO dao = new DAO();
		reg.rebind("search", dao);
		System.out.println("server is running");
	}
}
