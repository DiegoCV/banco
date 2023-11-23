package co.com.banco.cuentas.model.movimiento;
import co.com.banco.cuentas.model.cuenta.Cuenta;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
@Builder(toBuilder = true)
public class Movimiento {
    private UUID id;
    private Date fecha;
    private String tipo;
    private Double valor;
    private Double saldo;
    private Cuenta cuenta;
}
