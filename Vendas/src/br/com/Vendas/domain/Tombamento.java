package br.com.Vendas.domain;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "tb_tombamentos")
@NamedQueries({ @NamedQuery(name = "Tombamento.listar", query = "SELECT tombamento FROM Tombamento tombamento"),
@NamedQuery(name = "Tombamento.buscarPorCodigo", query = "SELECT tombamento FROM Tombamento tombamento WHERE tombamento.codigo = :codigo") })


public class Tombamento {

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	@Column(name = "tom_codigo")
	private Long codigo;

	@NotEmpty(message="Favor insira uma descrição")
	@Column(name = "tom_descricao", length = 50, nullable = false)
	private String descricao;

	@Column(name = "preco_unidade", nullable = false, scale = 2, precision = 7)
	private BigDecimal precounidade;

	@Column(name = "tom_alocacao", length = 50, nullable = false)
	private String alocacao;

	@Column(name = "tom_data", length = 50, nullable = false)
	private String data;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getPrecounidade() {
		return precounidade;
	}

	public void setPrecounidade(BigDecimal precounidade) {
		this.precounidade = precounidade;
	}

	public String getAlocacao() {
		return alocacao;
	}

	public void setAlocacao(String alocacao) {
		this.alocacao = alocacao;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Tombamento [codigo=" + codigo + ", descrição=" + descricao + ", preco_unidade=" + precounidade
				+ ", alocacaao=" + alocacao + ", data=" + data + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tombamento other = (Tombamento) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	
	

}
