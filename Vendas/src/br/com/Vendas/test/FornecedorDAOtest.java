package br.com.Vendas.test;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.Vendas.DAO.FornecedoresDAO;
import br.com.Vendas.domain.Fornecedor;

public class FornecedorDAOtest {

	@Test
	@Ignore
	public void salvar() {

		Fornecedor f = new Fornecedor();
		Fornecedor f2 = new Fornecedor();
		Fornecedor f3 = new Fornecedor();
		f.setDescricao("Kleyton João");
		f2.setDescricao("Jose Alves");
		f3.setDescricao("Paulo Ramos");
		FornecedoresDAO dao = new FornecedoresDAO();
		dao.salvarFornecedor(f);
		dao.salvarFornecedor(f2);
		dao.salvarFornecedor(f3);

	}

	@Test
	@Ignore
	public void listar() {

		FornecedoresDAO dao = new FornecedoresDAO();

		List<Fornecedor> fornecedores = dao.listar();

		for (Fornecedor fornecedor : fornecedores) {
			System.out.println(fornecedor);
		}
	}

	@Test
	@Ignore
	public void buscarPorCodigo() {

		FornecedoresDAO dao = new FornecedoresDAO();

		Fornecedor forn = dao.buscarPorCodigo(2L);

		System.out.println(forn);

	}

	@Test
	@Ignore
	public void excluir() {

		FornecedoresDAO dao = new FornecedoresDAO();
		Fornecedor fornecedor = dao.buscarPorCodigo(6L); // buscar algum para poder excluir
		// se o meu fornecedor for diferente de nulo, excluir!

		dao.excluirFornecedor(fornecedor);

	}

	@Test
	@Ignore
	public void editar() {

		FornecedoresDAO dao = new FornecedoresDAO();
		Fornecedor fornecedor = dao.buscarPorCodigo(7L);
		fornecedor.setDescricao("Mirela Santos");
		dao.editar(fornecedor);
	}

}
