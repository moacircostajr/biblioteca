package br.com.nobreak.biblioteca.model;

import javax.persistence.*;

@Entity
@NamedQueries({
        @NamedQuery(query="select u from Usuario u where u.id = :pId", name="buscaPorIdUsuario"),
        @NamedQuery(query="select u from Usuario u order by u.login", name="listaTodosUsuarios"),
        @NamedQuery(query="select u from Usuario u where u.login = :pLogin and u.senha = :pSenha", name="buscaUsuario")
})
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String login;
    private String senha;

    public Usuario(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
