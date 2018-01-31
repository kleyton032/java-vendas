package br.com.Vendas.test;

import org.junit.Ignore;
import org.junit.Test;

import br.com.Vendas.util.HibernateUtil;

public class GerarTabelaTeste {
	
	@Test
	@Ignore
	public void GerarTabela() {
		HibernateUtil.getSessionFactory();
		HibernateUtil.getSessionFactory().close();
	}

}
