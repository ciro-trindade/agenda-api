package br.fatec.agenda.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.fatec.agenda.model.Contato;
import br.fatec.agenda.service.ContatoService;

@RestController
@RequestMapping("/contatos")
public class ContatoController implements ControllerInterface<Contato>{

	@Autowired
	private ContatoService service;
	
	@Override
	@GetMapping
	public ResponseEntity<Page<Contato>> getAll(Pageable pageable) {
		return ResponseEntity.ok(service.findAll(pageable));
	}

	@Override
	@GetMapping("/{id}")
	public ResponseEntity<Contato> get(@PathVariable("id") Long id) {
		Contato obj = service.findById(id);
		if (obj != null)
			return ResponseEntity.ok(obj);
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

	@Override
	@PostMapping
	public ResponseEntity<Contato> post(@RequestBody Contato obj) {
		service.create(obj);
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(obj.getId())
				.toUri();
		return ResponseEntity.created(location).body(obj);
	}

	@Override
	@PutMapping
	public ResponseEntity<Contato> put(@RequestBody Contato obj) {
		if (service.update(obj)) {
			return ResponseEntity.ok(obj);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

	@Override
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
		if (service.delete(id)) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	@GetMapping("/quantidade")
	public ResponseEntity<Long> getQuantidade() {
		return ResponseEntity.ok(service.numeroDeContatos());
	}
	
	@GetMapping("/nome/{nome}")
	public ResponseEntity<Page<Contato>> getByNome(Pageable pageable, @PathVariable("nome") String nome) {
		return ResponseEntity.ok(service.findByNome(pageable, nome));
	}

	@GetMapping("/email/{nome}")
	public ResponseEntity<Page<Contato>> getByEmail(Pageable pageable, @PathVariable("email") String email) {
		return ResponseEntity.ok(service.findByEmail(pageable, email));
	}

}
