import java.rmi.*;
import java.io.*;
import java.util.*;
import java.net.*;
import java.rmi.Naming;
public class RoomServer
{
	public RoomServer()
	{
		try
		{
			Room r = new RoomImp();
			Naming.rebind("rmi://localhost:1099//roomservice",r);
			System.out.println("Server Ready");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	public static void main(String args[])
	{
		RoomServer rs = new RoomServer();
	}
}
