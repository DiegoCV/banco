package co.com.banco.personas.usecase.persona;

import co.com.banco.personas.common.PersonaException;
import co.com.banco.personas.model.persona.Persona;
import co.com.banco.personas.model.persona.gateways.PersonaRepository;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

import static co.com.banco.personas.common.CommonExceptionMessages.PERSONA_NO_EXISTE;

@RequiredArgsConstructor
public class PersonaUseCaseImpl implements PersonaUseCase {

    private final PersonaRepository personaRepository;

    @Override
    public Persona findById(UUID uuid) {
        Persona personaById = personaRepository.findById(uuid);
        if (personaById == null){
            throw new PersonaException(PERSONA_NO_EXISTE);
        }
        return personaById;
    }

    @Override
    public Persona crear(Persona persona) {
        return personaRepository.save(persona);
    }
}
