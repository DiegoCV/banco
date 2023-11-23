package co.com.banco.personas.jpa.persona;

import co.com.banco.personas.jpa.helper.SimpleMapper;
import co.com.banco.personas.model.persona.Persona;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PersonaMapper extends SimpleMapper<Persona, PersonaData> {
}
