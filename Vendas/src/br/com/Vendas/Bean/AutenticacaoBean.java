package br.com.Vendas.Bean;



import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;


import br.com.Vendas.DAO.FuncionariosDAO;
import br.com.Vendas.domain.Funcionario;


@ManagedBean(name = "MBAutenticacao")
@ViewScoped
public class AutenticacaoBean {

	private FuncionariosDAO fdao = new FuncionariosDAO();
	private Funcionario funcionario = new Funcionario();

	// //private Funcionario funcionario;
	// private Funcionario funcionariologado;
	//
	// public Funcionario getFuncionariologado() {
	// return funcionariologado;
	// }
	//
	// public void setFuncionariologado(Funcionario funcionariologado) {
	// this.funcionariologado = funcionariologado;
	// }
	//
	// public Funcionario getFuncionario() {
	// return funcionario;
	// }
	// public void setFuncionario(Funcionario funcionario) {
	// this.funcionario = funcionario;
	// }
	//
	// public void iniciar() {
	// funcionario = new Funcionario();
	//
	// }

	public FuncionariosDAO getFdao() {
		return fdao;
	}

	public void setFdao(FuncionariosDAO fdao) {
		this.fdao = fdao;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	

}
