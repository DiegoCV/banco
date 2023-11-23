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
public class CuentaRequest {
    private Long numero;
    private String tipo;
    private Double saldo;
    private Boolean estado;
    private UUID clienteId;
}
