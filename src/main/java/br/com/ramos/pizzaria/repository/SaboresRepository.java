package br.com.ramos.pizzaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ramos.pizzaria.model.Sabores;

public interface SaboresRepository extends JpaRepository<Sabores, Long> {

}
