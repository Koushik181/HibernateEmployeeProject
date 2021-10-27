package com.dbs.hibernate.HIbernateDemo;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import com.dbs.hibernate.HIbernateDemo.model.Customer;

public class App 
{
	private  static SessionFactory factory = HibConfig.getSessionFactory();
    public static void main( String[] args )
    {
    	
    	Customer c1 = new Customer("Shalini", "Mumbai", "shalini@gmail.com", "Passport", 83789237, false);
		Customer c2 = new Customer("Chandana", "Pune", "chandana@gmail.com", "Aadhar", 9898998, true);
		Customer c3 = new Customer("Gautham", "Hyderabad", "gautham@gmail.com", "License", 19998908, false);
		Customer c4 = new Customer("Raghu", "Hyderabad", "Raghu@gmail.com", "License", 19998908, false);
		Customer c5 = new Customer("Rachita", "Pune", "Rachita@gmail.com", "License", 19998908, false);
//		List<Customer> list = Arrays.asList(c1,c2,c3);
//		insertCustomer(list);
		// transient instance => new
		Customer c6 = new Customer("Susmitha", "Pune", "susmitha@gmail.com", "License", 19998908, false);
		//List<Customer> list = Arrays.asList(c6);
		// persistent instance
		//insertCustomer(list);
		// c6 => detached instance
//		c6.setCustomerAddress("Hyderabad");
		//deleteCustomer(c6);
		//loadCustomerById(c1.getCustomerEmailId());
		//getCustomersByCity("Pune");
		
	//	getCustomerUsingCriteria();
    }
    
    public static void getCustomerUsingCriteria()
    {
    	Session session = factory.openSession();
    	// Create CriteriaBuilder
    	//CriteriaBuilder builder = session.getCriteriaBuilder();

    	// Create CriteriaQuery
    	//CriteriaQuery<Customer> criteria = builder.createQuery(Customer.class);
    	Criteria c =session.createCriteria(Customer.class);
    	c.add(Restrictions.gt("annualIncome",10000000.0));//salary is the propertyname  
    	List<Customer> list=c.list();
    	for(Customer c1:list)
    		System.out.println(c1);
    	session.close();
    }
    
    public static void getCustomers()
    {
    	Session session = factory.openSession();
    	// HQL => hibernate query language
    	List<Customer> customers = session.createQuery("from Customer").list();
    	session.close();
    	for(Customer c:customers)
    		System.out.println(c);
    }
    public static void getCustomersByCity(String city)
    {
    	Session session = factory.openSession();
    	// HQL => hibernate query language
    	Query query = session.createQuery("from Customer where customerAddress=:city");
    	query.setParameter("city", city);
    	List<Customer> customers = query.list();
    	session.close();
    	for(Customer c:customers)
    		System.out.println(c);
    }
    
    public static void getCustomerById(String email)
    {
    	Session session = factory.openSession();
    	Customer customer = session.get(Customer.class, email);
    	session.close();
    	System.out.println(customer);
    }
    /**
     * get=> returns an object if exists or null
     * It does eager fetching => means it actually hits the dba nd retrievs the records
     * 
     * load => returns a proxy or instance depending upon if you just wasnt to associate the instance with the primary
     * key then it returns proxy else if you ask for any other property of the instance the instance is returned
     * it throws ObjectNotFoundException if an entiry deos not exist
     * 
     * 
     * select name from customer where id = ''
     */
    public static void loadCustomerById(String email)
    {
    	// 1st level cache=> customer
    	// 2nd level cache => sessionfactory
    	Session session = factory.openSession();
    	Customer customer = session.load(Customer.class, email);
    	//System.out.println(customer.getCustomerEmailId());
    	//System.out.println(customer.getClass().getName());
    	System.out.println(customer.getCustomerName());
    	session.close();
    	System.out.println();
    	Session session1 = factory.openSession();
    	Customer customer1 = session1.load(Customer.class, email);
    	//System.out.println(customer.getCustomerEmailId());
    	//System.out.println(customer.getClass().getName());
    	System.out.println(customer1.getCustomerName());
    	session1.close();
    	//System.out.println(customer.getClass().getName());
    	//System.out.println(customer.getCustomerName());
    	
    }
    public static void insertCustomer(List<Customer> customers)
    {
    	Session session = factory.openSession();
    	Transaction tx = session.beginTransaction();
    	try {
    	for (Customer c : customers)
    		System.out.println("saving .....  "+session.save(c));
    	tx.commit();
    	}catch (Exception e) {
			System.out.println("error "+e.getMessage());
		}
    	
    	session.close();
    }
    public static void updateCustomer(Customer customer)
    {
    	Session session = factory.openSession();
    	Transaction tx = session.beginTransaction();
    	session.update(customer);
    	tx.commit();
    	session.close();
    }
    public static void deleteCustomer(Customer customers)
    {
    	Session session = factory.openSession();
    	Transaction tx = session.beginTransaction();
    	session.delete(customers);
    	tx.commit();
    	session.close();
    }
    
}
