package br.com.mvcampos.drogaria.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;


import br.com.mvcampos.drogaria.domain.Fabricante;

public class FabricanteDAOTest {
	@Test
	@Ignore
	public void salvar() {
		Fabricante fabricante = new Fabricante();
		fabricante.setDescricao("TESTE FAbricante");

		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		fabricanteDAO.salvar(fabricante);

	}

	@Test
	@Ignore
	public void listar() {
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		List<Fabricante> resultado = fabricanteDAO.listar();

		System.out.println("Total de registros Encontrados: " + resultado.size());

		for (Fabricante fabricante : resultado) {
			System.out.println(fabricante.getCodigo() + " - " + fabricante.getDescricao());
		}

	}

	@Test
	@Ignore
	public void buscar() {
		Long codigo = 1L;

		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		Fabricante fabricante = fabricanteDAO.buscar(codigo);

		if (fabricante == null) {
			System.out.println("Nenhum registro encontrado.");
		} else {
			System.out.println("Registro encontrado:");
			System.out.println(fabricante.getCodigo() + " - " + fabricante.getDescricao());
		}
	}

	@Test
	@Ignore
	public void excluir() {
		Long codigo = 2L;
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		Fabricante fabricante = fabricanteDAO.buscar(codigo);
		if (fabricante == null) {
			System.out.println("Nenhum registro encontrado.");
		} else {
			fabricanteDAO.excluir(fabricante);
			System.out.println("Registro excluido com sucesso.");
		}
	}
	
	@Test
	@Ignore
	public void editar() {
		Long codigo = 1L;
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		Fabricante fabricante = fabricanteDAO.buscar(codigo);

		if (fabricante == null) {
			System.out.println("Nenhum registro encontrado.");
		} else {
			fabricante.setDescricao("Editando fabricante");
			fabricanteDAO.editar(fabricante);

			System.out.println("Registro alterado com sucesso.");
		}

	}
	
	@Test
	public void merge() {
		Fabricante fabricante = new Fabricante();
		fabricante.setDescricao("Tache");

		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		fabricanteDAO.merge(fabricante);

	}

}
