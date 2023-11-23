package co.com.banco.personas.jpa.cliente;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import java.util.UUID;

public interface ClienteDataRepository extends CrudRepository<ClienteData, UUID>, QueryByExampleExecutor<ClienteData> {
}
