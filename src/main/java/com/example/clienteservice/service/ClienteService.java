package com.example.clienteservice.service;

import com.example.clienteservice.exception.BadRequestException;
import com.example.clienteservice.exception.NotFoundException;
import com.example.clienteservice.model.Cliente;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
	public Cliente obtenerCliente(String tipoDocumento, String numeroDocumento) {
        if (!tipoDocumento.equals("C") && !tipoDocumento.equals("P")) {
            throw new BadRequestException("Tipo de documento inválido. Debe ser 'C' o 'P'.");
        }

        if (tipoDocumento.equals("C") && numeroDocumento.equals("23445322")) {
            Cliente cliente = new Cliente();
            cliente.setPrimerNombre("Juan");
            cliente.setSegundoNombre("Carlos");
            cliente.setPrimerApellido("Perez");
            cliente.setSegundoApellido("Gomez");
            cliente.setTelefono("555-1234");
            cliente.setDireccion("Calle Falsa 123");
            cliente.setCiudadResidencia("Bogotá");
            return cliente;
        } else {
            throw new NotFoundException("Cliente no encontrado.");
        }
    }
}
