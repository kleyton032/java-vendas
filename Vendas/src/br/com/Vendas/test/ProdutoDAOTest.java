package br.com.Vendas.test;

import java.math.BigDecimal;
import java.util.List;
import org.junit.Ignore;
import org.junit.Test;
import br.com.Vendas.DAO.FornecedoresDAO;
import br.com.Vendas.DAO.ProdutosDAO;
import br.com.Vendas.domain.Fornecedor;
import br.com.Vendas.domain.Produto;

public class ProdutoDAOTest {

	@Test
	@Ignore
	public void salvar() {

		// pesquisar nos fornecedores para o parametros da chave estrangeira
		FornecedoresDAO dao = new FornecedoresDAO();
		Fornecedor fornecedor = dao.buscarPorCodigo(7L);

		Produto f = new Produto();

		f.setDescricao("Açúcar");
		f.setPreco(new BigDecimal(2.50));
		f.setQuantidade(10);
		f.setFornecedor(fornecedor);
		ProdutosDAO prod = new ProdutosDAO();
		prod.salvarProduto(f);

	}

	@Test
	@Ignore
	public void listar() {

		ProdutosDAO dao = new ProdutosDAO();
		List<Produto> Produtos = dao.listar();
		for (Produto produto : Produtos) {
			System.out.println(produto);
		}
	}

	@Test
	@Ignore
	public void buscarPorCodigo() {

		ProdutosDAO dao = new ProdutosDAO();
		Produto prod = dao.buscarPorCodigo(2L);
		System.out.println(prod);

	}

	@Test
	@Ignore
	public void excluir() {

		ProdutosDAO dao = new ProdutosDAO();
		Produto prod = dao.buscarPorCodigo(2L); // buscar algum para poder excluir
		// se o meu fornecedor for diferente de nulo, excluir!

		dao.excluirProduto(prod);

	}

	@Test
	@Ignore
	public void editar() {

		FornecedoresDAO dao = new FornecedoresDAO();
		Fornecedor fornecedor = dao.buscarPorCodigo(9L);

		ProdutosDAO dao1 = new ProdutosDAO();
		Produto produto = dao1.buscarPorCodigo(4l);
		produto.setDescricao("Fubá");
		produto.setPreco((new BigDecimal(0.50)));
		produto.setQuantidade(4);
		produto.setFornecedor(fornecedor);
		dao1.editar(produto);
	}

}
