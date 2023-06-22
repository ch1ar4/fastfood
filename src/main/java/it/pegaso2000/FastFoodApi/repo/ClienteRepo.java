package it.pegaso2000.FastFoodApi.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import it.pegaso2000.FastFoodApi.model.Cliente;

public interface ClienteRepo extends JpaRepository<Cliente, Integer> {

}
