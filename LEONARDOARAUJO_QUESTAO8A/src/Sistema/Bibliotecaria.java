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
		return null;
	}
	
	public String bloquearUsuario(String nomeUsuario){
		return null;
	}
	

}
