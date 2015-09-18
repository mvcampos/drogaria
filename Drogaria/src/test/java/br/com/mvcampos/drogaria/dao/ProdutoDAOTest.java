package br.com.mvcampos.drogaria.dao;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.mvcampos.drogaria.domain.Fabricante;
import br.com.mvcampos.drogaria.domain.Produto;

public class ProdutoDAOTest {

	@Test
	
	public void salvar() {

		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		Fabricante fabricante = fabricanteDAO.buscar(1l);

		Produto produto = new Produto();
		produto.setDescricao("Catafrlan 50mg com 20 comprimidos");
		produto.setFabricante(fabricante);
		produto.setPreco(new BigDecimal("13.70"));
		produto.setQuantidade(new Short("7"));

		ProdutoDAO produtoDAO = new ProdutoDAO();
		produtoDAO.salvar(produto);

		System.out.println("Produto cadastrado com sucesso.");
	}

	@Test
	@Ignore
	public void listar() {
		ProdutoDAO produtoDAO = new ProdutoDAO();
		List<Produto> resultado = produtoDAO.listar();

		System.out.println("Total de registros Encontrados" + resultado.size());

		for (Produto produto : resultado) {
			System.out.println(produto.getCodigo() + " - " + produto.getDescricao() + " - " + produto.getQuantidade()
					+ " - " + produto.getPreco() + " - " + produto.getFabricante().getCodigo());
		}
	}

	@Test
	@Ignore
	public void buscar() {
		Long codigo = 1L;
		ProdutoDAO produtoDAO = new ProdutoDAO();
		Produto produto = produtoDAO.buscar(codigo);

		if (produto == null) {
			System.out.println("Nenhum registro encontrado.");
		} else {
			System.out.println("Registro encontrado:");

			System.out.println(produto.getCodigo() + " - " + produto.getDescricao() + " - " + produto.getQuantidade()
					+ " - " + produto.getPreco() + " - " + produto.getFabricante().getDescricao());

		}
	}

	@Test
	@Ignore
	public void excluir() {
		Long codigo = 7L;
		ProdutoDAO produtoDAO = new ProdutoDAO();
		Produto produto = produtoDAO.buscar(codigo);
		if (produto == null) {
			System.out.println("Nenhum registro encontrado.");
		} else {
			produtoDAO.excluir(produto);
			System.out.println("Registro excluido com sucesso.");
		}
	}

	@Test
	@Ignore
	public void editar() {
		Long codigo = 1L;
		Long codigoFabricante = 2L;

		ProdutoDAO produtoDAO = new ProdutoDAO();
		Produto produto = produtoDAO.buscar(codigo);

		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		Fabricante fabricante = fabricanteDAO.buscar(codigoFabricante);

		if (fabricante == null) {
			System.out.println("Fabricante não encontrado.");
		} else if (produto == null) {
			System.out.println("Produto não encontrada.");
		} else {
			produto.setDescricao("Celofato");
			produto.setQuantidade(new Short("3"));
			produto.setPreco(new BigDecimal("2.33"));
			produto.setFabricante(fabricante);
			

			produtoDAO.editar(produto);

			System.out.println("Registro alterado com sucesso.");
		}

	}
}
