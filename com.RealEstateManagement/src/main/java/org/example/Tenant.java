package org.example;
import jakarta.persistence.*;

import java.util.Scanner;

@Entity
public class Tenant {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "id_ten_seq")
    @SequenceGenerator(name="id_ten_seq",initialValue = 5000,allocationSize = 1)
    private long id;

    @Column(name="tenant_name")
    private String name;

    @Column(name="phone_number")
    private long phone_no;

    @Column(name="Adhaar_no")
    private long adhaar_no;

   @Column
   private long owned_property=0;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getOwned_property() {
        return owned_property;
    }

    public void setOwned_property(long owned_property) {
        this.owned_property = owned_property;
    }

    public long getPhone_no() {
        return phone_no;
    }

    public void setPhone_no(long phone_no) {
        this.phone_no = phone_no;
    }

    public long getAdhaar_no() {
        return adhaar_no;
    }

    public void setAdhaar_no(long adhaar_no) {
        this.adhaar_no = adhaar_no;
    }

    @Override
    public String toString() {
        return "    Tenant_id: " + id +
                "   name: " + name  +
                "   phone_no: " + phone_no +
                "   adhaar_no: " + adhaar_no ;
    }
    public void getData()
    {
        System.out.println("----------ENTER THE INFORMATION----------");
        Scanner sc=new Scanner(System.in);
        System.out.println("Name:");
        setName(sc.next());
        System.out.println("Phone No:");
        setPhone_no(sc.nextLong());
        System.out.println("Adhaar_Card No:");
        setAdhaar_no(sc.nextLong());
    }
}
