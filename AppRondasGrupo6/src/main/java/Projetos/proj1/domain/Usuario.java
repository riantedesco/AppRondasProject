package Projetos.proj1.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Usuario implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "UsuarioId")
	@SequenceGenerator(name = "UsuarioId", sequenceName = "UsuarioId", allocationSize = 1)
	private Integer id;
	
	@Column(length = 60, nullable = false)
	private String nome;
	
	@Column(length = 100, nullable = false, unique = true)
	private String email;
	
	@Column(length = 64, nullable = false)
	private String senha;
	
	
	private static final long serialVersionUID = 1L;

	
	public Usuario() {
		super();
	}
	
	
	public Usuario(Integer id) {
		super();
		this.id = id;
	}
	public Usuario(Integer id, String nome, String email, String senha) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
	}
	
	
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
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
}
