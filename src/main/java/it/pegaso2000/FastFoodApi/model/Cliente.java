package it.pegaso2000.FastFoodApi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false)
	private String nome;
	@Column(nullable = false)
	private boolean is_vegetariano;
	@Column(nullable = false)
	private int eta;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public boolean isIs_vegetariano() {
		return is_vegetariano;
	}

	public void setIs_vegetariano(boolean is_vegetariano) {
		this.is_vegetariano = is_vegetariano;
	}

	public int getEta() {
		return eta;
	}

	public void setEta(int eta) {
		this.eta = eta;
	}

}
