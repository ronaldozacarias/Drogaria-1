package br.pro.delfino.drogaria.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SuppressWarnings("serial")
@Entity
public class Funcionario extends GenericDomain{
	@OneToOne
	@JoinColumn(name = "codPessoa", nullable = false, foreignKey = @ForeignKey(name = "FK_FuncionarioXPessoa"))
	private Pessoa pessoa;
	
	@Column(nullable = false, columnDefinition = "character varying (1) default 'S' ")
	private Character ativo;
	
	@Column(length = 15, nullable = false)
	private String carteiraTrabalho;
	
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dataAdmissao;

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Character getAtivo() {
		return ativo;
	}

	public void setAtivo(Character ativo) {
		this.ativo = ativo;
	}

	public String getCarteiraTrabalho() {
		return carteiraTrabalho;
	}

	public void setCarteiraTrabalho(String carteiraTrabalho) {
		this.carteiraTrabalho = carteiraTrabalho;
	}

	public Date getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(Date dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}
}
