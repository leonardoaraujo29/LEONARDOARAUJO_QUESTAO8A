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
		assertEquals("Disponível",livro1.getStatus());
		
		assertEquals("Livro Id 2 inserido com sucesso.",bibliotecaria.inserirLivro("Livro2","Autor2",2));
		assertNull(livro2.getLocatario());
		assertEquals("Disponível",livro2.getStatus());
	}
	
	@Test
	public void falhaAoInserirUmNovoLivro() {
		when(bd.buscarLivro(1)).thenReturn(livro1);
		assertEquals("Erro. Id 1 já existente.",bibliotecaria.inserirLivro("Livro1","Autor1",1));
	}
	
	@Test
	public void emprestarUmLivroComSucesso() {
		assertEquals("Livro 1 emprestado com sucesso para usuario Leonardo.",bibliotecaria.emprestarLivro(1,"Leonardo"));
		assertEquals("Retirado",livro1.getStatus());
		assertEquals(usuario1,livro1.getLocatario());
	}
	
	@Test
	public void falhaAoEmprestarLivroPorLivroNãoExistir() {
		assertEquals("Erro. Livro 3 não existe.",bibliotecaria.emprestarLivro(3,"Leonardo"));
	}
	
	@Test
	public void falhaAoEmprestarLivroPorUsuarioNãoExistir() {
		assertEquals("Erro. Usuario Luiz não existe.",bibliotecaria.emprestarLivro(1,"João"));
	}
	
	@Test
	public void falhaAoEmprestarLivroPorNãoEstarDisponivel() {
		assertEquals("Erro. Livro indisponivel.",bibliotecaria.emprestarLivro(1,"Luiz"));
	}
	
	@Test
	public void falhaAoEmprestarLivroPorUsuarioEstarBloqueado() {
		assertEquals("Erro. Usuario bloquado.",bibliotecaria.emprestarLivro(2,"Luiz"));
	}
	
	@Test
	public void devolverLivroComSucesso() {
		assertEquals("Livro 1 devolvido com sucesso.",bibliotecaria.devolverLivro(1));
	}
	
	@Test
	public void falhaAoDevolverLivroPorLivroNãoExistir() {
		assertEquals("Erro. Livro 3 não existe.",bibliotecaria.devolverLivro(3));
	}
	
	@Test
	public void falhaAoDevolverLivroPorLivroNãoEstarEmprestado() {
		assertEquals("Erro. Livro 2 não está emprestado.",bibliotecaria.devolverLivro(2));
	}

}
