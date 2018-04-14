import java.rmi.*;
import java.io.*;
import java.util.*;
import java.net.*;
public class RoomImp extends java.rmi.server.UnicastRemoteObject implements Room
{
	public RoomImp() throws RemoteException
	{
		super();
	} 
	public static int[] room={1,2,3,4,5,6,7,8,9,10};//roomno
	//availablity
	public static int[][] avail=new int[10][7];
	public static int[] cap={2,2,3,4,5,7,6,4,4,2}; //capacity
	public static int[] price={2500,4500,3000,3500,4000,7000,2500,3000,4000,5000};//price
	public static int[] time={5,2,4,3,4,2,7,6,4,1};//availability for days
	public static int len = 10,i,j;
	/*for(i=0;i<10;i++)
	{
		for(j=0;j<7;j++)
		{
			avail[i][j]=0;
		}
	}*/

	public int checkAvailability(int r,int day) throws RemoteException
	{
		if(avail[r-1][day-1]==0)
			return 1;
		else 
			return 0;
	}
	public int bookRoom(int r,int d) throws RemoteException
	{
		avail[r-1][d-1]=1;
		return 1;
	}
	public int cancelBooking(int r,int d)throws RemoteException
	{
		avail[r-1][d-1]=0;
		return 1;
	}
}
