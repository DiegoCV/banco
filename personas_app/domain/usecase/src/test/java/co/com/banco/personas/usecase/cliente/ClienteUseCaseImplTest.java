package co.com.banco.personas.usecase.cliente;

import co.com.banco.personas.model.cliente.Cliente;
import co.com.banco.personas.model.cliente.gateways.ClienteRepository;
import co.com.banco.personas.usecase.persona.PersonaUseCase;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@AllArgsConstructor
class ClienteUseCaseImplTest {

    @InjectMocks
    @Spy
    private ClienteUseCaseImpl clienteUseCaseImpl;

    @Mock
    private PersonaUseCase personaUseCase;

    @Mock
    private ClienteRepository clienteRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void actualizarCliente() {
        UUID uuid = UUID.randomUUID();
        Cliente cliente = Cliente.builder().id(uuid).contrasenna("123").estado(false).build();
        Cliente clienteResponse = Cliente.builder().id(uuid).build();
        Mockito.doReturn(clienteResponse).when(clienteRepository).save(any());
        Cliente clienteTest = clienteUseCaseImpl.actualizarCliente(cliente);
        assertEquals(uuid, clienteTest.getId());
    }
}