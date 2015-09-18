package br.com.mvcampos.drogaria.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.mvcampos.drogaria.domain.Cidade;
import br.com.mvcampos.drogaria.domain.Pessoa;

public class PessoaDAOTest {

	@Test
	
	public void salvar() {
		Long codigocidade = 1L;

		CidadeDAO cidadeDAO = new CidadeDAO();
		Cidade cidade = cidadeDAO.buscar(codigocidade);

		Pessoa pessoa = new Pessoa();
		pessoa.setNome("ilt onVinicius Campos");
		pessoa.setCpf("08495663635");
		pessoa.setRg("MG13202349");
		pessoa.setRua("Rua lindolfo de Azevedo");
		pessoa.setNumero(new Short("2620"));
		pessoa.setBairro("Jardmin América");
		pessoa.setCep("30421380");
		pessoa.setComplemento("casa");
		pessoa.setTelefone("313733273");
		pessoa.setCelular("3186097591");
		pessoa.setEmail("vinicius@mvcampos.com.br");
		pessoa.setCidade(cidade);

		PessoaDAO pessoaDAO = new PessoaDAO();

		try {
			pessoaDAO.salvar(pessoa);
			System.out.println("Registro cadastrado com sucesso!");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}

	}

	@Test
	@Ignore
	public void listar() {
		PessoaDAO pessoaDAO = new PessoaDAO();
		List<Pessoa> resultado = pessoaDAO.listar();

		System.out.println("Total de registros Encontrados" + resultado.size());

		for (Pessoa pessoa : resultado) {
			System.out.println("Registro encontrado:");

			System.out.println(pessoa.getCodigo() + " - " + pessoa.getNome() + " - " + pessoa.getCidade().getNome()
					+ " - " + pessoa.getCidade().getEstado().getNome());
		}
	}

	@Test
	@Ignore
	public void buscar() {
		Long codigo = 3L;

		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(codigo);

		if (pessoa == null) {

			System.out.println("Nenhum registro encontrado");

		} else {

			System.out.println("Registro encontrado:");

			System.out.println(pessoa.getCodigo() + " - " + pessoa.getNome() + " - " + pessoa.getCidade().getNome()
					+ " - " + pessoa.getCidade().getEstado().getNome());

		}

	}
	
	@Test
	@Ignore
	public void editar(){
		
		Long codigo = 1L;
		Long codigocidade = 4L;
		
		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(codigo);

		CidadeDAO cidadeDAO = new CidadeDAO();
		Cidade cidade = cidadeDAO.buscar(codigocidade);
		
		if (cidade == null) {
			System.out.println("Cidade não encontrada.");
		}else if (pessoa == null) {
			System.out.println("Pessoa não encontrada.");
		}else{
			
			pessoa.setNome("Milton Vinicius Campos");
			pessoa.setCpf("08495663635");
			pessoa.setRg("MG13202349");
			pessoa.setRua("Rua lindolfo de Azevedo");
			pessoa.setNumero(new Short("2620"));
			pessoa.setBairro("Jardmin América");
			pessoa.setCep("30421380");
			pessoa.setComplemento("casa");
			pessoa.setTelefone("313733273");
			pessoa.setCelular("3186097591");
			pessoa.setEmail("vinicius@mvcampos.com.br");
			pessoa.setCidade(cidade);
			
			pessoaDAO.editar(pessoa);
			System.out.println("Registro alterado com sucesso.");
		}
	}
	
	@Test
	@Ignore
	public void excluir(){
		Long codigo = 1L;
		
		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(codigo);
		
		 if (pessoa == null) {
			System.out.println("Pessoa não encontrada.");
		}else{
			pessoaDAO.excluir(pessoa);
			System.out.println("Registro excluido com sucesso.");
		}
	}
}


