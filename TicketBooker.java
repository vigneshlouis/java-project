/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.railwayreservationsystem;

/**
 *
 * @author ELCOT
 */
import java.util.*;
public class TicketBooker {
    static int availabaleLowerberth=1;
    static int availableMiddleBerth=1;
    static int availabaeUpperberth=1;
    static int availabaewaitinglist=1;
    static int availableraclist=1;
    static Queue<Integer>waitinglist=new LinkedList<>();
    static Queue<Integer>raclist=new LinkedList<>();
    static List<Integer>bookedlist=new ArrayList<>();
   static List<Integer>lowerBerthPositions=new ArrayList<>(Arrays.asList(1));
   static List<Integer>middleBerthPositions=new ArrayList<>(Arrays.asList(1));
   static List<Integer>upperberthPositions=new ArrayList<>(Arrays.asList(1));
   static List<Integer>racpositions=new ArrayList<>(Arrays.asList(1));
   static List<Integer>waitinglistpositions=new ArrayList<>(Arrays.asList(1));
   static Map<Integer,Passenger>passengers=new HashMap<>();
   public void bookTicket(Passenger p,int berthInfo,String allotedBerth)
   {
       p.number=berthInfo;
       p.alloted=allotedBerth;
       passengers.put(p.passengerId,p);
       bookedlist.add(p.passengerId);
        System.out.println("Booked Succesfully");
   }
   public void addToRac(Passenger p,int racinfo,String allottedRac)
   {
       p.number=racinfo;
       p.alloted=allottedRac;
       passengers.put(p.passengerId,p);
       raclist.add(p.passengerId);
       availableraclist--;
       racpositions.remove(0);
       System.out.println("-------------------Added to RAC Successfully");
       
   }
   public void addToWaitingList(Passenger p,int waitinglistinfo,String allotedWl)
   {
       p.number=waitinglistinfo;
       p.alloted=allotedWl;
       passengers.put(p.passengerId, p);
       waitinglist.add(p.passengerId);
       waitinglistpositions.remove(0);
       availabaewaitinglist--;
       System.out.println("--------------Added to waiting list Succesfully");
   }
   public void cancelTicket(int id)
   {
       Passenger p=passengers.get(id);
       passengers.remove(Integer.valueOf(id));
       bookedlist.remove(Integer.valueOf(id));
       int bookedPostion=p.number;
       System.out.println("--------------cancelled Successfully");  
       if(p.alloted.equals("L"))
       {
           availabaleLowerberth++;
           lowerBerthPositions.add(bookedPostion);
           
       }
       else if(p.alloted.equals("M"))
       {
           availableMiddleBerth++;
           middleBerthPositions.add(bookedPostion);
           
       }
              else if(p.alloted.equals("U"))
       {
           availabaeUpperberth++;
           upperberthPositions.add(bookedPostion);
           
       }
       if(raclist.size()>0)
       {
           Passenger passengerfromRac=passengers.get(raclist.poll());
           int positionsRac=passengerfromRac.number;
           racpositions.add(positionsRac);
           raclist.remove(Integer.valueOf(passengerfromRac.passengerId));
           availableraclist++;
           
       
        if(waitinglist.size()>0)
            {
                //take the passenger from WL and add them to RAC , increase the free space in waiting list and 
                //increase available WL and decrease available RAC by 1
                Passenger passengerFromWaitingList = passengers.get(waitinglist.poll());
                int positionWL = passengerFromWaitingList.number;
                waitinglistpositions.add(positionWL);
                waitinglist.remove(Integer.valueOf(passengerFromWaitingList.passengerId));

                passengerFromWaitingList.number = racpositions.get(0);
                passengerFromWaitingList.alloted = "RAC";
                racpositions.remove(0);
                raclist.add(passengerFromWaitingList.passengerId);
                
                availabaewaitinglist++;
                 availableraclist--;
            }
            // now we have a passenger from RAc to whom we can book a ticket, 
            //so book the cancelled ticket to the RAC passenger
             RailwayreservationSystem.bookTicket( passengerfromRac);
       }
   }
    public void printAvailable()
    {
        System.out.println("Available Lower Berths "  +availabaleLowerberth);
        System.out.println("Available Middle Berths "  + availableMiddleBerth);
        System.out.println("Available Upper Berths "  + availabaeUpperberth);
        System.out.println("Availabel RACs " + availableraclist);
        System.out.println("Available Waiting List " + availabaewaitinglist);
        System.out.println("--------------------------");
    }
     public void printPassengers()
    {
        if(passengers.size() == 0)
        {
            System.out.println("No details of passengers");
            return;
        }
        for(Passenger p : passengers.values())
        {
            System.out.println("PASSENGER ID " + p.passengerId );
            System.out.println(" Name " + p.name );
            System.out.println(" Age " + p.age );
            System.out.println(" Status " + p.number + p.alloted);
            System.out.println("--------------------------");
        }
    }
    
}
