/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.railwayreservationsystem;

/**
 *
 * @author ELCOT
 */
import java.util.*;
public class RailwayreservationSystem {
    public static void bookTicket(Passenger p)
    {
        TicketBooker booker=new TicketBooker();
        if(TicketBooker.availabaewaitinglist==0)
        { System.out.println("no tickets availabale");
            return;
        }
        if(p.berthPreference.equals("L")&&TicketBooker.availabaleLowerberth>0||
                p.berthPreference.equals("M")&&TicketBooker.availableMiddleBerth>0||
                p.berthPreference.equals("U")&&TicketBooker.availabaeUpperberth>0)
        { System.out.println("prfered berth avaialable");
            if(p.berthPreference.equals("L"))
            {
                 System.out.println("Lower berth Given");
                 booker.bookTicket(p, TicketBooker.lowerBerthPositions.get(0), "L");
                 TicketBooker.lowerBerthPositions.remove(0);
                 TicketBooker.availabaleLowerberth--;
            }
            else if(p.berthPreference.equals("M"))
            {System.out.println("Middle berth Given");
            booker.bookTicket(p, TicketBooker.middleBerthPositions.get(0), "M");
            TicketBooker.middleBerthPositions.remove(0);
            TicketBooker.availableMiddleBerth--;
                
            }
             else if(p.berthPreference.equals("U"))
            {System.out.println("Upper berth Given");
            booker.bookTicket(p, TicketBooker.upperberthPositions.get(0), "U");
            TicketBooker.upperberthPositions.remove(0);
            TicketBooker.availabaeUpperberth--;
                
            }}
else if(TicketBooker.availabaleLowerberth>0)
{
    System.out.println("Lower berth Given");
    booker.bookTicket(p, TicketBooker.lowerBerthPositions.get(0), "L");
    
     TicketBooker.lowerBerthPositions.remove(0);
     TicketBooker.availabaleLowerberth--;

        }
else if(TicketBooker.availabaeUpperberth>0)
{
    System.out.println("Upper berth Given");
    booker.bookTicket(p,TicketBooker.upperberthPositions.get(0),"U");
    TicketBooker.upperberthPositions.remove(0);
    TicketBooker.availabaeUpperberth--;
}
        else if(TicketBooker.availableMiddleBerth>0)
{
    System.out.println("Middle berth Given");
    booker.bookTicket(p,TicketBooker.middleBerthPositions.get(0),"M");
    TicketBooker.middleBerthPositions.remove(0);
    TicketBooker.availableMiddleBerth--;
}
        else if(TicketBooker.availableraclist>0)
        { System.out.println("RAC Availabale");
        booker.addToRac(p,(TicketBooker.racpositions.get(0)),"RAC");
        
            
        }
        else if(TicketBooker.availabaewaitinglist>0)
        {
            System.out.println("Added to waitingList");
            booker.addToWaitingList(p,(TicketBooker.waitinglistpositions.get(0)),"WL");
        }
    }
    public static void cancelTicket(int id)
    {
        TicketBooker booker=new TicketBooker();
        if(!TicketBooker.passengers.containsKey(id))
        {
            System.out.println("Passenger detail unknown");
        }
        else{
            booker.cancelTicket(id);
        }
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
        Scanner sc=new Scanner(System.in);
        boolean loop=true;
        while(loop)
        {
            System.out.println("1.book ticket\n2.cancel ticket\n3.available ticket\n4.booked ticket\n5.exit");
            int choice=sc.nextInt();
            switch(choice)
            {
                case 1:
                {
                    System.out.println("enter name,age berth(L,M,U)");
                     sc.nextLine();
                    String name=sc.nextLine();
                    int age=sc.nextInt();
                     sc.nextLine();
                    String berth=sc.next();
                    Passenger p=new Passenger(name,age,berth);
                    bookTicket(p);
                }
                break;
                case 2:
                {
                    System.out.println("Enter PassengerId");
                    int id=sc.nextInt();
                    cancelTicket(id);
                }
                break;
                 case 3:
                {
                    TicketBooker booker = new TicketBooker();
                    booker.printAvailable();
                }
                break;
                //occupied tickets print
                case 4:
                {
                    TicketBooker booker = new TicketBooker();
                    booker.printPassengers();
                }
                break;
                //exit
                case 5:
                {
                    loop = false;
                }
                break;
                default:
                break;
            }
        }
    }
}
