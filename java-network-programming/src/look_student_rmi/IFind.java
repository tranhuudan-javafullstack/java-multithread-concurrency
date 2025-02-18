package look_student_rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public interface IFind extends Remote{
	List<Student> findByName(String name) throws RemoteException;
	List<Student> fineByAge(int age) throws RemoteException;
	List<Student> fineByScore(double score) throws RemoteException;
}
