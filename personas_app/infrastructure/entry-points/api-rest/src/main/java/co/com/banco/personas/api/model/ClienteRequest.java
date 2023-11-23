package co.com.banco.personas.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import java.util.UUID;

@Validated
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClienteRequest {

    @JsonProperty("persona")
    private PersonaRequest persona;

    @JsonProperty("contrasenna")
    private String contrasenna;

    @JsonProperty("estado")
    private boolean estado;
}
