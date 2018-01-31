package br.com.Vendas.test;

import java.math.BigDecimal;
import java.util.List;
import org.junit.Ignore;
import org.junit.Test;
import br.com.Vendas.DAO.ItensDAO;
import br.com.Vendas.DAO.ProdutosDAO;
import br.com.Vendas.DAO.VendasDAO;
import br.com.Vendas.domain.Item;
import br.com.Vendas.domain.Produto;
import br.com.Vendas.domain.Venda;

public class ItemDAOTest {
	@Test
	@Ignore
	public void salvar() {

		// pesquisar nos produtos para o parametros da chave estrangeira
		ProdutosDAO pdao = new ProdutosDAO();
		Produto produto = pdao.buscarPorCodigo(4L);

		// pesquisar em vendas para o parametros da chave estrangeira
		VendasDAO vdao = new VendasDAO();
		Venda vendas = vdao.buscarPorCodigo(3L);

		Item t = new Item();

		t.setQuantidade_item(7);
		t.setValor_parcial(new BigDecimal(47.68));
		t.setProduto(produto);
		t.setVenda(vendas);
		ItensDAO itens = new ItensDAO();
		itens.salvarItem(t);

	}

	@Test
	@Ignore
	public void listar() {

		ItensDAO dao = new ItensDAO();
		List<Item> item = dao.listar();
		for (Item itens : item) {
			System.out.println(itens);
		}
	}

	@Test
	@Ignore
	public void buscarPorCodigo() {

		ItensDAO dao = new ItensDAO();
		Item item = dao.buscarPorCodigo(2L);
		System.out.println(item);

	}

	@Test
	@Ignore
	public void excluir() {

		ItensDAO dao = new ItensDAO();
		Item item = dao.buscarPorCodigo(2L); // buscar algum para poder excluir
		// se o meu fornecedor for diferente de nulo, excluir!

		dao.excluirItem(item);

	}

	@Test
	@Ignore
	public void editar() {

		// pesquisar nos produtos para o parametros da chave estrangeira
		ProdutosDAO pdao = new ProdutosDAO();
		Produto produto = pdao.buscarPorCodigo(1L);

		// pesquisar em vendas para o parametros da chave estrangeira
		VendasDAO vdao = new VendasDAO();
		Venda vendas = vdao.buscarPorCodigo(1L);

		ItensDAO dao = new ItensDAO();
		Item item = dao.buscarPorCodigo(3L);
		item.setQuantidade_item(9);
		item.setValor_parcial((new BigDecimal(50.00)));
		item.setProduto(produto);
		item.setVenda(vendas);
		dao.editarItem(item);
	}

}
