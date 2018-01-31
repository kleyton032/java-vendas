package br.com.Vendas.test;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import br.com.Vendas.DAO.FuncionariosDAO;
import br.com.Vendas.domain.Funcionario;

public class FuncionarioDAOTest {

	@Test
	@Ignore
	public void salvar() {

		Funcionario f = new Funcionario();

		f.setNome("Andreza Maria");
		f.setCpf("92176548952");
		f.setSenha("124");
		f.setFuncao("Administrador");
		FuncionariosDAO dao = new FuncionariosDAO();
		dao.salvarFuncionario(f);

	}

	@Test
	@Ignore
	public void listar() {

		FuncionariosDAO dao = new FuncionariosDAO();

		List<Funcionario> funcionarios = dao.listar();

		for (Funcionario funcionario : funcionarios) {
			System.out.println(funcionario);
		}
	}

	@Test
	@Ignore
	public void excluir() {

		FuncionariosDAO dao = new FuncionariosDAO();
		Funcionario funcionario = dao.buscarPorCodigo(2L); // buscar algum para poder excluir
		// se o meu fornecedor for diferente de nulo, excluir!

		dao.excluirFuncionario(funcionario);

	}

	@Test
	@Ignore
	public void editar() {

		FuncionariosDAO dao = new FuncionariosDAO();
		Funcionario funcionario = dao.buscarPorCodigo(1L);
		funcionario.setNome("Mirela Santos");
		funcionario.setCpf("45678921456");
		funcionario.setSenha("258");
		funcionario.setFuncao("Gerente");
		dao.editar(funcionario);
	}

}
