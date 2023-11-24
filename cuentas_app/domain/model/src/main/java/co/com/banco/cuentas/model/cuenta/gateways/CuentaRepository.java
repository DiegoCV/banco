package co.com.banco.cuentas.model.cuenta.gateways;

import co.com.banco.cuentas.model.cuenta.Cuenta;
import co.com.banco.cuentas.model.reporte.Reporte;

import java.util.List;
import java.util.UUID;

public interface CuentaRepository {
    Cuenta save(Cuenta cuenta);
    Cuenta findById(UUID id);
    void delete(Cuenta cuenta);
    List<Cuenta> findByClienteId(UUID id);
    List<Reporte> generateReporte(UUID clienteID);
}
