package com.chetan.hibernate.hibernateOneToOne;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class App {
    public static void main( String[] args )    {
    	
    	Student student = new Student();
    	student.setColor("Green");
    	student.setId(11);

    	//using embeddable pojo
    	PersonName personName = new PersonName();
    	personName.setfName("Mukesh");
    	personName.setmName("Chander");
    	personName.setlName("Sharma");
    	student.setName(personName);
    	
    	//Laptop class
    	Laptop laptop = new Laptop();
    	laptop.setId(101);
    	laptop.setName("Dell");
    	laptop.setStudent(student);
    	
    	student.setLaptop(laptop);
    	
    	Configuration configuration = new Configuration();
    	configuration.configure().addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class);
    	ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
    	SessionFactory sf = configuration.buildSessionFactory(serviceRegistry);
    	Session session = sf.openSession();
    	Transaction tx = session.beginTransaction();

    	session.save(laptop);
    	session.save(student);
    	
    	tx.commit();
    	
    	
    	
    	
    	session.close();
    }
}
