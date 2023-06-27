package it.pegaso2000.FastFoodApi.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.pegaso2000.FastFoodApi.dto.PiattoDto;
import it.pegaso2000.FastFoodApi.model.Piatto;
import it.pegaso2000.FastFoodApi.service.PiattoService;

@RestController
@RequestMapping("/api/piatto")
public class PiattoController {
	private PiattoService service;

	@Autowired
	public PiattoController(PiattoService service) {
		super();
		this.service = service;
	}

	@GetMapping("/all")
	public ResponseEntity<List<PiattoDto>> all() {
		List<Piatto> list = service.getAll();
		List<PiattoDto> result = list.stream().map(piatto -> {
			return entityToDto(piatto);
		}).collect(Collectors.toList());
		return new ResponseEntity<List<PiattoDto>>(result, HttpStatus.OK);
	}

	@GetMapping("/getById/{id}")
	public ResponseEntity<PiattoDto> getById(@PathVariable int id) {
		Piatto p = service.getById(id);
		if (p == null)
			return new ResponseEntity<PiattoDto>(HttpStatus.NO_CONTENT);
		PiattoDto dto = entityToDto(p);
		return new ResponseEntity<PiattoDto>(dto, HttpStatus.OK);
	}

	@PostMapping("/save")
	public ResponseEntity<PiattoDto> save(@RequestBody PiattoDto dto) {
		Piatto saving = dtoToEntity(dto);
		Piatto saved = service.save(saving);
		return new ResponseEntity<PiattoDto>(entityToDto(saved), HttpStatus.OK);
	}

	// TODO update
	@PutMapping("/update/{id}")
	public ResponseEntity<PiattoDto> update(@RequestBody PiattoDto updated, @PathVariable int id) {
		PiattoDto dto = entityToDto(service.getById(id));
		if (dto != null) {
			updated.setId(id);
			Piatto saving = service.save(dtoToEntity(updated));
			return new ResponseEntity<PiattoDto>(entityToDto(saving), HttpStatus.OK);
		}
		return new ResponseEntity<PiattoDto>(HttpStatus.NO_CONTENT);
	}

	// TODO delete
	@DeleteMapping("/delete/{id}")
	public boolean delete(@PathVariable int id) {
		return service.delete(id);

	}

//entitytodto
	private PiattoDto entityToDto(Piatto p) {
		PiattoDto dto = new PiattoDto(p.getDescrizione(), p.isIs_vegetariano(), p.getPrezzo());
		dto.setId(p.getId());
		return dto;
	}

//dtoToEntity
	private Piatto dtoToEntity(PiattoDto dto) {
		Piatto p = new Piatto();
		p.setId(dto.getId());
		p.setDescrizione(dto.getDescrizione());
		p.setPrezzo(dto.getPrezzo());
		p.setIs_vegetariano(dto.isIs_vegetariano());

		return p;

	}

}
