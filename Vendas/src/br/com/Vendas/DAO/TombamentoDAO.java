package br.com.Vendas.DAO;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import br.com.Vendas.domain.Tombamento;
import br.com.Vendas.util.HibernateUtil;


public class TombamentoDAO {
	
	
	public void salvarTombamento(Tombamento tombamento) {
		
		// iniciando a conexão com o banco de dados!
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		// realizar transação para verificar se a etapa foi realizada ou não
		Transaction transacao = null;

		try {

			transacao = sessao.beginTransaction();// iniciando a transação
			sessao.save(tombamento); // salvando dados
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

		// iniciando a conexão com o banco de dados!
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		// realizar transação para verificar se a etapa foi realizada ou não
		Transaction transacao = null;

		try {

			transacao = sessao.beginTransaction();// iniciando a transação
			sessao.delete(tombamento); // salvando dados
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
	
	
	public void editar(Tombamento tombamento) {

		// iniciando a conexão com o banco de dados!
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		// realizar transação para verificar se a etapa foi realizada ou não
		Transaction transacao = null;

		try {

			transacao = sessao.beginTransaction();// iniciando a transação
			sessao.update(tombamento); // salvando dados
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
