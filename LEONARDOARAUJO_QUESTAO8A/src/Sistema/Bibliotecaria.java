package Sistema;

public class Bibliotecaria {
	
	private BancoDeDados bancoDeDados;
	
	public Bibliotecaria(BancoDeDados bd){
		bancoDeDados = bd;
	}
	
	public String inserirUsuario(String nomeUsuario){
		Usuario usuario = bancoDeDados.buscarUsuario(nomeUsuario);
		if(usuario != null){
			return  "Erro. Nome " + nomeUsuario + " j� existente.";
		}
		usuario = new Usuario(nomeUsuario);
		bancoDeDados.inserirUsuario(usuario);
		return "Usu�rio " + nomeUsuario + " inserido com sucesso.";
	}
	
	public String removerUsuario(String nomeUsuario){
		Usuario usuario = bancoDeDados.buscarUsuario(nomeUsuario);
		if(usuario == null){
			return "N�o foi poss�vel remover usu�rio " + nomeUsuario + ". Esse usu�rio n�o existe.";
		}		
		bancoDeDados.removerUsuario(usuario);
		return "Usu�rio " + nomeUsuario + " removido com sucesso.";
	}
	
	public String bloquearUsuario(String nomeUsuario){
		Usuario usuario = bancoDeDados.buscarUsuario(nomeUsuario);
		if(usuario == null){
			return "N�o foi poss�vel bloquear usu�rio " + nomeUsuario + ". Esse usu�rio n�o existe.";
		}
		if(usuario.isBloqueado()){
			return "N�o foi poss�vel bloquear usu�rio " + nomeUsuario + ". Esse usu�rio j� est� bloqueado.";
		}
		usuario.setBloqueado(true);
		bancoDeDados.atualizarUsuario(usuario);
		return "Usuario " + nomeUsuario +  " bloqueado com sucesso.";
	}
	
	public String inserirLivro(String nomeLivro,String autorLivro,int idLivro){
		Livro livro = bancoDeDados.buscarLivro(idLivro);
		if(livro != null){
			return  "Erro. Id " + idLivro + " j� existente.";
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
