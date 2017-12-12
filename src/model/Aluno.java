package model;

public class Aluno {
	private String matricula;
	private String nome;
	private String email;
	private int idade;
	private char sexo;
	private String empresa;
	private String cidade;
	
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public char getSexo() {
		return sexo;
	}
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	public String getEmpresa() {
		return empresa;
	}
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	public Aluno(String matricula,	String nome, String email, int idade, char sexo, String empresa, String cidade){
		this.matricula=matricula;
		this.nome=nome;
		this.email=email;
		this.idade=idade;
		this.sexo=sexo;
		this.empresa=empresa;
		this.cidade=cidade;
		
	}
	
	public Aluno(String name, String email2, int idade2, String cidade2) {
		this.nome=name;
		this.email=email2;
		this.idade=idade2;
		this.cidade=cidade2;
	}
	public String toString(){
		return getMatricula()+", "+getNome()+", "+getEmail()+", "+getIdade()+", "+getSexo()+", "+getEmpresa()+", "+getCidade();
	}
	
	
}
