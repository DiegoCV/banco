package co.com.banco.personas.usecase.rabbit;

import co.com.banco.personas.model.cliente.rabbit.ClienteQuery;
import co.com.banco.personas.model.cliente.rabbit.ClienteReply;

public interface ClienteRabbitRepository {
    ClienteReply getClienteById(ClienteQuery clienteQuery);
}
