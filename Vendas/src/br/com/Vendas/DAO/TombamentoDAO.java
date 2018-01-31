package br.com.Vendas.DAO;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import br.com.Vendas.domain.Tombamento;
import br.com.Vendas.util.HibernateUtil;


public class TombamentoDAO {
	
	
	public void salvarTombamento(Tombamento tombamento) {
		
		// iniciando a conex�o com o banco de dados!
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		// realizar transa��o para verificar se a etapa foi realizada ou n�o
		Transaction transacao = null;

		try {

			transacao = sessao.beginTransaction();// iniciando a transa��o
			sessao.save(tombamento); // salvando dados
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

	@SuppressWarnings("unchecked")
	public List<Tombamento> listar() {

		Session sessao = HibernateUtil.getSessionFactory().openSession();

		List<Tombamento> tombamento = null;

		try {
			Query clt = sessao.getNamedQuery("Tombamento.listar");
			tombamento = clt.list();

		} catch (Exception e) {
			throw e;
		}

		finally {
			sessao.close();
		}

		return tombamento;
	}

	public Tombamento buscarPorCodigo(Long codigo) {

		Session sessao = HibernateUtil.getSessionFactory().openSession();

		Tombamento tombamento = null;

		try {
			Query clt = sessao.getNamedQuery("Tombamento.buscarPorCodigo");
			clt.setLong("codigo", codigo);
			tombamento = (Tombamento) clt.uniqueResult();

		} catch (Exception e) {
			throw e;
		}

		finally {
			sessao.close();
		}

		return tombamento;
	}

	public void excluirTombamento(Tombamento tombamento) {

		// iniciando a conex�o com o banco de dados!
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		// realizar transa��o para verificar se a etapa foi realizada ou n�o
		Transaction transacao = null;

		try {

			transacao = sessao.beginTransaction();// iniciando a transa��o
			sessao.delete(tombamento); // salvando dados
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
	
	
	public void editar(Tombamento tombamento) {

		// iniciando a conex�o com o banco de dados!
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		// realizar transa��o para verificar se a etapa foi realizada ou n�o
		Transaction transacao = null;

		try {

			transacao = sessao.beginTransaction();// iniciando a transa��o
			sessao.update(tombamento); // salvando dados
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
