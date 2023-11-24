package co.com.banco.cuentas.jpa.cuenta;

import co.com.banco.cuentas.jpa.helper.AdapterOperations;
import co.com.banco.cuentas.model.cuenta.Cuenta;
import co.com.banco.cuentas.model.cuenta.gateways.CuentaRepository;
import co.com.banco.cuentas.model.reporte.Reporte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class CuentaDataRepositoryAdapter extends AdapterOperations<Cuenta, CuentaData, UUID, CuentaDataRepository>
            implements CuentaRepository {

    @Autowired
    CuentaMapper cuentaMapper;

    public CuentaDataRepositoryAdapter(CuentaDataRepository repository, CuentaMapper cuentaMapper) {
        super(repository, cuentaMapper);
    }

    @Override
    public void delete(Cuenta cuenta) {
        repository.delete(cuentaMapper.toData(cuenta));
    }

    @Override
    public List<Cuenta> findByClienteId(UUID id) {
        //select m.fecha, c.numero, c.tipo, m.saldo, c.estado, m.valor, c.saldo  from cuenta c
        //left outer join movimiento m
        //on c.id = m.cuenta_id
        //where c.cliente_id = 'd5044cd5-cb30-4a98-bcbc-639a41e868b5';
        List<CuentaData> cuentasData = repository.findByClienteID(id);
        return cuentasData.stream().map(c -> cuentaMapper.toEntity(c))
                .collect(Collectors.toCollection(ArrayList::new));

    }

    @Override
    public List<Reporte> generateReporte(UUID clienteID) {
        return repository.generateReporte(clienteID);
    }
}
