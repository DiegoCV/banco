package co.com.banco.personas.model.cliente.gateways;

import co.com.banco.personas.model.cliente.Cliente;

import java.util.UUID;

public interface ClienteRepository {

    Cliente findById(UUID id);
    Cliente save(Cliente cliente);
    void delete(Cliente cliente);
}
