package co.com.banco.personas.model.persona;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder(toBuilder = true)
public class Persona {
    private UUID id;
    private String nombre;
    private String genero;
    private Long edad;
    private String identificacion;
    private String direccion;
    private String telefono;
}
