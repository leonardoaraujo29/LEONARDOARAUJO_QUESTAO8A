package Sistema;

public class Bibliotecaria {
	
	private BancoDeDados bancoDeDados;
	
	public Bibliotecaria(BancoDeDados bd){
		bancoDeDados = bd;
	}
	
	public String inserirUsuario(String nomeUsuario){
		Usuario usuario = bancoDeDados.buscarUsuario(nomeUsuario);
		if(usuario != null){
			return  "Erro. Nome " + nomeUsuario + " já existente.";
		}
		usuario = new Usuario(nomeUsuario);
		bancoDeDados.inserirUsuario(usuario);
		return "Usuário " + nomeUsuario + " inserido com sucesso.";
	}
	
	public String removerUsuario(String nomeUsuario){
		Usuario usuario = bancoDeDados.buscarUsuario(nomeUsuario);
		if(usuario == null){
			return "Não foi possível remover usuário " + nomeUsuario + ". Esse usuário não existe.";
		}		
		bancoDeDados.removerUsuario(usuario);
		return "Usuário " + nomeUsuario + " removido com sucesso.";
	}
	
	public String bloquearUsuario(String nomeUsuario){
		Usuario usuario = bancoDeDados.buscarUsuario(nomeUsuario);
		if(usuario == null){
			return "Não foi possível bloquear usuário " + nomeUsuario + ". Esse usuário não existe.";
		}
		if(usuario.isBloqueado()){
			return "Não foi possível bloquear usuário " + nomeUsuario + ". Esse usuário já está bloqueado.";
		}
		usuario.setBloqueado(true);
		bancoDeDados.atualizarUsuario(usuario);
		return "Usuario " + nomeUsuario +  " bloqueado com sucesso.";
	}
	
	public String inserirLivro(String nomeLivro,String autorLivro,int idLivro){
		Livro livro = bancoDeDados.buscarLivro(idLivro);
		if(livro != null){
			return  "Erro. Id " + idLivro + " já existente.";
		}
		livro = new Livro(nomeLivro,autorLivro,idLivro);
		bancoDeDados.inserirLivro(livro);
		return "Livro Id " + idLivro + " inserido com sucesso.";
	}
	
	public String emprestarLivro(int idLivro, String nomeUsuario){
		return null;
	}
	
	public String devolverLivro(int idLivro){
		return null;
	}
	

}
