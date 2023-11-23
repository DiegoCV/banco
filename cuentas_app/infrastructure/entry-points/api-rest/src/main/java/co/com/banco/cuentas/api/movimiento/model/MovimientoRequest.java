package co.com.banco.cuentas.api.movimiento.model;

import co.com.banco.cuentas.api.cuenta.model.CuentaRequest;
import co.com.banco.cuentas.api.cuenta.model.CuentaSimpleRequest;
import co.com.banco.cuentas.model.cuenta.Cuenta;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

@Validated
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MovimientoRequest {
    private String tipo;
    private Double valor;
    private CuentaSimpleRequest cuenta;
}
