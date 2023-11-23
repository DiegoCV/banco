package co.com.banco.personas.api.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

@Validated
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PersonaRequest {
    private String nombre;
    private String genero;
    private Long edad;
    private String identificacion;
    private String direccion;
    private String telefono;
}
