package it.pegaso2000.FastFoodApi.dto;

public class PiattoDto {


	private int id;
	private String descrizione;
	private boolean is_vegetariano;
	private int prezzo;

	public PiattoDto(String descrizione, boolean is_vegetariano, int prezzo) {
		super();
		this.descrizione = descrizione;
		this.is_vegetariano = is_vegetariano;
		this.prezzo = prezzo;
	}

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
