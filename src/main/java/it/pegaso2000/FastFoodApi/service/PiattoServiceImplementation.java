package it.pegaso2000.FastFoodApi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.pegaso2000.FastFoodApi.model.Piatto;
import it.pegaso2000.FastFoodApi.repo.PiattoRepo;

@Service
public class PiattoServiceImplementation implements PiattoService {
	private PiattoRepo prepo;

	@Autowired
	public PiattoServiceImplementation(PiattoRepo prepo) {
		super();
		this.prepo = prepo;
	}

	@Override
	public List<Piatto> getAll() {

		return prepo.findAll();
	}

	@Override
	public Piatto getById(int id) {
		Optional<Piatto> p = prepo.findById(id);
		if (p.isPresent())
			return p.get();
		return null;
	}

	@Override
	public Piatto save(Piatto entity) {

		return prepo.save(entity);
	}

	@Override
	public boolean delete(int id) {
		Optional<Piatto> p = prepo.findById(id);
		if (p.isPresent())
			prepo.deleteById(id);
		return true;
	}

}
