package co.com.banco.cuentas.api.cuenta.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import java.util.UUID;

@Validated
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CuentaSimpleRequest {
    private UUID id;
}
