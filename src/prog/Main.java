package prog;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class Main {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Configuration configuration = new Configuration();
        configuration.configure();

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        SessionFactory sf = configuration.buildSessionFactory(serviceRegistry);
        try {
	        Developer d1 = new Developer("Sergey", new Contact("Pirogova 9", "0503555999", "info@prog.kiev.ua"));
	        Developer d2 = new Developer("Petr", new Contact("Other street 1", "0441234567", "info@test.com"));
	        
	        Project p1 = new Project("Project A");
	        Project p2 = new Project("Project B");
	        Project p3 = new Project("Project C");
	        
	        d1.add(p1);
	        d1.add(p2);
	        d2.add(p3);
	        
	        Session session = sf.openSession();
	        Transaction transaction = null;
	        try {
	        	transaction = session.beginTransaction();
	        	try {
	        		session.save(d1);
	        		session.save(d2);
	        		transaction.commit();
	        	} catch (HibernateException ex) {
	        		transaction.rollback();
	        		ex.printStackTrace();
	        	}
	        	
	        	try {
	        		List<Developer> list = session.createCriteria(Developer.class).list();
	        		for (Developer d : list)
	        			System.out.println(d);
	        	} catch (HibernateException ex) {
	        		ex.printStackTrace();
	        	}
	        } finally {
	        	session.close();
	        }
        } finally {
        	sf.close();
        }
	}

}
