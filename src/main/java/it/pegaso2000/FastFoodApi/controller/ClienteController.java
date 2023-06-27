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

import it.pegaso2000.FastFoodApi.dto.ClienteDto;
import it.pegaso2000.FastFoodApi.model.Cliente;
import it.pegaso2000.FastFoodApi.service.ClienteService;

@RestController
@RequestMapping("api/cliente")
public class ClienteController {
	private ClienteService service;

	@Autowired
	public ClienteController(ClienteService service) {
		super();
		this.service = service;
	}

	@GetMapping("/all")
	public ResponseEntity<List<ClienteDto>> all() {
		List<Cliente> list = service.getAll();
		List<ClienteDto> result = list.stream().map(cliente -> {
			return entityToDto(cliente);
		}).collect(Collectors.toList());
		return new ResponseEntity<List<ClienteDto>>(result, HttpStatus.OK);
	}

	@GetMapping("/getById/{id}")
	public ResponseEntity<ClienteDto> getById(@PathVariable int id) {
		Cliente c = service.getById(id);
		if (c == null)
			return new ResponseEntity<ClienteDto>(HttpStatus.NO_CONTENT);
		ClienteDto dto = entityToDto(c);
		return new ResponseEntity<ClienteDto>(dto, HttpStatus.OK);
	}

	@PostMapping("/save")
	public ResponseEntity<ClienteDto> save(@RequestBody ClienteDto dto) {
		Cliente saving = dtoToEntity(dto);
		Cliente saved = service.save(saving);
		return new ResponseEntity<ClienteDto>(entityToDto(saved), HttpStatus.OK);
	}

	// TODO update
	@PutMapping("/update/{id}")
	public ResponseEntity<ClienteDto> update(@RequestBody ClienteDto updated, @PathVariable int id) {
		ClienteDto dto = entityToDto(service.getById(id));
		if (dto != null) {
			updated.setId(id);
			Cliente saving = service.save(dtoToEntity(updated));
			return new ResponseEntity<ClienteDto>(entityToDto(saving), HttpStatus.OK);
		}
		return new ResponseEntity<ClienteDto>(HttpStatus.NO_CONTENT);
	}

	// TODO delete
	@DeleteMapping("/delete/{id}")
	public boolean delete(@PathVariable int id) {
		return service.delete(id);

	}

//entitytodto
	private ClienteDto entityToDto(Cliente c) {
		ClienteDto dto = new ClienteDto(c.getNome(), c.isIs_vegetariano(), c.getEta());
		dto.setId(c.getId());
		return dto;
	}

//dtoToEntity
	private Cliente dtoToEntity(ClienteDto dto) {
		Cliente c = new Cliente();
		c.setNome(dto.getNome());
		c.setIs_vegetariano(dto.isIs_vegetariano());
		c.setEta(dto.getEta());
		return c;

	}
}
