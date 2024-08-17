package com.example.clienteservice.controller;

import com.example.clienteservice.model.Cliente;
import com.example.clienteservice.service.ClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
	
	private final ClienteService clienteService;
	
	public ClienteController(ClienteService clienteService) {
		this.clienteService = clienteService;
	}
	
	@GetMapping("/{tipoDocumento}/{numeroDocumento}")
	public ResponseEntity<Cliente> obtenerCliente(
			@PathVariable String tipoDocumento,
			@PathVariable String numeroDocumento) {
		
		Cliente cliente = clienteService.obtenerCliente(tipoDocumento, numeroDocumento);
		return ResponseEntity.ok(cliente);
		
	}
}
