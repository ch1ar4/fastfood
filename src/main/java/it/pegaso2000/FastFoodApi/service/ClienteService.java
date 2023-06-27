package it.pegaso2000.FastFoodApi.service;

import java.util.List;

import it.pegaso2000.FastFoodApi.model.Cliente;

public interface ClienteService {
	List<Cliente> getAll();

	Cliente getById(int id);

	Cliente save(Cliente entity);

	boolean delete(int id);
}
