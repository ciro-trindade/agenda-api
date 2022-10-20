package br.fatec.agenda.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface ControllerInterface<T> {
	ResponseEntity<Page<T>> getAll(Pageable pageable);
	ResponseEntity<T> get(Long id);
	ResponseEntity<T> post(T obj);
	ResponseEntity<T> put(T obj);
	ResponseEntity<Void> delete(Long id);
}
