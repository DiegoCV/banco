package co.com.banco.personas.model.persona.gateways;

import co.com.banco.personas.model.cliente.Cliente;
import co.com.banco.personas.model.persona.Persona;

import java.util.UUID;

public interface PersonaRepository {
    Persona findById(UUID id);
    Persona save(Persona persona);
}
