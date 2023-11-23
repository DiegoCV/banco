package co.com.banco.cuentas.model.cliente.gateways;

import co.com.banco.cuentas.model.cliente.ClienteReply;

import java.util.UUID;

public interface ClienteRabbitRepository {
    ClienteReply buscarClienteById(UUID id);
}
