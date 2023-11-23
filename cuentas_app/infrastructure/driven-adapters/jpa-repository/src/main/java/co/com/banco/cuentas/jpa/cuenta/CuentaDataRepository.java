package co.com.banco.cuentas.jpa.cuenta;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import java.util.List;
import java.util.UUID;

public interface CuentaDataRepository extends CrudRepository<CuentaData, UUID>, QueryByExampleExecutor<CuentaData> {
    List<CuentaData> findByClienteID(UUID clienteID);
}
