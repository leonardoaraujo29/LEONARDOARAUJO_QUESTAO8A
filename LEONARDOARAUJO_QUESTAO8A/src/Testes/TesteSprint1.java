package Testes;

import static org.junit.Assert.*;

import org.junit.Test;
import Sistema.*;

import static org.mockito.Mockito.*;

public class TesteSprint1 {

	BancoDeDados bd = mock(BancoDeDados.class);
	Bibliotecaria bibliotecaria = new Bibliotecaria(bd);
	Usuario usuario1 = new Usuario("Leonardo");
	Usuario usuario2 = new Usuario("Luiz");
	
	@Test
	public void inserirUmNovoUsuarioComSucesso() {
		when(bd.buscarUsuario(anyString())).thenReturn(null);
		assertEquals("Usuário Leonardo inserido com sucesso.",bibliotecaria.inserirUsuario("Leonardo"));
		assertEquals("Usuário Luiz inserido com sucesso.",bibliotecaria.inserirUsuario("Luiz"));
	}
	
	@Test
	public void falhaAoInserirUmNovoUsuario() {
		when(bd.buscarUsuario("Leonardo")).thenReturn(usuario1);
		assertEquals("Erro. Nome Leonardo já existente.",bibliotecaria.inserirUsuario("Leonardo"));
	}
	
	@Test
	public void removerUsuarioComSucesso() {
		when(bd.buscarUsuario("Leonardo")).thenReturn(usuario1);
		assertEquals("Usuário Leonardo removido com sucesso.",bibliotecaria.removerUsuario("Leonardo"));
	}
	
	@Test
	public void falhaAoRemoverUsuario() {
		when(bd.buscarUsuario("Leonardo")).thenReturn(null);
		assertEquals("Não foi possível remover usuário Leonardo. Esse usuário não existe.",bibliotecaria.removerUsuario("Leonardo"));
	}
	
	@Test
	public void bloquearUsuarioComSucesso() {
		when(bd.buscarUsuario("Luiz")).thenReturn(new Usuario("Luiz"));
		//when(bd.atualizarUsuario(any())).doNothing();
		assertEquals("Usuario Luiz bloqueado com sucesso.",bibliotecaria.bloquearUsuario("Luiz"));
	}
	
	@Test
	public void falhaAoBloquearUsuarioPorNaoExistir() {
		when(bd.buscarUsuario("Leonardo")).thenReturn(null);
		assertEquals("Não foi possível bloquear usuário Leonardo. Esse usuário não existe.",bibliotecaria.bloquearUsuario("Leonardo"));
	}
	
	
	
	@Test
	public void falhaAoBloquearUsuarioPorJaEstarBloqueado() {
		Usuario usuario = new Usuario("Luiz");
		usuario.setBloqueado(true);
		when(bd.buscarUsuario("Luiz")).thenReturn(usuario);
		assertEquals("Não foi possível bloquear usuário Luiz. Esse usuário já está bloqueado.",bibliotecaria.bloquearUsuario("Luiz"));
	}

}
