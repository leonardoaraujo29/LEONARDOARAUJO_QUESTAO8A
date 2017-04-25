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
		assertEquals("Usu�rio Leonardo inserido com sucesso.",bibliotecaria.inserirUsuario("Leonardo"));
		assertEquals("Usu�rio Luiz inserido com sucesso.",bibliotecaria.inserirUsuario("Luiz"));
	}
	
	@Test
	public void falhaAoInserirUmNovoUsuario() {
		when(bd.buscarUsuario("Leonardo")).thenReturn(usuario1);
		assertEquals("Erro. Nome Leonardo j� existente.",bibliotecaria.inserirUsuario("Leonardo"));
	}
	
	@Test
	public void removerUsuarioComSucesso() {
		when(bd.buscarUsuario("Leonardo")).thenReturn(usuario1);
		assertEquals("Usu�rio Leonardo removido com sucesso.",bibliotecaria.removerUsuario("Leonardo"));
	}
	
	@Test
	public void falhaAoRemoverUsuario() {
		when(bd.buscarUsuario("Leonardo")).thenReturn(null);
		assertEquals("N�o foi poss�vel remover usu�rio Leonardo. Esse usu�rio n�o existe.",bibliotecaria.removerUsuario("Leonardo"));
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
		assertEquals("N�o foi poss�vel bloquear usu�rio Leonardo. Esse usu�rio n�o existe.",bibliotecaria.bloquearUsuario("Leonardo"));
	}
	
	
	
	@Test
	public void falhaAoBloquearUsuarioPorJaEstarBloqueado() {
		Usuario usuario = new Usuario("Luiz");
		usuario.setBloqueado(true);
		when(bd.buscarUsuario("Luiz")).thenReturn(usuario);
		assertEquals("N�o foi poss�vel bloquear usu�rio Luiz. Esse usu�rio j� est� bloqueado.",bibliotecaria.bloquearUsuario("Luiz"));
	}

}
