package com.chetan.hibernate.hibernate1;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class App {
    public static void main( String[] args )    {
    	Alien alien = new Alien();
    	alien.setId("1");
    	alien.setName("aaaaa");
    	alien.setColor("Green");
    	
    	Configuration configuration = new Configuration().configure().addAnnotatedClass(Alien.class);
    	ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
    	SessionFactory sf = configuration.buildSessionFactory(serviceRegistry);
    	Session session = sf.openSession();
    	Transaction tx = session.beginTransaction();
    	
    	Serializable serializable = session.save(alien);
    	tx.commit();// at this point data will be persisted into DB
    	System.out.println("serializable = "+serializable);

    	session.close();
    	sf.close();
    }
}
