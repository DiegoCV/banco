package co.com.banco.cuentas.usecase.movimiento;

import co.com.banco.cuentas.model.cuenta.Cuenta;
import co.com.banco.cuentas.model.movimiento.Movimiento;

import java.util.List;

public interface MovimientoUseCase {
    Movimiento crearMovimiento(Movimiento movimiento);
    List<Movimiento> findByCuenta(Cuenta cuenta);
}
