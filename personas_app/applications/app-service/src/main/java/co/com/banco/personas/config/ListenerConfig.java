package co.com.banco.personas.config;

import co.com.banco.personas.model.cliente.rabbit.ClienteQuery;
import co.com.banco.personas.model.cliente.rabbit.ClienteReply;
import co.com.banco.personas.usecase.rabbit.ClienteRabbitRepository;
import lombok.RequiredArgsConstructor;
import org.reactivecommons.async.api.HandlerRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Mono;

@Configuration
@RequiredArgsConstructor
public class ListenerConfig {

    private static final String REQUEST_CLIENTE = "request.cliente";
    private final ClienteRabbitRepository clienteRabbitRepository;

    @Bean
    public HandlerRegistry handlerRegistry() {
        return HandlerRegistry.register()
                .serveQuery(REQUEST_CLIENTE, this::getCliente, ClienteQuery.class);
    }

    public Mono<ClienteReply> getCliente(ClienteQuery query) {
        ClienteReply reply = clienteRabbitRepository.getClienteById(query);
        return Mono.just(reply);
    }
}
