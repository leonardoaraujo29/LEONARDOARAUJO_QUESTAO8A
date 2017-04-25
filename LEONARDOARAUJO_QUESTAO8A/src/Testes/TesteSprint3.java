package Testes;

import static org.junit.Assert.*;

import org.junit.Test;
import Sistema.*;

import static org.mockito.Mockito.*;
public class TesteSprint3 {

	BancoDeDados bd = mock(BancoDeDados.class);
	AcessoUsuario acessoUsuario = new AcessoUsuario(bd);
	
	Usuario usuario1 = new Usuario("Leonardo");
	@Test
	public void usuarioFalharAoAcessarOSistemaPorN�oExistirUsuario() {
		assertEquals("Erro. Usu�rio Jo�o n�o existe.",acessoUsuario.acessarSistema("Jo�o"));
	}
	
	@Test
	public void usuarioAcessaOSistemaComSucesso() {
		when(bd.buscarUsuario("Leonardo")).thenReturn(usuario1);
		assertEquals("Usu�rio Leonardo logado com sucesso.",acessoUsuario.acessarSistema("Leonardo"));
		assertTrue(usuario1.isLogado());
	}
	
	@Test
	public void buscarLivroInexistente() {
		assertEquals("Erro. Livro 2 n�o encontrado.",acessoUsuario.pesquisarLivro(2));
	}
	
	@Test
	public void buscarLivroDisponivel() {
		assertEquals("Livro 1 est� Dispon�vel.",acessoUsuario.pesquisarLivro(1));
	}
	
	@Test
	public void buscarLivroRetirado() {
		assertEquals("Livro 1 est� Retirado.",acessoUsuario.pesquisarLivro(1));
	}
	
	@Test
	public void buscarLivroExtraviado() {
		assertEquals("Livro 1 est� Extraviado.",acessoUsuario.pesquisarLivro(1));
	}

}
