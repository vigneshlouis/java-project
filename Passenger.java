/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.railwayreservationsystem;

/**
 *
 * @author ELCOT
 */
public class Passenger {
    static int id=1;
    String name;
    int age;
    String berthPreference;
    int passengerId;
    String alloted;
    int number;
    public Passenger(String name,int age,String berthPreference)
    {
        this.name=name;
        this.age=age;
        this.berthPreference=berthPreference;
        this.passengerId=id++;
        alloted="";
        number=-1;
        
    }
    
    
}
