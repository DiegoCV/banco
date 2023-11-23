package co.com.banco.cuentas.usecase.movimiento;

import co.com.banco.cuentas.model.cuenta.Cuenta;
import co.com.banco.cuentas.model.movimiento.Movimiento;

public interface OperacionesUseCase {
    Double operarSaldo(Cuenta cuenta, Movimiento movimiento);
}
