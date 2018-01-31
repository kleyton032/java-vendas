package br.com.Vendas.DAO;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import br.com.Vendas.domain.Funcionario;
import br.com.Vendas.util.HibernateUtil;

public class FuncionariosDAO {
	
	
	
	public Funcionario autenticar(String login, String senha) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		try {
			Criteria consulta = sessao.createCriteria(Funcionario.class);
			consulta.add(Restrictions.eq("cpf", login));
			consulta.add(Restrictions.eq("senha", senha));
			return (Funcionario) consulta.uniqueResult();
			
		} catch (RuntimeException erro) {
			throw erro;
		}finally {
			sessao.close();
		}
		
	}
	
	public void salvarFuncionario(Funcionario funcionario) {

		// iniciando a conex�o com o banco de dados!
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		// realizar transa��o para verificar se a etapa foi realizada ou n�o
		Transaction transacao = null;

		try {

			transacao = sessao.beginTransaction();// iniciando a transa��o
			sessao.save(funcionario); // salvando dados
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
	public List<Funcionario> listar() {

		Session sessao = HibernateUtil.getSessionFactory().openSession();

		List<Funcionario> funcionario = null;

		try {
			Query clt = sessao.getNamedQuery("Funcionario.listar");
			funcionario = clt.list();

		} catch (Exception e) {
			throw e;
		}

		finally {
			sessao.close();
		}

		return funcionario;
	}

	public Funcionario buscarPorCodigo(Long codigo) {

		Session sessao = HibernateUtil.getSessionFactory().openSession();

		Funcionario funcionario = null;

		try {
			Query clt = sessao.getNamedQuery("Funcionario.buscarPorCodigo");
			clt.setLong("codigo", codigo);
			funcionario = (Funcionario) clt.uniqueResult();

		} catch (Exception e) {
			throw e;
		}

		finally {
			sessao.close();
		}

		return funcionario;
	}

	public void excluirFuncionario(Funcionario funcionario) {

		// iniciando a conex�o com o banco de dados!
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		// realizar transa��o para verificar se a etapa foi realizada ou n�o
		Transaction transacao = null;

		try {

			transacao = sessao.beginTransaction();// iniciando a transa��o
			sessao.delete(funcionario); // salvando dados
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
	
	
	public void editar(Funcionario funcionario) {

		// iniciando a conex�o com o banco de dados!
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		// realizar transa��o para verificar se a etapa foi realizada ou n�o
		Transaction transacao = null;

		try {

			transacao = sessao.beginTransaction();// iniciando a transa��o
			sessao.update(funcionario); // salvando dados
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
