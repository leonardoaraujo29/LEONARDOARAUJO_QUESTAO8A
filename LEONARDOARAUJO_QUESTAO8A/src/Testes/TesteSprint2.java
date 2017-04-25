package Testes;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.anyInt;

import org.junit.Test;
import Sistema.*;

public class TesteSprint2 {

	BancoDeDados bd = mock(BancoDeDados.class);
	Bibliotecaria bibliotecaria = new Bibliotecaria(bd);
	
	Livro livro1 = new Livro ("Livro1","Autor1",1);
	Livro livro2 = new Livro ("Livro2","Autor2",2);
	
	Usuario usuario1 = new Usuario("Leonardo");
	Usuario usuario2 = new Usuario("Luiz");
	
	@Test
	public void inserirUmNovoLivroComSucesso() {
		when(bd.buscarLivro(anyInt())).thenReturn(null);
		
		assertEquals("Livro Id 1 inserido com sucesso.",bibliotecaria.inserirLivro("Livro1","Autor1",1));
		assertNull(livro1.getLocatario());
		assertEquals("Dispon�vel",livro1.getStatus());
		
		assertEquals("Livro Id 2 inserido com sucesso.",bibliotecaria.inserirLivro("Livro2","Autor2",2));
		assertNull(livro2.getLocatario());
		assertEquals("Dispon�vel",livro2.getStatus());
	}
	
	@Test
	public void falhaAoInserirUmNovoLivro() {
		when(bd.buscarLivro(1)).thenReturn(livro1);
		assertEquals("Erro. Id 1 j� existente.",bibliotecaria.inserirLivro("Livro1","Autor1",1));
	}
	
	@Test
	public void emprestarUmLivroComSucesso() {
		when(bd.buscarLivro(1)).thenReturn(livro1);
		when(bd.buscarUsuario("Leonardo")).thenReturn(usuario1);
		assertEquals("Livro 1 emprestado com sucesso para usu�rio Leonardo.",bibliotecaria.emprestarLivro(1,"Leonardo"));
		assertEquals("Retirado",livro1.getStatus());
		assertEquals(usuario1,livro1.getLocatario());
	}
	
	@Test
	public void falhaAoEmprestarLivroPorLivroN�oExistir() {
		assertEquals("Erro. Livro 3 n�o existe.",bibliotecaria.emprestarLivro(3,"Leonardo"));
	}
	
	@Test
	public void falhaAoEmprestarLivroPorUsuarioN�oExistir() {
		when(bd.buscarLivro(1)).thenReturn(livro1);
		assertEquals("Erro. Usu�rio Jo�o n�o existe.",bibliotecaria.emprestarLivro(1,"Jo�o"));
	}
	
	@Test
	public void falhaAoEmprestarLivroPorN�oEstarDisponivel() {
		when(bd.buscarLivro(1)).thenReturn(livro1);
		when(bd.buscarUsuario("Luiz")).thenReturn(usuario2);
		livro1.setStatus("Retirado");
		assertEquals("Erro. Livro 1 indispon�vel.",bibliotecaria.emprestarLivro(1,"Luiz"));
	}
	
	@Test
	public void falhaAoEmprestarLivroPorUsuarioEstarBloqueado() {
		usuario2.setBloqueado(true);
		when(bd.buscarLivro(2)).thenReturn(livro2);
		when(bd.buscarUsuario("Luiz")).thenReturn(usuario2);
		assertEquals("Erro. Usu�rio Luiz bloqueado.",bibliotecaria.emprestarLivro(2,"Luiz"));
	}
	
	@Test
	public void devolverLivroComSucesso() {
		assertEquals("Livro 1 devolvido com sucesso.",bibliotecaria.devolverLivro(1));
	}
	
	@Test
	public void falhaAoDevolverLivroPorLivroN�oExistir() {
		assertEquals("Erro. Livro 3 n�o existe.",bibliotecaria.devolverLivro(3));
	}
	
	@Test
	public void falhaAoDevolverLivroPorLivroN�oEstarEmprestado() {
		assertEquals("Erro. Livro 2 n�o est� emprestado.",bibliotecaria.devolverLivro(2));
	}

}
