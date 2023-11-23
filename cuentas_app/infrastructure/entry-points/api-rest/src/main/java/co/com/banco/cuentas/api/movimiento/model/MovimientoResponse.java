package co.com.banco.cuentas.api.movimiento.model;

import lombok.*;
import org.springframework.validation.annotation.Validated;

import java.util.UUID;

@Validated
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder(toBuilder = true)
public class MovimientoResponse {
    private UUID id;
}
