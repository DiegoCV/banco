package co.com.banco.personas.model.cliente;
import co.com.banco.personas.model.persona.Persona;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder(toBuilder = true)
public class Cliente {
    private UUID id;
    private String contrasenna;
    private Boolean estado;
    private Persona persona;
}
