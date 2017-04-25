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
		return null;
	}
	

}
