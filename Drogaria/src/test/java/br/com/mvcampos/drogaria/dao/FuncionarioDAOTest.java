package br.com.mvcampos.drogaria.dao;

import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.mvcampos.drogaria.domain.Funcionario;
import br.com.mvcampos.drogaria.domain.Pessoa;

public class FuncionarioDAOTest {

	@Test
	@Ignore
	public void salvar() {

		Long codigopessoa = 1l;
		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(codigopessoa);

		Funcionario funcionario = new Funcionario();
		funcionario.setCarteiraTrabalho("123545645");
		funcionario.setDataAdmissao(new Date());
		funcionario.setPessoa(pessoa);

		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

		try {

			funcionarioDAO.salvar(funcionario);
			System.out.println("Funcionário cadastrado com sucesso!");

		} catch (Exception e) {

			System.out.println(e);
		}

	}

	@Test
	@Ignore
	public void listar() {

		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		List<Funcionario> resultado = funcionarioDAO.listar();

		System.out.println("Total de registros Encontrados" + resultado.size());

		for (Funcionario funcionario : resultado) {
			System.out.println(funcionario.getCodigo() + " - " + funcionario.getCarteiraTrabalho() + " - "
					+ funcionario.getPessoa().getNome());
		}
	}

	@Test
	@Ignore
	public void buscar() {
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		Funcionario funcionario = funcionarioDAO.buscar(1l);

		if (funcionario == null) {
			System.out.println("Funcionario nao encontrado");
		} else {
			System.out.println(funcionario.getCodigo() + " - " + funcionario.getCarteiraTrabalho() + " - "
					+ funcionario.getPessoa().getNome());
		}

	}
	
	@Test
	@Ignore
	public void editar() {

		Long codigopessoa = 1l;
		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(codigopessoa);

		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		Funcionario funcionario = funcionarioDAO.buscar(1l);

		if (funcionario == null) {
			System.out.println("Funcionario nao encontrado");
		} else {
			try {

				funcionario.setCarteiraTrabalho("0000");
				funcionario.setDataAdmissao(new Date());
				funcionario.setPessoa(pessoa);

				funcionarioDAO.editar(funcionario);

				System.out.println("Funcionario alterado com sucesso");

			} catch (Exception e) {
				// TODO: handle exception

				System.out.println(e);
			}

		}

	}

	@Test
	@Ignore
	public void excluir() {
		
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		Funcionario funcionario = funcionarioDAO.buscar(2l);

		if (funcionario == null) {
			System.out.println("Funcionario nao encontrado");
		} else {
			try {

				funcionarioDAO.excluir(funcionario);

				System.out.println("Funcionario excluido com sucesso");

			} catch (Exception e) {
				// TODO: handle exception

				System.out.println(e);
			}

		}
	}
}
