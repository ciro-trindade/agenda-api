package br.fatec.agenda.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.fatec.agenda.model.Contato;
import br.fatec.agenda.repository.ContatoRepository;

@Service
public class ContatoService implements ServiceInterface<Contato>{

	@Autowired
	private ContatoRepository repository;
	
	@Override
	public Contato create(Contato obj) {
		repository.save(obj);
		return obj;
	}

	@Override
	public Contato findById(Long id) {
		Optional<Contato> obj = repository.findById(id);
		return obj.orElse(null);
	}

	@Override
	public Page<Contato> findAll(Pageable pageable) {
		return repository.findAll(pageable);
	}

	@Override
	public boolean update(Contato obj) {
		if (repository.existsById(obj.getId())) {
			repository.save(obj);
			return true;
		}
		return false;
	}

	@Override
	public boolean delete(Long id) {
		if (repository.existsById(id)) {
			repository.deleteById(id);
			return true;			
		}
		return false;
	}

	public Long numeroDeContatos() {
		return repository.numeroDeContatos();
	}
	
	public Page<Contato> findByNome(Pageable pageable, String nome) {
		return repository.findByNomeContainingOrderByNome(pageable, nome);
	}
	
	public Page<Contato> findByEmail(Pageable pageable, String email) {
		return repository.findByEmailContainingOrderByEmail(pageable, email);
	}

}
