package org.example;

//import java.lang.module.Configuration;
import jakarta.persistence.*;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

       Landlord l=new Landlord();
        Tenant t=new Tenant();
        int choice;
        long id = 0;
        Scanner sc=new Scanner(System.in);
        EntityManager entity=ConfigClass.config().createEntityManager();

        System.out.println("Welcome To,\n REAL_ESTATE Management");
        System.out.println("------------------------------------------------------");
        do {
            System.out.println("Press Corresponding Values:\n1.Sign up\n2.Sign in");
            choice=sc.nextInt();

            if(choice==1)
            {
                System.out.println("Please Provide Sign up Choice :\n1.As Tenant\n2.As Landlord");
                int ch= sc.nextInt();
                if(ch==1)
                {
                    EntityTransaction transaction = entity.getTransaction();
                    t.getData();
                    transaction.begin();
                    entity.persist(t);
                    transaction.commit();
                    Tenant t1=entity.find(Tenant.class,t.getId());
                    id=t1.getId();
                    System.out.println("Here's your registered id 1"+id);
                    System.out.println("Thank You!");

                }
                else if(ch==2)
                {
                    EntityTransaction transaction =entity.getTransaction();
                    l.getData();
                    transaction.begin();
                    entity.persist(l);
                    transaction.commit();
                    Landlord l1=entity.find(Landlord.class,l.getId());
                    id=l1.getId();
                    System.out.println("Here's your registered id "+id);
                    System.out.println("Thank You!");


                }
                break;
            }
            else if(choice==2)
            {
                System.out.println("Enter Your Id:");
                id=sc.nextInt();
                break;
            }
            else
            {
                System.out.println("Please Enter the Valid choice");
            }
        }while(true);

        do {
            System.out.println("---------Menu-----------");
            System.out.println("1.Profile");
            System.out.println("2.Booking");
            System.out.println("3.Exit");
            System.out.println("Enter the Corresponding Values:");
            choice= sc.nextInt();
            switch(choice)
            {
                case 1: if((entity.find(Landlord.class,id))!=null)
                {
                    l=entity.find(Landlord.class,id);
                    System.out.println(l);
                }
                else if((entity.find(Tenant.class,id))!=null)
                {
                    t=entity.find(Tenant.class,id);
                    System.out.println(t);
                }
                else{
                    System.out.println("Your Id doesn't Exist");
                }
                break;
                case 2:
                    System.out.println("-------Booking-----------");
                    //EntityManager entity=ConfigClass.config().createEntityManager();
                    TypedQuery<Landlord> query = entity.createQuery("SELECT e FROM Landlord e where e.is_available= :is_available", Landlord.class);
                    query.setParameter("is_available","no");
                    List<Landlord> l3=query.getResultList();
                    for(Landlord l4:l3) {
                        System.out.println(l4);
                    }
                    System.out.println("For Booking  press ->1\nFor Exit press ->3");
                    choice=sc.nextInt();
                    if(choice==1) {
                        EntityTransaction transaction = entity.getTransaction();
                        transaction.begin();
                        System.out.println("Enter the Correspnding Id of Land:");
                        long land_id = sc.nextLong();
                        if ((entity.find(Landlord.class, land_id)) != null) {
                            l=(entity.find(Landlord.class, land_id));
                            l.setId(land_id);
                            l.setIs_available("yes");
                           transaction.commit();

                            transaction.begin();
                            t.setId(id);
                            t.setOwned_property(land_id);
                            entity.merge(t);
                            transaction.commit();
                            System.out.println("Booked SuccessFully");
                            //  System.out.println("For Further Info Contact:"+);
                        }
                        else {
                            System.out.println("Please Enter Only Above Land ID.!");
                        }
                    }
                    break;
                case 3:break;
                default:
                    System.out.println("Please Enter the Valid choice");
            }
        }while(choice!=3);







    }
}