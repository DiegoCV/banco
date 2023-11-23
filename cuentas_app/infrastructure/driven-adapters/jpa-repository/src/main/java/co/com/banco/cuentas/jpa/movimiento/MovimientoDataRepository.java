package co.com.banco.cuentas.jpa.movimiento;

import co.com.banco.cuentas.jpa.cuenta.CuentaData;
import co.com.banco.cuentas.model.cuenta.Cuenta;
import co.com.banco.cuentas.model.movimiento.Movimiento;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import java.util.List;
import java.util.UUID;

public interface MovimientoDataRepository extends CrudRepository<MovimientoData, UUID>,
        QueryByExampleExecutor<MovimientoData> {

    List<MovimientoData> findByCuenta(CuentaData cuenta);
}
