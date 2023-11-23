package co.com.banco.personas.usecase.cliente;

import co.com.banco.personas.common.ClienteException;
import co.com.banco.personas.model.cliente.Cliente;
import co.com.banco.personas.model.cliente.gateways.ClienteRepository;
import co.com.banco.personas.model.persona.Persona;
import co.com.banco.personas.usecase.persona.PersonaUseCase;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

import static co.com.banco.personas.common.CommonExceptionMessages.CLIENTE_NO_EXISTE;

@RequiredArgsConstructor
public class ClienteUseCaseImpl implements ClienteUseCase{

    private final PersonaUseCase personaUseCase;
    private final ClienteRepository clienteRepository;

    @Override
    public Cliente crearCliente(Cliente cliente) {
        Persona persona = personaUseCase.crear(cliente.getPersona());
        cliente.setPersona(persona);

        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente actualizarCliente(Cliente cliente) {
        Cliente clienteById = clienteRepository.findById(cliente.getId());
        if(clienteById == null){
            throw new ClienteException(CLIENTE_NO_EXISTE);
        }
        clienteById.setContrasenna(cliente.getContrasenna());
        clienteById.setEstado(cliente.getEstado());

        return clienteRepository.save(clienteById);
    }

    @Override
    public void eliminarCliente(Cliente cliente) {
        clienteRepository.delete(cliente);
    }

    @Override
    public Cliente buscarClienteById(UUID id) {
        return clienteRepository.findById(id);
    }
}
