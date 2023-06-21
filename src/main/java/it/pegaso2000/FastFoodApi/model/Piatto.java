package it.pegaso2000.FastFoodApi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "piatto")
public class Piatto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false)
	private String descrizione;
	@Column(nullable = false)
	private boolean is_vegetariano;
	@Column(nullable = false)
	private int prezzo;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public boolean isIs_vegetariano() {
		return is_vegetariano;
	}

	public void setIs_vegetariano(boolean is_vegetariano) {
		this.is_vegetariano = is_vegetariano;
	}

	public int getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(int prezzo) {
		this.prezzo = prezzo;
	}

}
