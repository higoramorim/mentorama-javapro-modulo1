package entities;

public class Aluno {

	private Integer id;
	private String nome;
	private String idade;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getIdade() {
		return idade;
	}

	public void setIdade(String idade) {
		this.idade = idade;
	}

	public Aluno(Integer id, String nome, String idade) {
		this.id = id;
		this.nome = nome;
		this.idade = idade;
	}

}
