package co.com.banco.cuentas.usecase.cuenta;

import co.com.banco.cuentas.model.cuenta.Cuenta;

import java.util.List;
import java.util.UUID;

public interface CuentaUseCase {
    Cuenta crearCuenta(Cuenta cuenta);

    Cuenta actualizarCuenta(Cuenta cuenta);

    void eliminarCuenta(Cuenta cuenta);

    Cuenta findById(UUID cuentaId);

    List<Cuenta> findByClienteId(UUID clienteId);
}