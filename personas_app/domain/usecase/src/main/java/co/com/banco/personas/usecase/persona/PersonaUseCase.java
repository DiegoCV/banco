package co.com.banco.personas.usecase.persona;

import co.com.banco.personas.model.persona.Persona;

import java.util.UUID;

public interface PersonaUseCase {
    Persona findById(UUID uuid);
    Persona crear(Persona persona);
}
