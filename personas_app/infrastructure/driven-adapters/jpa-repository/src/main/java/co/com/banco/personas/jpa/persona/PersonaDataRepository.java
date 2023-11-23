package co.com.banco.personas.jpa.persona;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import java.util.UUID;

public interface PersonaDataRepository extends CrudRepository<PersonaData, UUID>, QueryByExampleExecutor<PersonaData> {
}
