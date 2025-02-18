package search_student_rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface ISearch extends Remote {
	 boolean checkUsername(String username) throws RemoteException;
	boolean login(String name, String pass)throws RemoteException;
	List<Student> searchByName(String name) throws RemoteException;
	List<Student> searchByAge(int age) throws RemoteException;
	List<Student> searchById(int id) throws RemoteException;
	

}
