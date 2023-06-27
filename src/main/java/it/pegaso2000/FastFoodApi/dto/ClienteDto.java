package it.pegaso2000.FastFoodApi.dto;

public class ClienteDto {

	public int id;
	public String nome;
	public boolean is_vegetariano;
	public int eta;
	
	
	
	public ClienteDto(String nome, boolean is_vegetariano, int eta) {
		super();
		this.nome = nome;
		this.is_vegetariano = is_vegetariano;
		this.eta = eta;
	}
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
