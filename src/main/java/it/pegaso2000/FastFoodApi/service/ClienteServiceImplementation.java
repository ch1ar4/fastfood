package it.pegaso2000.FastFoodApi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.pegaso2000.FastFoodApi.model.Cliente;
import it.pegaso2000.FastFoodApi.repo.ClienteRepo;

@Service
public class ClienteServiceImplementation implements ClienteService {

	private ClienteRepo crepo;

	@Autowired
	public ClienteServiceImplementation(ClienteRepo crepo) {
		super();
		this.crepo = crepo;
	}

	@Override
	public List<Cliente> getAll() {

		return crepo.findAll();
	}

	@Override
	public Cliente getById(int id) {
		Optional<Cliente> c = crepo.findById(id);
		if (c.isPresent())
			return c.get();
		return null;
	}

	@Override
	public Cliente save(Cliente entity) {

		return crepo.save(entity);
	}

	@Override
	public boolean delete(int id) {
		Optional<Cliente> c = crepo.findById(id);
		if (c.isPresent())
			crepo.deleteById(id);
		return true;
	}

}
