package com.chetan.hibernate.hibernateEmbeddable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

//using session.flush()
public class App {
    public static void main( String[] args )    {
    	
    	Alien alien = new Alien();
    	alien.setColor("Green");
    	alien.setId(11);

    	//using embeddable pojo
    	PersonName personName = new PersonName();
    	personName.setfName("Mukesh");
    	personName.setmName("Chander");
    	personName.setlName("Sharma");
    	alien.setName(personName);
    	
    	//using embeddable pojo
    	
    	Employee employee = new Employee();
    	employee.setDesignation("Manager");
    	employee.setId(100);
    	PersonName personName2 = new PersonName();
    	personName2.setfName("Mukesh");
    	personName2.setmName("Chander");
    	personName2.setlName("Sharma");
    	employee.setName(personName2);
    	
    	Configuration configuration = new Configuration();
    	configuration.configure().addAnnotatedClass(Alien.class);
    	configuration.configure().addAnnotatedClass(Employee.class);
    	
    	ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
    	SessionFactory sf = configuration.buildSessionFactory(serviceRegistry);
    	Session session = sf.openSession();
    	Transaction tx = session.beginTransaction();

    	session.save(alien);
    	session.save(employee);
    	tx.commit();
    	session.close();
    	
    	
    }
}
