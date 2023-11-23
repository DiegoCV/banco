package co.com.banco.cuentas.api.cuenta.model;

import lombok.*;
import org.springframework.validation.annotation.Validated;

import java.util.UUID;

@Validated
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder(toBuilder = true)
public class CuentaResponse {
    private UUID id;
    private Boolean estado;
}
