package co.com.banco.cuentas.jpa.cuenta;

import co.com.banco.cuentas.jpa.helper.AdapterOperations;
import co.com.banco.cuentas.model.cuenta.Cuenta;
import co.com.banco.cuentas.model.cuenta.gateways.CuentaRepository;
import co.com.banco.cuentas.model.reporte.Reporte;
import co.com.banco.cuentas.model.reporte.ReporteConsulta;
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
        List<CuentaData> cuentasData = repository.findByClienteID(id);
        return cuentasData.stream().map(c -> cuentaMapper.toEntity(c))
                .collect(Collectors.toCollection(ArrayList::new));

    }

    @Override
    public List<Reporte> generateReporte(ReporteConsulta reporteConsulta) {
        return repository.generateReporte(reporteConsulta);
    }
}
