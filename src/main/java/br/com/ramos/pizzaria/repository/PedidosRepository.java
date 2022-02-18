package br.com.ramos.pizzaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ramos.pizzaria.model.Pedidos;

public interface PedidosRepository extends JpaRepository<Pedidos, Long> {



	
}
