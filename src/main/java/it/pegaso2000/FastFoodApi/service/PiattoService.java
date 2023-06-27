package it.pegaso2000.FastFoodApi.service;

import java.util.List;

import it.pegaso2000.FastFoodApi.model.Piatto;

public interface PiattoService {
	List<Piatto> getAll();

	Piatto getById(int id);

	Piatto save(Piatto entity);

	boolean delete(int id);
}
