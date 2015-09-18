package br.com.mvcampos.drogaria.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.mvcampos.drogaria.domain.Pessoa;
import br.com.mvcampos.drogaria.domain.Usuario;

public class UsuarioDAOTest {

	@Test
	@Ignore
	public void salvar() {

		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(2L);

		Usuario usuario = new Usuario();
		usuario.setAtivo(true);
		usuario.setSenha("1234");
		usuario.setPessoa(pessoa);
		usuario.setTipo('A');

		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.salvar(usuario);

		System.out.println("Usuário salvo com sucesso.");

	}

	@Test
	@Ignore
	public void listar() {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		List<Usuario> resultado = usuarioDAO.listar();

		System.out.println("Total de registros Encontrados" + resultado.size());

		for (Usuario usuario : resultado) {
			System.out
					.println(usuario.getCodigo() + " - " + usuario.getSenha() + " - " + usuario.getPessoa().getNome());
		}

	}

	@Test
	@Ignore
	public void buscar() {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = usuarioDAO.buscar(1l);

		if (usuario == null) {
			System.out.println("Nenhum registro encontrado.");
		} else {
			System.out
					.println(usuario.getCodigo() + " - " + usuario.getSenha() + " - " + usuario.getPessoa().getNome());
		}
	}

	@Test
	@Ignore
	public void editar() {

		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = usuarioDAO.buscar(1l);

		if (usuario == null) {
			System.out.println("Nenhum registro encontrado.");
		} else {

			PessoaDAO pessoaDAO = new PessoaDAO();
			Pessoa pessoa = pessoaDAO.buscar(2L);

			usuario.setAtivo(true);
			usuario.setSenha("1321131234");
			usuario.setPessoa(pessoa);
			usuario.setTipo('c');

			usuarioDAO.editar(usuario);

			System.out.println("Usuario alterado com sucesso.");
		}
	}

	@Test
	@Ignore
	public void excluir() {

		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = usuarioDAO.buscar(1l);

		if (usuario == null) {
			System.out.println("Nenhum registro encontrado.");
		} else {

			usuarioDAO.excluir(usuario);

			System.out.println("Usuario excluido com sucesso.");
		}
	}
}
