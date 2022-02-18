package br.com.ramos.pizzaria.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ramos.pizzaria.model.Bebidas;
import br.com.ramos.pizzaria.model.Pedidos;
import br.com.ramos.pizzaria.model.Sabores;
import br.com.ramos.pizzaria.repository.BebidasRepository;
import br.com.ramos.pizzaria.repository.PedidosRepository;
import br.com.ramos.pizzaria.repository.SaboresRepository;

@RestController
@RequestMapping("/pedidos")
public class PedidosController {

	@Autowired
	PedidosRepository pedidoRepository;

	@Autowired
	BebidasRepository bebidaRepository;

	@Autowired
	SaboresRepository saboresRepository;

	@GetMapping("/listar")
	public List<Pedidos> listarPedidos() throws Exception {
		try {
			return pedidoRepository.findAll();

		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@GetMapping("/listar/{id}")
	public ResponseEntity<Optional<Pedidos>> listarPedidosPorId(@PathVariable(value = "id") Long id) throws Exception {
		try {
			Optional<Pedidos> pedido = pedidoRepository.findById(id);
			if (pedido.isPresent()) {

				return ResponseEntity.ok(pedidoRepository.findById(id));
			}
			return ResponseEntity.notFound().build();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@GetMapping("/bebidas")
	public ResponseEntity<List<Bebidas>> listarBebidas() throws Exception {
		try {
			return ResponseEntity.ok(bebidaRepository.findAll());
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}

	}
	
	@GetMapping("/sabores")
	public ResponseEntity<List<Sabores>> listarSabores() throws Exception {
		try {
			return ResponseEntity.ok(saboresRepository.findAll());
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@PostMapping("/salvar")
	public ResponseEntity<Pedidos> salvarPedido(@RequestBody Pedidos pedido) throws Exception {
		try {
			return ResponseEntity.ok(pedidoRepository.save(pedido));
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}

	}
	

	@DeleteMapping("/deletar/{id}")

	public boolean deletarPedido(@PathVariable(value = "id") Long id) throws Exception {
		try {
			Optional<Pedidos> pedido = pedidoRepository.findById(id);
			if (pedido.isPresent()) {
				pedidoRepository.deleteById(id);
				return true;
			}
			return false;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	

	@PutMapping("/atualizar")
	public ResponseEntity<Pedidos> atualizarPedido(@RequestBody Pedidos pedido) throws Exception {
		try {
			pedidoRepository.save(pedido);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

}
