package rmi_echo2;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


public class EchoIml extends UnicastRemoteObject implements IEcho {

	protected EchoIml() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String echo(String e) throws RemoteException {
		// TODO Auto-generated method stub
		return "server response: " + e;
	}
}
