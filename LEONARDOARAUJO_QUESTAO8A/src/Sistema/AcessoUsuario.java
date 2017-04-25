package Sistema;

public class AcessoUsuario {

	private Usuario usuario;
	private BancoDeDados bd;
	
	
	
	public AcessoUsuario(BancoDeDados bd){
		this.bd = bd;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public String acessarSistema(String nomeUsuario){
		Usuario usuario = bd.buscarUsuario(nomeUsuario);
		if(usuario == null){
			return "Erro. Usuário " + nomeUsuario + " não existe.";
		}
		return null;
		
	}
	
	public String pesquisarLivro(int idLivro){
		return null;
	}
	
	
	
}
