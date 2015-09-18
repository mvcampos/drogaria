package br.com.mvcampos.drogaria.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.mvcampos.drogaria.domain.Cidade;
import br.com.mvcampos.drogaria.domain.Estado;

public class CidadeDAOTest {

	@Test
	@Ignore
	public void salvar() {
		
		Long codigoEstado = 1L;
		
		EstadoDAO estadoDAO = new EstadoDAO();
		Estado estado = estadoDAO.buscar(codigoEstado);

		if (estado == null) {
			System.out.println("Nenhum estado encontrado.");
		} else {

			Cidade cidade = new Cidade();
			cidade.setNome("São Paulo");
			cidade.setEstado(estado);

			CidadeDAO cidadeDAO = new CidadeDAO();
			cidadeDAO.salvar(cidade);

			System.out.println("Registro cadastrado com sucesso.");
		}
	}

	@Test
	
	public void listar() {
		CidadeDAO cidadeDAO = new CidadeDAO();
		List<Cidade> resultado = cidadeDAO.listar();

		System.out.println("Total de registros Encontrados" + resultado.size());

		for (Cidade cidade : resultado) {
			System.out.println(cidade.getCodigo() + " - " + cidade.getNome() + " - " + cidade.getEstado().getNome());
		}
	}

	@Test
	@Ignore
	public void buscar() {

		CidadeDAO cidadeDAO = new CidadeDAO();
		Cidade cidade = cidadeDAO.buscar(1L);

		if (cidade == null) {
			System.out.println("Nenhum registro encontrado.");
		} else {
			System.out.println("Registro encontrado:");

			System.out.println(cidade.getCodigo() + " - " + cidade.getNome() + " - " + cidade.getEstado().getNome());

		}
	}

	@Test
	@Ignore
	public void excluir() {
		Long codigo = 7L;
		CidadeDAO cidadeDAO = new CidadeDAO();
		Cidade cidade = cidadeDAO.buscar(codigo);
		if (cidade == null) {
			System.out.println("Nenhum registro encontrado.");
		} else {
			cidadeDAO.excluir(cidade);
			System.out.println("Registro excluido com sucesso.");
		}
	}

	@Test
	@Ignore
	public void editar() {
		Long codigo = 1L;
		Long codigoEstado = 2L;
		
		CidadeDAO cidadeDAO = new CidadeDAO();
		Cidade cidade = cidadeDAO.buscar(codigo);
		
		EstadoDAO estadoDAO = new EstadoDAO();
		Estado estado = estadoDAO.buscar(codigoEstado);

		if (cidade == null) {
			System.out.println("Cidade não encontrada.");
		}else if(estado == null) {
			System.out.println("Estado não encontrada.");
		}else{
			cidade.setNome("Belo Horizonte");
			cidade.setEstado(estado);

			cidadeDAO.editar(cidade);

			System.out.println("Registro alterado com sucesso.");
		}

	}

}
