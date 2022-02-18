package br.com.ramos.pizzaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ramos.pizzaria.model.Bebidas;

public interface BebidasRepository extends JpaRepository<Bebidas, Long> {

}
