import java.rmi.*;
import java.rmi.server.*;
import java.io.*;
import java.net.*;
import java.util.*;
import java.rmi.Naming;

class RoomBookingClient
{
  public static int[] room={1,2,3,4,5,6,7,8,9,10};//roomno
  //availablity
  public static int[][] avail=new int[10][7];
  public static int[] cap={2,2,3,4,5,7,6,4,4,2}; //capacity
  public static int[] price={2500,4500,3000,3500,4000,7000,2500,3000,4000,5000};//price
  public static int[] time={5,2,4,3,4,2,7,6,4,1};//availability for days
  public static int len = 10,i,j;
  public static void displayRoom() throws RemoteException
  {
    System.out.println("Room Information:");
    for(i=0;i<len;i++)
    {
      System.out.print("Room:"+room[i]+" ");
      System.out.print("Capacity:"+cap[i]+" People"+" ");
      System.out.print("Price:"+price[i]+" ");
      System.out.print("Available for:"+time[i]+" days");
      System.out.println();
    }
  }
  public static void confirmBooking(int r) throws RemoteException
  {
    System.out.println("Room:"+room[r-1]);
    System.out.println("Availability:Yes");
    System.out.println("Capacity:"+cap[r-1]+" People");
    System.out.println("Price:"+price[r-1]);
    System.out.println("Available for:"+time[r-1]+" days");
  }
  public static void main(String args[])
  {
    int ch,b,d,a;
    String day,c;
    Scanner sc = new Scanner(System.in);
    try
    {
      Room r = (Room)Naming.lookup("rmi://localhost:1099//roomservice");
      System.out.println("Welcome Customer !");
      while(true)
      {
        System.out.println("1.View Rooms\n2.Book Room\n3.Cancel Booking\nEnter your choice:");
        ch = sc.nextInt();
        switch(ch)
        {
          case 1: System.out.println("Our Available Rooms:");
                  displayRoom();
                  break;
          case 2: System.out.println("Welcome to Room Booking:");
                  displayRoom();
                  System.out.println("Enter the room to book and the day for booking:");
                  b = sc.nextInt();
                  day = sc.next();
                  if(day.equalsIgnoreCase("monday"))
                    d=1;
                  else if(day.equalsIgnoreCase("tuesday"))
                    d=2;
                  else if(day.equalsIgnoreCase("wednesday"))
                    d=3;
                  else if(day.equalsIgnoreCase("thursday"))
                    d=4;
                  else if(day.equalsIgnoreCase("friday"))
                    d=5;
                  else if(day.equalsIgnoreCase("saturday"))
                    d=6;
                  else
                    d=7;
                  a = r.checkAvailability(b,d);
                  if(a==1)
                  {
                    System.out.println("Room Available!!");
                    System.out.println("Do you want to Confirm Booking (y or n)?");
                    c= sc.next();
                    if(c.equalsIgnoreCase("y"))
                    {
                      System.out.println("Details of Room to be booked:");
                      confirmBooking(b);
                      int res = r.bookRoom(b,d);
                      if(res==1)
                      {
                        System.out.println("Room Booked !");
                      }
                      else
                      {
                        System.out.println("Try Again !");
                      }
                    }
                    else
                    {
                      System.out.println("Booking Cancelled !");
                    }
                  }
                  else
                  {
                    System.out.println("Room not available!! Please select another room!");
                  }
                  break;
          case 3: System.out.println("Enter the room and the day for which you want to cancel booking:");
                  b = sc.nextInt();
                  day = sc.next();
                  if(day.equalsIgnoreCase("monday"))
                    d=1;
                  else if(day.equalsIgnoreCase("tuesday"))
                    d=2;
                  else if(day.equalsIgnoreCase("wednesday"))
                    d=3;
                  else if(day.equalsIgnoreCase("thursday"))
                    d=4;
                  else if(day.equalsIgnoreCase("friday"))
                    d=5;
                  else if(day.equalsIgnoreCase("saturday"))
                    d=6;
                  else
                    d=7;
                  System.out.println("Details of Room to be cancelled:");
                  confirmBooking(b);
                  System.out.println("Do you want to Cancel Booking (y or n)?");
                  c= sc.next();
                  if(c.equalsIgnoreCase("y"))
                  {
                    int res = r.cancelBooking(b,d);
                    if(res==1)
                    {
                      System.out.println("Booking Cancelled !");
                    }
                    else
                    {
                      System.out.println("Try Again !");
                    }
                  }
                  else
                  {
                    System.out.println("Booking not Cancelled !");
                  }
                  break;
          default: System.out.println("Enter valid choice !");
        }
      } 

    }
    catch(Exception e)
    {
      System.out.println(e);
    }
  }
}
