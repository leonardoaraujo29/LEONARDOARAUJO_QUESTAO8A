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
		return null;
	}
	

}
