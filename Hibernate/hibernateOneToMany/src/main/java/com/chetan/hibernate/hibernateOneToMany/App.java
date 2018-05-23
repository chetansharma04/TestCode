package com.chetan.hibernate.hibernateOneToMany;

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
    	
    	Laptop laptop2 = new Laptop();
    	laptop2.setId(102);
    	laptop2.setName("HP");
    	laptop2.setStudent(student);
    	
    	List<Laptop> laptopList = new ArrayList<Laptop>();
    	laptopList.add(laptop);
    	laptopList.add(laptop2);
    	student.setLaptopList(laptopList);
    	
    	Configuration configuration = new Configuration();
    	configuration.configure().addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class);
    	ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
    	SessionFactory sf = configuration.buildSessionFactory(serviceRegistry);
    	Session session = sf.openSession();
    	Transaction tx = session.beginTransaction();

    	session.save(laptop);
    	session.save(laptop2);
    	session.save(student);
    	
    	tx.commit();
    	
    	
    	
    	
    	session.close();
    }
}
