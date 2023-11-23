package co.com.banco.personas.usecase.cliente;

import co.com.banco.personas.model.cliente.Cliente;

import java.util.UUID;

public interface ClienteUseCase {
    Cliente crearCliente(Cliente cliente);
    Cliente actualizarCliente(Cliente cliente);
    void eliminarCliente(Cliente cliente);
    Cliente buscarClienteById(UUID id);
}
