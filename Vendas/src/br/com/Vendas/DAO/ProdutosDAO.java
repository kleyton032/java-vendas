package br.com.Vendas.DAO;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import br.com.Vendas.domain.Produto;
import br.com.Vendas.util.HibernateUtil;

public class ProdutosDAO {
	
	
	public void salvarProduto(Produto produto) {

		// iniciando a conexão com o banco de dados!
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		// realizar transação para verificar se a etapa foi realizada ou não
		Transaction transacao = null;

		try {

			transacao = sessao.beginTransaction();// iniciando a transação
			sessao.save(produto); // salvando dados
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
	public List<Produto> listar() {

		Session sessao = HibernateUtil.getSessionFactory().openSession();

		List<Produto> produto = null;

		try {
			Query clt = sessao.getNamedQuery("Produto.listar");
			produto = clt.list();

		} catch (Exception e) {
			throw e;
		}

		finally {
			sessao.close();
		}

		return produto;
	}

	
	public Produto buscarPorCodigo(Long codigo) {

		Session sessao = HibernateUtil.getSessionFactory().openSession();

		Produto produto = null;

		try {
			Query clt = sessao.getNamedQuery("Produto.buscarPorCodigo");
			clt.setLong("codigo", codigo);
			produto = (Produto) clt.uniqueResult();

		} catch (Exception e) {
			throw e;
		}

		finally {
			sessao.close();
		}

		return produto;
	}
	
	
	public void excluirProduto(Produto produto) {

		// iniciando a conexão com o banco de dados!
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		// realizar transação para verificar se a etapa foi realizada ou não
		Transaction transacao = null;

		try {

			transacao = sessao.beginTransaction();// iniciando a transação
			sessao.delete(produto); // salvando dados
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
	
	public void editar(Produto produto) {

		// iniciando a conexão com o banco de dados!
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		// realizar transação para verificar se a etapa foi realizada ou não
		Transaction transacao = null;

		try {

			transacao = sessao.beginTransaction();// iniciando a transação
			sessao.update(produto); // salvando dados
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
