package br.com.Vendas.DAO;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import br.com.Vendas.domain.Item;
import br.com.Vendas.util.HibernateUtil;

public class ItensDAO {

	public void salvarItem(Item item) {

		// iniciando a conexão com o banco de dados!
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		// realizar transação para verificar se a etapa foi realizada ou não
		Transaction transacao = null;

		try {

			transacao = sessao.beginTransaction();// iniciando a transação
			sessao.save(item); // salvando dados
			transacao.commit(); // confirmando a transação

			// conforme documentação do Hibernate usa o RuntimaException dentro do catch
		} catch (RuntimeException e) { // caso gere algum erro e a transação seja diferente de nulo desfaz a transação
			if (transacao != null) {
				transacao.rollback();// desfazendo a transação e mantendo os dados
			}

		} finally {
			sessao.close();// fechar minha sessão independente se fez ou não a transação
		}

	}

	@SuppressWarnings("unchecked")
	public List<Item> listar() {

		Session sessao = HibernateUtil.getSessionFactory().openSession();

		List<Item> item = null;

		try {
			Query clt = sessao.getNamedQuery("Item.listar");
			item = clt.list();

		} catch (Exception e) {
			throw e;
		}

		finally {
			sessao.close();
		}

		return item;
	}

	public Item buscarPorCodigo(Long codigo) {

		Session sessao = HibernateUtil.getSessionFactory().openSession();

		Item item = null;

		try {
			Query clt = sessao.getNamedQuery("Item.buscarPorCodigo");
			clt.setLong("codigo", codigo);
			item = (Item) clt.uniqueResult();

		} catch (Exception e) {
			throw e;
		}

		finally {
			sessao.close();
		}

		return item;
	}

	public void excluirItem(Item item) {

		// iniciando a conexão com o banco de dados!
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		// realizar transação para verificar se a etapa foi realizada ou não
		Transaction transacao = null;

		try {

			transacao = sessao.beginTransaction();// iniciando a transação
			sessao.delete(item); // salvando dados
			transacao.commit(); // confirmando a transação

			// conforme documentação do Hibernate usa o RuntimaException dentro do catch
		} catch (RuntimeException e) { // caso gere algum erro e a transação seja diferente de nulo desfaz a transação
			if (transacao != null) {
				transacao.rollback();// desfazendo a transação e mantendo os dados
			}

		} finally {
			sessao.close();// fechar minha sessão independente se fez ou não a transação
		}

	}

	public void editarItem(Item item) {

		// iniciando a conexão com o banco de dados!
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		// realizar transação para verificar se a etapa foi realizada ou não
		Transaction transacao = null;

		try {

			transacao = sessao.beginTransaction();// iniciando a transação
			sessao.update(item); // salvando dados
			transacao.commit(); // confirmando a transação

			// conforme documentação do Hibernate usa o RuntimaException dentro do catch
		} catch (RuntimeException e) { // caso gere algum erro e a transação seja diferente de nulo desfaz a transação
			if (transacao != null) {
				transacao.rollback();// desfazendo a transação e mantendo os dados
			}

		} finally {
			sessao.close();// fechar minha sessão independente se fez ou não a transação
		}

	}

}
