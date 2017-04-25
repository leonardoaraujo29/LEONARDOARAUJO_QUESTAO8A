package Sistema;

public interface BancoDeDados {
	public void inserirUsuario(Usuario usuario);
	public void removerUsuario(Usuario usuario);
	public Usuario buscarUsuario(String nomeUsuario);
	public void atualizarUsuario(Usuario usuario);
}
