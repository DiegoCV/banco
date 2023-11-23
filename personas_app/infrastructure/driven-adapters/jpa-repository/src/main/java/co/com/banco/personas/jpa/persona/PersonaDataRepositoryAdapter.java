package co.com.banco.personas.jpa.persona;

import co.com.banco.personas.jpa.helper.AdapterOperations;
import co.com.banco.personas.model.persona.Persona;
import co.com.banco.personas.model.persona.gateways.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class PersonaDataRepositoryAdapter extends
        AdapterOperations<Persona, PersonaData, UUID, PersonaDataRepository>
        implements PersonaRepository {

    @Autowired
    PersonaMapper personaMapper;

    public PersonaDataRepositoryAdapter(PersonaDataRepository repository, PersonaMapper personaMapper) {
        super(repository, personaMapper);
    }
}
