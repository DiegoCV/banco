package co.com.banco.cuentas.jpa.movimiento;

import co.com.banco.cuentas.jpa.cuenta.CuentaData;
import co.com.banco.cuentas.jpa.helper.AdapterOperations;
import co.com.banco.cuentas.model.cuenta.Cuenta;
import co.com.banco.cuentas.model.movimiento.Movimiento;
import co.com.banco.cuentas.model.movimiento.gateways.MovimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class MovimientoDataRepositoryAdapter extends AdapterOperations<Movimiento, MovimientoData, UUID, MovimientoDataRepository>
        implements MovimientoRepository {

    @Autowired
    MovimientoMapper movimientoMapper;

    public MovimientoDataRepositoryAdapter(MovimientoDataRepository repository, MovimientoMapper movimientoMapper) {
        super(repository, movimientoMapper);
    }

    @Override
    public List<Movimiento> findByCuenta(Cuenta cuenta) {
        List<MovimientoData> byCuenta = repository.findByCuenta(CuentaData.builder().id(cuenta.getId()).build());
        return byCuenta.stream().map(c -> movimientoMapper.toEntity(c))
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
