package co.com.banco.personas.usecase.rabbit;

import co.com.banco.personas.model.cliente.Cliente;
import co.com.banco.personas.model.cliente.rabbit.ClienteQuery;
import co.com.banco.personas.model.cliente.rabbit.ClienteReply;
import co.com.banco.personas.usecase.cliente.ClienteUseCase;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class ClienteRabbitRepositoryImpl implements ClienteRabbitRepository{

    private final ClienteUseCase clienteUseCase;

    @Override
    public ClienteReply getClienteById(ClienteQuery clienteQuery) {
        Cliente cliente = clienteUseCase.buscarClienteById(UUID.fromString(clienteQuery.getClienteId()));
        ClienteReply clienteReply = ClienteReply.builder().build();
        if(cliente != null){
            clienteReply.setValid(true);
            clienteReply.setNombre(cliente.getPersona().getNombre());
        }

        return clienteReply;
    }
}
