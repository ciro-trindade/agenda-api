package br.fatec.agenda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.fatec.agenda.model.Contato;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Long> {

}
