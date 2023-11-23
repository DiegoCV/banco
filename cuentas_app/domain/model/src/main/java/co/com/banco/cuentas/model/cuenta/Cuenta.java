package co.com.banco.cuentas.model.cuenta;
import co.com.banco.cuentas.model.movimiento.Movimiento;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Builder(toBuilder = true)
public class Cuenta {
    private UUID id;
    private Long numero;
    private String tipo;
    private Double saldo;
    private Boolean estado;
    private UUID clienteID;
    private List<Movimiento> movimientos;
}
