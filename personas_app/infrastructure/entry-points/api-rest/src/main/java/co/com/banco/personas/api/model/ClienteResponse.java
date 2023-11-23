package co.com.banco.personas.api.model;

import lombok.*;
import org.springframework.validation.annotation.Validated;

import java.util.UUID;

@Validated
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder(toBuilder = true)
public class ClienteResponse {
    private UUID id;
    private boolean estado;
}
