package br.com.Vendas.DAO;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import br.com.Vendas.domain.Venda;
import br.com.Vendas.util.HibernateUtil;

public class VendasDAO {

	public Long salvarVenda(Venda venda) {

		// iniciando a conex�o com o banco de dados!
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		// realizar transa��o para verificar se a etapa foi realizada ou n�o
		Transaction transacao = null;
		Long codigo = null;
		try {

			transacao = sessao.beginTransaction();// iniciando a transa��o
			codigo = (Long) sessao.save(venda); // salvando dados
			transacao.commit(); // confirmando a transa��o

			// conforme documenta��o do Hibernate usa o RuntimaException dentro do catch
		} catch (RuntimeException e) { // caso gere algum erro e a transa��o seja diferente de nulo desfaz a transa��o
			if (transacao != null) {
				transacao.rollback();// desfazendo a transa��o e mantendo os dados
			}

		} finally {
			sessao.close();// fechar minha sess�o independente se fez ou n�o a transa��o
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

		// iniciando a conex�o com o banco de dados!
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		// realizar transa��o para verificar se a etapa foi realizada ou n�o
		Transaction transacao = null;

		try {

			transacao = sessao.beginTransaction();// iniciando a transa��o
			sessao.delete(venda); // salvando dados
			transacao.commit(); // confirmando a transa��o

			// conforme documenta��o do Hibernate usa o RuntimaException dentro do catch
		} catch (RuntimeException e) { // caso gere algum erro e a transa��o seja diferente de nulo desfaz a transa��o
			if (transacao != null) {
				transacao.rollback();// desfazendo a transa��o e mantendo os dados
			}

		} finally {
			sessao.close();// fechar minha sess�o independente se fez ou n�o a transa��o
		}

	}

	public void editarVenda(Venda venda) {

		// iniciando a conex�o com o banco de dados!
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		// realizar transa��o para verificar se a etapa foi realizada ou n�o
		Transaction transacao = null;

		try {

			transacao = sessao.beginTransaction();// iniciando a transa��o
			sessao.update(venda); // salvando dados
			transacao.commit(); // confirmando a transa��o

			// conforme documenta��o do Hibernate usa o RuntimaException dentro do catch
		} catch (RuntimeException e) { // caso gere algum erro e a transa��o seja diferente de nulo desfaz a transa��o
			if (transacao != null) {
				transacao.rollback();// desfazendo a transa��o e mantendo os dados
			}

		} finally {
			sessao.close();// fechar minha sess�o independente se fez ou n�o a transa��o
		}

	}

}
