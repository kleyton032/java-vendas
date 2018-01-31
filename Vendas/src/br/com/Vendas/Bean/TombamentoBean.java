package br.com.Vendas.Bean;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.Vendas.DAO.TombamentoDAO;
import br.com.Vendas.domain.Tombamento;
import br.com.Vendas.util.JSFUtil;


@ManagedBean(name = "MBTombamentos")
@ViewScoped
public class TombamentoBean {

		private Tombamento tombamentos;
		private ArrayList<Tombamento> itens;
		private ArrayList<Tombamento> itensFiltrados;
		private String acao;
		private Long codigo;
		
		public Tombamento getTombamentos() {
			return tombamentos;
		}

		public void setTombamentos(Tombamento tombamentos) {
			this.tombamentos = tombamentos;
		}

		public ArrayList<Tombamento> getItens() {
			return itens;
		}

		public void setItens(ArrayList<Tombamento> itens) {
			this.itens = itens;
		}

		public ArrayList<Tombamento> getItensFiltrados() {
			return itensFiltrados;
		}

		public void setItensFiltrados(ArrayList<Tombamento> itensFiltrados) {
			this.itensFiltrados = itensFiltrados;
		}

		public String getAcao() {
			return acao;
		}

		public void setAcao(String acao) {
			this.acao = acao;
		}

		public Long getCodigo() {
			return codigo;
		}

		public void setCodigo(Long codigo) {
			this.codigo = codigo;
		}

		public void listar() {

			try {
				TombamentoDAO fdao = new TombamentoDAO();
				itens = (ArrayList<Tombamento>) fdao.listar();

			} catch (RuntimeException e) {
				JSFUtil.adicionarMensagemErro("ex.getMessage()");
				e.printStackTrace();
			}
		}

		public void carregarCadastro() {
			try {
				
				if (codigo != null) {
					TombamentoDAO fdao = new TombamentoDAO();
					tombamentos = fdao.buscarPorCodigo(codigo);
				}else {
					tombamentos = new Tombamento();

				}
					

			} catch (RuntimeException e) {
				JSFUtil.adicionarMensagemErro("ex.getMessage()");
				e.printStackTrace();
			}

		}

		public void Novo() {
			tombamentos = new Tombamento();
		}

		public void salvar() {

			try {
				TombamentoDAO fdao = new TombamentoDAO();
				fdao.salvarTombamento(tombamentos);

				JSFUtil.adicionarMensagemSucesso("Tombamento salvo com sucesso!");

			} catch (RuntimeException e) {
				JSFUtil.adicionarMensagemErro("ex.getMessage()");
				e.printStackTrace();
			}
		}

		public void excluir() {
			try {
				TombamentoDAO fdao = new TombamentoDAO();
				fdao.excluirTombamento(tombamentos);

				JSFUtil.adicionarMensagemSucesso("Tombamento excluido com sucesso!");

			} catch (RuntimeException e) {
				JSFUtil.adicionarMensagemErro("Não é possível excluir um Tombamento que tenha um produto associado!");
				e.printStackTrace();
			}
		}

		public void editar() {
			try {
				TombamentoDAO fdao = new TombamentoDAO();
				fdao.editar(tombamentos);

				JSFUtil.adicionarMensagemSucesso("Tombamento editado com sucesso!");

			} catch (RuntimeException e) {
				JSFUtil.adicionarMensagemErro("ex.getMessage()");
				e.printStackTrace();
			}
		}

	}



