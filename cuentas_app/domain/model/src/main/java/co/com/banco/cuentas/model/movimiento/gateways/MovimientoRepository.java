package co.com.banco.cuentas.model.movimiento.gateways;

import co.com.banco.cuentas.model.cuenta.Cuenta;
import co.com.banco.cuentas.model.movimiento.Movimiento;

import java.util.List;

public interface MovimientoRepository {
    Movimiento save(Movimiento movimiento);
    List<Movimiento> findByCuenta(Cuenta cuenta);
}
