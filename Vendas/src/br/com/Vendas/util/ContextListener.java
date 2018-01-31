package br.com.Vendas.util;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

// classe para carregamento mais rápido do projeto junto com Hibernate
public class ContextListener implements ServletContextListener{
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		HibernateUtil.getSessionFactory().close();
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		HibernateUtil.getSessionFactory().openSession();
		
	}

}
