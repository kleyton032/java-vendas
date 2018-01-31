package br.com.Vendas.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.Vendas.domain.Fornecedor;
import br.com.Vendas.util.HibernateUtil;

public class FornecedoresDAO {

	public void salvarFornecedor(Fornecedor fornecedor) {

		// iniciando a conex�o com o banco de dados!
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		// realizar transa��o para verificar se a etapa foi realizada ou n�o
		Transaction transacao = null;

		try {

			transacao = sessao.beginTransaction();// iniciando a transa��o
			sessao.save(fornecedor); // salvando dados
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
	public List<Fornecedor> listar() {
	

		Session sessao = HibernateUtil.getSessionFactory().openSession();

		List<Fornecedor> fornecedor = null;

		try {
			Query clt = sessao.getNamedQuery("Fornecedor.listar");
			fornecedor = clt.list();

		} catch (Exception e) {
			throw e;
		}

		finally {
			sessao.close();
		}

		return fornecedor;
	}

	public Fornecedor buscarPorCodigo(Long codigo) {

		Session sessao = HibernateUtil.getSessionFactory().openSession();

		Fornecedor fornecedor = null;

		try {
			Query clt = sessao.getNamedQuery("Fornecedor.buscarPorCodigo");
			clt.setLong("codigo", codigo);
			fornecedor = (Fornecedor) clt.uniqueResult();

		} catch (Exception e) {
			throw e;
		}

		finally {
			sessao.close();
		}

		return fornecedor;
	}

	public void excluirFornecedor(Fornecedor fornecedor) {

		// iniciando a conex�o com o banco de dados!
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		// realizar transa��o para verificar se a etapa foi realizada ou n�o
		Transaction transacao = null;

		try {

			transacao = sessao.beginTransaction();// iniciando a transa��o
			sessao.delete(fornecedor); // salvando dados
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
	
	
	public void editar(Fornecedor fornecedor) {

		// iniciando a conex�o com o banco de dados!
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		// realizar transa��o para verificar se a etapa foi realizada ou n�o
		Transaction transacao = null;

		try {

			transacao = sessao.beginTransaction();// iniciando a transa��o
			//Fornecedor fornecedorEditar = buscarPorCodigo(fornecedor.getCodigo());
			//fornecedorEditar.setDescricao(fornecedor.getDescricao());
			sessao.update(fornecedor); // salvando dados
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
