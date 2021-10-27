package com.dbs.hibernate.HIbernateDemo;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.CriteriaQuery;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import com.dbs.hibernate.HIbernateDemo.model.Customer;
import com.dbs.hibernate.HIbernateDemo.model.Invoices;
import com.dbs.hibernate.HIbernateDemo.model.Product;

public class AppInvoices 
{
	private  static SessionFactory factory = HibConfig.getSessionFactory();
    public static void main( String[] args )
    {
    	Product p1 = new Product(1, "Pencil", 50.0) ;
    	Product p2 = new Product(2, "Eraser", 30.0) ;
    	Product p3 = new Product(3, "Ruler", 20.0) ;
    	Product p4 = new Product(4, "Bag", 550.0) ;
    	Invoices iv1 = new Invoices("I001", "Shalini", LocalDate.of(2021, 02, 02), p1, 2, 100);
    	Invoices iv2 = new Invoices("I002", "Pratyusha", LocalDate.of(2021, 05, 10), p1, 4, 200);
    	Invoices iv3 = new Invoices("I003", "Sheetal", LocalDate.of(2021, 10, 12), p2, 3, 90);
    	
    	
//    	Session session = factory.openSession();
//    	Transaction tx = session.beginTransaction();
////    	session.save(p1);
////    	session.save(p2);
////    	session.save(p3);
////    	session.save(p4);
//    	session.save(iv1);
//    	session.save(iv2);
//    	session.save(iv3);
//    	tx.commit();
//    	session.close();
    	
    	
    }
    
   
    
    
}
