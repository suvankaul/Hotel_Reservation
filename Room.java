import java.rmi.*;
import java.rmi.server.*;
import java.io.*;
import java.net.*;
public interface Room extends Remote
{
	public int checkAvailability(int r,int day) throws RemoteException;
	public int bookRoom(int r,int d) throws RemoteException;
	public int cancelBooking(int r,int d)throws RemoteException;
}
