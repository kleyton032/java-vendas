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

		// iniciando a conexão com o banco de dados!
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		// realizar transação para verificar se a etapa foi realizada ou não
		Transaction transacao = null;

		try {

			transacao = sessao.beginTransaction();// iniciando a transação
			sessao.save(funcionario); // salvando dados
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

		// iniciando a conexão com o banco de dados!
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		// realizar transação para verificar se a etapa foi realizada ou não
		Transaction transacao = null;

		try {

			transacao = sessao.beginTransaction();// iniciando a transação
			sessao.delete(funcionario); // salvando dados
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
	
	
	public void editar(Funcionario funcionario) {

		// iniciando a conexão com o banco de dados!
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		// realizar transação para verificar se a etapa foi realizada ou não
		Transaction transacao = null;

		try {

			transacao = sessao.beginTransaction();// iniciando a transação
			sessao.update(funcionario); // salvando dados
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
