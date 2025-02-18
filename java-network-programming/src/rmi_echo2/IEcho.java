package rmi_echo2;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IEcho extends Remote {
	String echo(String e) throws RemoteException;
}
