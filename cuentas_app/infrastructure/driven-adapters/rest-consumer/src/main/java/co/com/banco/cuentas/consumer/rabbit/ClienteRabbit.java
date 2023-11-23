package co.com.banco.cuentas.consumer.rabbit;

import co.com.banco.cuentas.model.cliente.ClienteQuery;
import co.com.banco.cuentas.model.cliente.ClienteReply;
import co.com.banco.cuentas.model.cliente.gateways.ClienteRabbitRepository;
import lombok.AllArgsConstructor;
import org.reactivecommons.async.api.AsyncQuery;
import org.reactivecommons.async.api.DirectAsyncGateway;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@AllArgsConstructor
public class ClienteRabbit implements ClienteRabbitRepository {

    private final DirectAsyncGateway directAsyncGateway;
    private static final String REQUEST_CLIENTE = "request.cliente";
    private static final String TARGET_PERSONAS = "personas";

    @Override
    public ClienteReply buscarClienteById(UUID id) {
        ClienteQuery query = ClienteQuery.builder().clienteId(id.toString()).build();
        AsyncQuery<ClienteQuery> asyncQuery = new AsyncQuery<>(REQUEST_CLIENTE, query);
        return directAsyncGateway.requestReply(
                asyncQuery, TARGET_PERSONAS, ClienteReply.class).block();
    }

}
