package br.pro.delfino.drogaria.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.omnifaces.util.Messages;

import br.pro.delfino.drogaria.dao.ProdutoDAO;
import br.pro.delfino.drogaria.domain.Produto;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class ProdutoBean2 implements Serializable{
	private Produto produto;
	
	public Produto getProduto() {
		return produto;
	}
	
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	//Para chamar o método quando a tela estiver sendo carregada basta criar o @PostConstruct
	@PostConstruct
	public void novo(){
		produto = new Produto();
	}
	
	public void buscar(){
		try {
			ProdutoDAO produtoDAO = new ProdutoDAO();
			Produto resultado =  produtoDAO.buscar(produto.getCodigo());
			
			if (resultado ==  null) {
				Messages.addGlobalWarn("Não foi encontrado o registro informado.");
			} else {
				produto = resultado;
			}
			
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Erro ao pesquisar pelo registro informado. Erro: "+ erro);
			erro.printStackTrace();
		}
	}
	
}
