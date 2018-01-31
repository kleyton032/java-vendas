package br.com.Vendas.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


public class HibernateUtil {

    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            // Cria a conexão hibernate.cfg.xml
            //return new Configuration().configure().buildSessionFactory(
			    //new StandardServiceRegistryBuilder().build() );
        	
        	Configuration configuration = new Configuration();
        	configuration.configure();
        	
        	ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
        			.applySettings(configuration.getProperties()).build();
        			
        	
        	SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        	return sessionFactory;	
        
        	
        }
        catch (Throwable ex) {
            // erro ao concetar
            System.err.println("Erro na conexão." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

}
