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
	public void usuarioFalharAoAcessarOSistemaPorNãoExistirUsuario() {
		assertEquals("Erro. Usuário João não existe.",acessoUsuario.acessarSistema("João"));
	}
	
	@Test
	public void usuarioAcessaOSistemaComSucesso() {
		when(bd.buscarUsuario("Leonardo")).thenReturn(usuario1);
		assertEquals("Usuário Leonardo logado com sucesso.",acessoUsuario.acessarSistema("Leonardo"));
		assertTrue(usuario1.isLogado());
	}
	
	@Test
	public void buscarLivroInexistente() {
		assertEquals("Erro. Livro 2 não encontrado.",acessoUsuario.pesquisarLivro(2));
	}
	
	@Test
	public void buscarLivroDisponivel() {
		assertEquals("Livro 1 está Disponível.",acessoUsuario.pesquisarLivro(1));
	}
	
	@Test
	public void buscarLivroRetirado() {
		assertEquals("Livro 1 está Retirado.",acessoUsuario.pesquisarLivro(1));
	}
	
	@Test
	public void buscarLivroExtraviado() {
		assertEquals("Livro 1 está Extraviado.",acessoUsuario.pesquisarLivro(1));
	}

}
