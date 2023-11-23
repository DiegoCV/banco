package co.com.banco.cuentas.api.reporte.model;

import lombok.*;
import org.springframework.validation.annotation.Validated;

import java.util.Date;

@Validated
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder(toBuilder = true)
public class ReporteResponse {
    private Date fecha;
    private String cliente;
    private String numeroCuenta;
    private String tipo;
    private Double saldoInicial;
    private boolean estado;
    private Double movimiento;
    private Double saldoDisponible;

}
