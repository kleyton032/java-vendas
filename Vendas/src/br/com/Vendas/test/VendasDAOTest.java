package br.com.Vendas.test;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import org.junit.Ignore;
import org.junit.Test;

import br.com.Vendas.DAO.FuncionariosDAO;

import br.com.Vendas.DAO.VendasDAO;

import br.com.Vendas.domain.Funcionario;

import br.com.Vendas.domain.Venda;

public class VendasDAOTest {

	@Test
	@Ignore
	public void salvar() {

		// pesuisa funcionario para chave estrangeira da tabela
		FuncionariosDAO funcionariodao = new FuncionariosDAO();
		Funcionario funcionario = funcionariodao.buscarPorCodigo(3L);

		Venda v = new Venda();

		v.setHorario(new Date());
		v.setValor_total(new BigDecimal(25.00));
		v.setFuncionario(funcionario);
		VendasDAO vendasdao = new VendasDAO();
		vendasdao.salvarVenda(v);

	}

	@Test
	@Ignore
	public void listar() {

		VendasDAO dao = new VendasDAO();
		List<Venda> venda = dao.listar();

		System.out.println(venda);

	}

	@Test
	@Ignore
	public void buscarPorCodigo() {

		VendasDAO dao = new VendasDAO();
		Venda venda = dao.buscarPorCodigo(2L);
		System.out.println(venda);

	}

	@Test
	@Ignore
	public void excluir() {

		VendasDAO dao = new VendasDAO();
		Venda venda = dao.buscarPorCodigo(2L);

		dao.excluirVenda(venda);

	}

	@Test
	@Ignore
	public void editar() {

		FuncionariosDAO funcionariodao = new FuncionariosDAO();
		Funcionario funcionario = funcionariodao.buscarPorCodigo(1L);

		VendasDAO dao1 = new VendasDAO();
		Venda v = dao1.buscarPorCodigo(3L);
		v.setHorario(new Date());
		v.setValor_total(new BigDecimal(5.00));
		v.setFuncionario(funcionario);
		dao1.editarVenda(v);
	}

}
