package br.com.nobreak.biblioteca.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.*;

@Entity
@NamedQueries({
        @NamedQuery(query = "select l from Livro l join l.autores a where l.id = :pId", name = "buscaPorIdLivro"),
        @NamedQuery(query = "select distinct l from Livro l left join fetch l.autores", name = "listaTodosLivros"),
        @NamedQuery(query = "select l from Livro l where l.titulo = :pNome", name = "buscaPorLivro")
})
public class Livro {

    @Id
    @GeneratedValue
    private Integer id;
    @Column(unique = true, nullable = false)
    private String titulo;
    private String isbn;
    private String anoLancamento;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Autor> autores = new ArrayList<Autor>();
    @Temporal(TemporalType.DATE)
    private Calendar dataRegistro = Calendar.getInstance();
    private Integer numeroRegistro;
    private String tombamento;
    private String classificacao;
    private String catalogoTopografico;
    private String editora;
    private Integer volume;
    private Integer exemplares;
    @Enumerated(EnumType.STRING)
    private Origem origem;
    private String identificacaoOrigem;



    public Livro() {
    }



    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }

    public void adicionaAutor(Autor autor) {
        this.autores.add(autor);
    }

    public void removeAutor(Autor autor) {
        this.autores.remove(autor);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(String anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public Calendar getDataRegistro() {
        /*estabelecerformato de data a ser devolvido: dd/MM/yyyy*/
        return dataRegistro;
    }

    public void setDataRegistro(Calendar dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    public Integer getNumeroRegistro() {
        return numeroRegistro;
    }

    public void setNumeroRegistro(Integer numeroRegistro) {
        this.numeroRegistro = numeroRegistro;
    }

    public String getTombamento() {
        return tombamento;
    }

    public void setTombamento(String tombamento) {
        this.tombamento = tombamento;
    }

    public String getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(String classificacao) {
        this.classificacao = classificacao;
    }

    public String getCatalogoTopografico() {
        return catalogoTopografico;
    }

    public void setCatalogoTopografico(String catalogoTopografico) {
        this.catalogoTopografico = catalogoTopografico;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    public Integer getExemplares() {
        return exemplares;
    }

    public void setExemplares(Integer exemplares) {
        this.exemplares = exemplares;
    }

    public String getIdentificacaoOrigem() {
        return identificacaoOrigem;
    }

    public void setIdentificacaoOrigem(String identificacaoOrigem) {
        this.identificacaoOrigem = identificacaoOrigem;
    }

    public Origem getOrigem() {
        return origem;
    }

    public void setOrigem(Origem origem) {
        this.origem = origem;
    }
}
