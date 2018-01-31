package br.com.Vendas.DAO;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import br.com.Vendas.domain.Venda;
import br.com.Vendas.util.HibernateUtil;

public class VendasDAO {

	public Long salvarVenda(Venda venda) {

		// iniciando a conexão com o banco de dados!
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		// realizar transação para verificar se a etapa foi realizada ou não
		Transaction transacao = null;
		Long codigo = null;
		try {

			transacao = sessao.beginTransaction();// iniciando a transação
			codigo = (Long) sessao.save(venda); // salvando dados
			transacao.commit(); // confirmando a transação

			// conforme documentação do Hibernate usa o RuntimaException dentro do catch
		} catch (RuntimeException e) { // caso gere algum erro e a transação seja diferente de nulo desfaz a transação
			if (transacao != null) {
				transacao.rollback();// desfazendo a transação e mantendo os dados
			}

		} finally {
			sessao.close();// fechar minha sessão independente se fez ou não a transação
		}

		return codigo;

	}

	@SuppressWarnings("unchecked")
	public List<Venda> listar() {

		Session sessao = HibernateUtil.getSessionFactory().openSession();

		List<Venda> venda = null;

		try {
			Query clt = sessao.getNamedQuery("Venda.listar");
			venda = clt.list();

		} catch (Exception e) {
			throw e;
		}

		finally {
			sessao.close();
		}

		return venda;
	}

	public Venda buscarPorCodigo(Long codigo) {

		Session sessao = HibernateUtil.getSessionFactory().openSession();

		Venda venda = null;

		try {
			Query clt = sessao.getNamedQuery("Venda.buscarPorCodigo");
			clt.setLong("codigo", codigo);
			venda = (Venda) clt.uniqueResult();

		} catch (Exception e) {
			throw e;
		}

		finally {
			sessao.close();
		}

		return venda;
	}

	public void excluirVenda(Venda venda) {

		// iniciando a conexão com o banco de dados!
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		// realizar transação para verificar se a etapa foi realizada ou não
		Transaction transacao = null;

		try {

			transacao = sessao.beginTransaction();// iniciando a transação
			sessao.delete(venda); // salvando dados
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

	public void editarVenda(Venda venda) {

		// iniciando a conexão com o banco de dados!
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		// realizar transação para verificar se a etapa foi realizada ou não
		Transaction transacao = null;

		try {

			transacao = sessao.beginTransaction();// iniciando a transação
			sessao.update(venda); // salvando dados
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
