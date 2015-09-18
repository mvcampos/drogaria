package br.com.mvcampos.drogaria.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.mvcampos.drogaria.domain.Cliente;
import br.com.mvcampos.drogaria.domain.Pessoa;

public class ClienteDAOTest {

	@Test
	@Ignore
	public void salvar() throws ParseException {

		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(2L);

		Cliente cliente = new Cliente();
		// cliente.setDataCadastro(new Date());
		cliente.setDataCadastro(new SimpleDateFormat("dd/MM/yyyy").parse("09/06/2015"));
		cliente.setLiberado(false);
		cliente.setPessoa(pessoa);

		ClienteDAO clienteDAO = new ClienteDAO();
		try {
			System.out.println("Cliente salvo com sucesso!");
			clienteDAO.salvar(cliente);
		} catch (Exception e) {
			System.out.println(e);
			// TODO: handle exception
		}

	}

	@Test
	@Ignore
	public void listar() {
		ClienteDAO clienteDAO = new ClienteDAO();
		List<Cliente> resultado = clienteDAO.listar();

		System.out.println("Total de registros Encontrados" + resultado.size());

		for (Cliente cliente : resultado) {
			System.out.println(
					cliente.getCodigo() + " - " + cliente.getDataCadastro() + " - " + cliente.getPessoa().getNome());
		}
	}

	@Test
	@Ignore
	public void buscar() {
		Long codigo = 2L;
		ClienteDAO clienteDAO = new ClienteDAO();
		Cliente cliente = clienteDAO.buscar(codigo);

		if (cliente == null) {
			System.out.println("Nenhum registro encontrado.");
		} else {
			System.out.println(
					cliente.getCodigo() + " - " + cliente.getDataCadastro() + " - " + cliente.getPessoa().getNome());
		}
	}

	@Test
	@Ignore
	public void editar() {

		Long codigo = 2L;
		ClienteDAO clienteDAO = new ClienteDAO();
		Cliente cliente = clienteDAO.buscar(codigo);

		Long codigopessoa = 2L;
		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(codigopessoa);

		if (pessoa == null) {
			System.out.println("Cidade não encontrada.");
		} else if (cliente == null) {
			System.out.println("Pessoa não encontrada.");
		} else {

			cliente.setLiberado(true);
			cliente.setPessoa(pessoa);
			cliente.setDataCadastro(new Date());

			clienteDAO.editar(cliente);

			System.out.println("Registro alterado com sucesso.");
		}
	}
	
	@Test
	public void excluir() {

		Long codigo = 2L;
		ClienteDAO clienteDAO = new ClienteDAO();
		Cliente cliente = clienteDAO.buscar(codigo);

		if (cliente == null) {
			System.out.println("Pessoa não encontrada.");
		} else {
			clienteDAO.excluir(cliente);

			System.out.println("Registro excluido com sucesso.");
		}

	}

}
