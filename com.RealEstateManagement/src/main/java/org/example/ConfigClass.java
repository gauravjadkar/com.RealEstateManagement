package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.hibernate.cfg.Configuration;

import javax.naming.ConfigurationException;


public class ConfigClass {
    public static EntityManagerFactory config() {
        try {
           // Configuration configuration=new Configuration();
            //configuration.addAnnotatedClass(Landlord.class);
            EntityManagerFactory emf= Persistence.createEntityManagerFactory("rempersistence");
          //  EntityManager entity=emf.createEntityManager();

            return emf;

        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }


    }


}
