package org.example;
import jakarta.persistence.*;
import jakarta.persistence.Entity;

import java.util.Scanner;

@Entity

public class Landlord {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "id_seq")
    @SequenceGenerator(name = "id_seq",initialValue = 1000,allocationSize =1)
    private  long id;

    @Column(name="LandLord_name")
    private  String name=null;

    @Column(name="Land_address")
    private  String address=null;

    @Column(name="Land_sqft")
    private  double sqft;

    @Column(name="Land_price")
    private   double price;

    @Column
     private String is_available="no";

    public String getIs_available() {
        return is_available;
    }

    public void setIs_available(String is_available) {
        this.is_available = is_available;
    }

    public  long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public  String getName() {
        return name;
    }

    public  void setName(String name) {
        this.name = name;
    }

    public  String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getSqft() {
        return sqft;
    }

    public void setSqft(double sqft) {
        this.sqft = sqft;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "    Land_id: " + id + " Owner: " + name + " Address: " + address + "  Sqft: " + sqft + "  Price: " + price;
    }


    public void getData()
    {
        System.out.println("----------ENTER THE INFORMATION----------");
        Scanner sc=new Scanner(System.in);
        System.out.println("Name:");
        setName(sc.next());
        System.out.println("Address(Land To Be Sold):");
        setAddress(sc.next());
        System.out.println("Price Of Land:");
        setPrice(sc.nextDouble());
        System.out.println("Land In Sqft:");
        setSqft(sc.nextDouble());


    }
}
