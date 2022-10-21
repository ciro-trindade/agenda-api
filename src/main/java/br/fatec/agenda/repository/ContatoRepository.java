package br.fatec.agenda.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.fatec.agenda.model.Contato;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Long> {
	@Query("select count(c) from Contato c")
	Long numeroDeContatos();
	
	Page<Contato> findByNomeContainingOrderByNome(Pageable pageable, String nome);

	Page<Contato> findByEmailContainingOrderByEmail(Pageable pageable, String email);

}
