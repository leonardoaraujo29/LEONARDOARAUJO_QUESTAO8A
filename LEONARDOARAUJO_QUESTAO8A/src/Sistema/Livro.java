package Sistema;

public class Livro {

	private String nome;
	private String autor;
	private int id;
	private String status;
	private Usuario locatario;
	
	public Livro(String nome,String autor,int id){
		this.setNome(nome);
		this.setAutor(autor);
		this.id = id;
		setStatus("Disponível");
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Usuario getLocatario() {
		return locatario;
	}

	public void setLocatario(Usuario locatario) {
		this.locatario = locatario;
	}
	
	
	
	
}
