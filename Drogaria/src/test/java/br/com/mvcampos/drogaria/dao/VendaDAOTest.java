package br.com.mvcampos.drogaria.dao;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.mvcampos.drogaria.domain.Cliente;
import br.com.mvcampos.drogaria.domain.Funcionario;
import br.com.mvcampos.drogaria.domain.Venda;

public class VendaDAOTest {

	@Test
	@Ignore
	public void salvar() {

		Long codigocliente = 1L;
		Long codigofuncionario = 1L;

		ClienteDAO clienteDAO = new ClienteDAO();
		Cliente cliente = clienteDAO.buscar(codigocliente);

		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		Funcionario funcionario = funcionarioDAO.buscar(codigofuncionario);

		Venda venda = new Venda();
		venda.setHorario(new Date());
		venda.setValorTotal(new BigDecimal("7.30"));
		venda.setCliente(cliente);
		venda.setFuncionario(funcionario);

		VendaDAO vendaDAO = new VendaDAO();

		try {

			vendaDAO.salvar(venda);
			System.out.println("Venda cadastrado com sucesso!");

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	@Test
	@Ignore
	public void listar() {
		VendaDAO vendaDAO = new VendaDAO();
		List<Venda> resultado = vendaDAO.listar();

		System.out.println("Numero de registro encontrado." + resultado.size());

		for (Venda venda : resultado) {
			System.out.println(venda.getHorario() + " - " + venda.getValorTotal() + " - "
					+ venda.getCliente().getPessoa().getNome());
		}
	}

	@Test
	@Ignore
	public void buscar() {
		Long condigovenda = 3L;

		VendaDAO vendaDAO = new VendaDAO();
		Venda venda = vendaDAO.buscar(condigovenda);

		if (venda == null) {
			System.out.println("Venda não encontrada");
		} else {
			System.out.println(venda.getHorario() + " - " + venda.getValorTotal() + " - "
					+ venda.getCliente().getPessoa().getNome());

		}

	}

	@Test
	@Ignore
	public void editar() {
		Long codigovenda = 3L;
		Long codigocliente = 1L;
		Long codigofuncionario = 1L;

		ClienteDAO clienteDAO = new ClienteDAO();
		Cliente cliente = clienteDAO.buscar(codigocliente);

		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		Funcionario funcionario = funcionarioDAO.buscar(codigofuncionario);

		VendaDAO vendaDAO = new VendaDAO();
		Venda venda = vendaDAO.buscar(codigovenda);

		if (venda == null) {
			System.out.println("Venda não encontrada.");
		} else {

			venda.setHorario(new Date());
			venda.setValorTotal(new BigDecimal("122.30"));
			venda.setCliente(cliente);
			venda.setFuncionario(funcionario);

			try {
				vendaDAO.editar(venda);
				System.out.println("Venda alterada com sucesso.");
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e);
			}

		}

	}
	
	@Test
	@Ignore
	public void excluir(){
		Long codigovenda = 3l;
		
		VendaDAO vendaDAO = new VendaDAO();
		Venda venda = vendaDAO.buscar(codigovenda);
		
		if (venda == null) {
			System.out.println("Venda não encontrada.");
		} else {
			
			try {
				vendaDAO.excluir(venda);
				System.out.println("Venda excluida com sucesso.");
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e);
			}
			
		}
	}

}
