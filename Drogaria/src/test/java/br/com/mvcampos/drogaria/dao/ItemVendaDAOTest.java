package br.com.mvcampos.drogaria.dao;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.mvcampos.drogaria.domain.ItemVenda;
import br.com.mvcampos.drogaria.domain.Produto;
import br.com.mvcampos.drogaria.domain.Venda;

public class ItemVendaDAOTest {

	@Test
	@Ignore
	public void salvar() {

		Long codigo = 1L;
		ProdutoDAO produtoDAO = new ProdutoDAO();
		Produto produto = produtoDAO.buscar(codigo);

		Long condigovenda = 3L;
		VendaDAO vendaDAO = new VendaDAO();
		Venda venda = vendaDAO.buscar(condigovenda);

		ItemVenda itemvenda = new ItemVenda();
		itemvenda.setQuantidade(new Short("2"));
		itemvenda.setValorParcial(new BigDecimal("2.10"));

		itemvenda.setProduto(produto);
		itemvenda.setVenda(venda);

		ItemVendaDAO itemvendaDAO = new ItemVendaDAO();

		try {
			itemvendaDAO.salvar(itemvenda);
			System.out.println("Item venda registrada com sucesso");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}

	}

	@Test
	@Ignore
	public void listar() {
		ItemVendaDAO itemvendaDAO = new ItemVendaDAO();
		List<ItemVenda> resultado = itemvendaDAO.listar();

		System.out.println("Numero de registro encontrado." + resultado.size());

		for (ItemVenda itemvenda : resultado) {
			System.out.println(itemvenda.getQuantidade() + " - " + itemvenda.getCodigo());
		}
	}

	@Test
	@Ignore
	public void buscar() {
		ItemVendaDAO itemvendaDAO = new ItemVendaDAO();
		ItemVenda itemvenda = itemvendaDAO.buscar(1l);

		if (itemvenda == null) {
			System.out.println("Nenhum registro encontrado");
		} else {
			System.out.println(itemvenda.getQuantidade() + " - " + itemvenda.getCodigo());
		}
	}

	@Test
	@Ignore
	public void editar() {

		ItemVendaDAO itemvendaDAO = new ItemVendaDAO();
		ItemVenda itemvenda = itemvendaDAO.buscar(1l);

		if (itemvenda == null) {
			System.out.println("Nenhum registro encontrado");
		} else {

			Long codigo = 1L;
			ProdutoDAO produtoDAO = new ProdutoDAO();
			Produto produto = produtoDAO.buscar(codigo);

			Long condigovenda = 3L;
			VendaDAO vendaDAO = new VendaDAO();
			Venda venda = vendaDAO.buscar(condigovenda);

			itemvenda.setQuantidade(new Short("1"));
			itemvenda.setValorParcial(new BigDecimal("552.10"));
			itemvenda.setProduto(produto);
			itemvenda.setVenda(venda);

			itemvendaDAO.editar(itemvenda);

			System.out.println("Alterado com sucesso");
		}

	}
	
	@Test
	@Ignore
	public void excluir(){
		
		ItemVendaDAO itemvendaDAO = new ItemVendaDAO();
		ItemVenda itemvenda = itemvendaDAO.buscar(1l);

		if (itemvenda == null) {
			System.out.println("Nenhum registro encontrado");
		} else {
			
			itemvendaDAO.excluir(itemvenda);
			System.out.println("Venda excluida com sucesso.");
		}
		
	}
}
