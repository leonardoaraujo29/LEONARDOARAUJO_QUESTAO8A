package Sistema;

public class Usuario {
	private String nome;
	private boolean bloqueado;
	private boolean logado;
	public Usuario(String nome){
		this.setNome(nome);
		this.bloqueado = false;
		this.setLogado(false);
	}

	public String getNome() {
		return nome;
	}

	private void setNome(String nome) {
		this.nome = nome;
	}

	public boolean isBloqueado() {
		return bloqueado;
	}

	public void setBloqueado(boolean bloqueado) {
		this.bloqueado = bloqueado;
	}

	public boolean isLogado() {
		return logado;
	}

	public void setLogado(boolean logado) {
		this.logado = logado;
	}
}
