package br.com.nobreak.biblioteca.model;

import javax.persistence.*;

@Entity
@NamedQueries({
		@NamedQuery(query = "select a from Autor a where a.id = :pId", name="buscaPorIdAutor"),
		@NamedQuery(query = "select a from Autor a order by a.nome", name="listaTodosAutores"),
		@NamedQuery(query = "select a from Autor a where a.nome = :pNome", name="buscaPorNome")
})
public class Autor {

	@Id
	@GeneratedValue
	private Integer id;
	@Column(nullable = false)
	private String nome;

	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
