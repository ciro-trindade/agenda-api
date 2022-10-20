package br.fatec.agenda.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tb_contato")
public class Contato extends AbstractEntity {
	private static final long serialVersionUID = 1L;
	
	@Column(length = 80, nullable = false)
	private String nome;
	@Column(length = 60)
	private String email;
	@Column(length = 20)
	private String telefone;
	
	public Contato() {
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

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

}
