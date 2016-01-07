package br.pro.delfino.drogaria.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.pro.delfino.drogaria.domain.Fabricante;

public class FabricanteDAOTest {
	@Test
	@Ignore
	public void salvar(){
		Fabricante fabricante = new Fabricante();
		fabricante.setDescricao("farcom");
		
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		fabricanteDAO.salvar(fabricante);
	}
	
	@Test
	@Ignore
	public void listar(){
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		List<Fabricante> resultado = fabricanteDAO.listar();
		
		System.out.println("Total de Registro: "+resultado.size());
		for (Fabricante fabricante : resultado) {
			System.out.println(fabricante.getCodigo()+" - "+fabricante.getDescricao());
		}
	}

	@Test
	@Ignore
	public void buscar(){
		Long codigo = 1L;
		
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		Fabricante fabricante = fabricanteDAO.buscar(codigo);
		
		if (fabricante != null) {
			System.out.println(fabricante.getCodigo()+" - "+fabricante.getDescricao());
		} else {
			System.out.println("Registro não encontrado.");
		}
	}
	
	@Test
	@Ignore
	public void excluir(){
		Long codigo = 7L;
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		Fabricante fabricante = fabricanteDAO.buscar(codigo);
		
		if (fabricante != null) {
			fabricanteDAO.excluir(fabricante);
			System.out.println("Registro excluído com sucesso.");
		} else {
			System.out.println("Registro não encontrado para ser excluído.");
		}
	}
	
	@Test
	public void editar(){
		Long codigo = 2L;
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		Fabricante fabricante = fabricanteDAO.buscar(codigo);
		
		if (fabricante != null) {
			System.out.println("Registro alterado antes: "+fabricante.getDescricao());
			
			fabricante.setDescricao("FARCOM");
			fabricanteDAO.editar(fabricante);
			
			System.out.println("Registro atual: "+fabricante.getDescricao());
		} else {
			System.out.println("Registro não encontrado para alteração");
		}
	}
}
