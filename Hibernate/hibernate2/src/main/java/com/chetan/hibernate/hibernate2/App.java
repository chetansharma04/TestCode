package com.chetan.hibernate.hibernate2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

//using session.flush()
public class App {
    public static void main( String[] args )    {
    	
    	Alien alien = null;
    	
    	Configuration configuration = new Configuration().configure().addAnnotatedClass(Alien.class);
    	SessionFactory sf = configuration.buildSessionFactory();
    	Session session = sf.openSession();
    	Transaction tx = session.beginTransaction();
    	for ( int i=0; i<10; i++ ) {
    		System.out.println("iteration = "+i);
    		alien = new Alien();
        	alien.setId(i);
        	alien.setName("aaaaa");
        	alien.setColor("Green");
        	
    	    session.save(alien);
    	    session.clear();
    	}
    	tx.commit();
    	session.close();
    	
    	
    }
}
