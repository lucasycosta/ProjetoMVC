package projeto.mvc.model;

import projeto.mvc.dao.FilmeDao;

public class Filme {
	private Integer id;
	private String nome;
	private String genero;
	
	public Filme() {
	}
	
	public Filme(Integer id, String nome, String genero) {
		this.id = id;
		this.nome = nome;
		this.genero = genero;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void cadastrarFilme(Filme filme) throws Exception {
		new FilmeDao().cadastrarFilme(filme);
	}
}
