package Sistema;

public class Usuario {
	private String nome;
	private boolean bloqueado;
	public Usuario(String nome){
		this.setNome(nome);
		this.bloqueado = false;
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
}
