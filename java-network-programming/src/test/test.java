package test;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;

public class test {
	 public static void main(String[] args) {
	 String[] hostNames = {"www.hcmuaf.edu.vn"};
	 for (int i = 0; i< hostNames.length; i++){
	 try {
	 Socket theSocket = new Socket(hostNames[i], 80);
	 System.out.println("Connected to "+ theSocket.getInetAddress( )
	 + " on port " + theSocket.getPort( )  +  " from port "
	 + theSocket.getLocalPort( ) + " of " +  
	theSocket.getLocalAddress( ));
	 }
	 catch (UnknownHostException e) {
	 System.err.println("I can't find " + hostNames[i]);
	 }
	 catch (SocketException e) {
	 System.err.println("Could not connect to " + hostNames[i]);
	 }
	 catch (IOException e) {
	 System.err.println(e);
	 }
	 }}}