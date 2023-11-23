package co.com.banco.personas.jpa.cliente;

import co.com.banco.personas.jpa.helper.AdapterOperations;
import co.com.banco.personas.model.cliente.Cliente;
import co.com.banco.personas.model.cliente.gateways.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class ClienteDataRepositoryAdapter extends AdapterOperations<Cliente, ClienteData, UUID, ClienteDataRepository>
        implements ClienteRepository {

    @Autowired
    ClienteMapper clienteMapper;

    public ClienteDataRepositoryAdapter(ClienteDataRepository repository, ClienteMapper clienteMapper) {
        super(repository, clienteMapper);
    }

    @Override
    public void delete(Cliente cliente) {
        repository.delete(clienteMapper.toData(cliente));
    }
}