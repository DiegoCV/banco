package co.com.banco.personas.config;

import co.com.banco.personas.model.cliente.gateways.ClienteRepository;
import co.com.banco.personas.model.persona.gateways.PersonaRepository;
import co.com.banco.personas.usecase.cliente.ClienteUseCase;
import co.com.banco.personas.usecase.cliente.ClienteUseCaseImpl;
import co.com.banco.personas.usecase.persona.PersonaUseCase;
import co.com.banco.personas.usecase.persona.PersonaUseCaseImpl;
import co.com.banco.personas.usecase.rabbit.ClienteRabbitRepository;
import co.com.banco.personas.usecase.rabbit.ClienteRabbitRepositoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(basePackages = "co.com.banco.personas.usecase",
        includeFilters = {
                @ComponentScan.Filter(type = FilterType.REGEX, pattern = "^.+UseCase$")
        },
        useDefaultFilters = false)
public class UseCasesConfig {

        @Bean
        public PersonaUseCase personaUseCase(PersonaRepository personaRepository){
                return new PersonaUseCaseImpl(personaRepository);
        }

        @Bean
        public ClienteUseCase clienteUseCase(PersonaUseCase personaUseCase, ClienteRepository clienteRepository){
                return new ClienteUseCaseImpl(personaUseCase, clienteRepository);
        }

        @Bean
        public ClienteRabbitRepository clienteRabbitRepository(ClienteUseCase clienteUseCase){
             return new ClienteRabbitRepositoryImpl(clienteUseCase);
        }

}
