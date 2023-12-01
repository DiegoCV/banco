package co.com.banco.cuentas.usecase.cuenta;

import co.com.banco.cuentas.model.common.CuentaException;
import co.com.banco.cuentas.model.cuenta.Cuenta;
import co.com.banco.cuentas.model.cuenta.gateways.CuentaRepository;
import co.com.banco.cuentas.model.reporte.Reporte;
import co.com.banco.cuentas.model.reporte.ReporteConsulta;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;

import static co.com.banco.cuentas.model.common.CommonExceptionMessages.CUENTA_NO_EXISTE;

@RequiredArgsConstructor
public class CuentaUseCaseImpl implements CuentaUseCase {

    private final CuentaRepository cuentaRepository;

    @Override
    public Cuenta crearCuenta(Cuenta cuenta) {
        return cuentaRepository.save(cuenta);
    }

    @Override
    public Cuenta actualizarCuenta(Cuenta cuenta) {
        Cuenta cuentaById = cuentaRepository.findById(cuenta.getId());
        cuentaById.setSaldo(cuenta.getSaldo());
        cuentaById.setEstado(cuenta.getEstado());

        return cuentaRepository.save(cuentaById);
    }

    @Override
    public void eliminarCuenta(Cuenta cuenta) {
        cuentaRepository.delete(cuenta);
    }

    @Override
    public Cuenta findById(UUID cuentaId) {
        Cuenta cuenta = cuentaRepository.findById(cuentaId);
        if(cuenta == null){
            throw new CuentaException(CUENTA_NO_EXISTE);
        }

        return cuenta;
    }

    @Override
    public List<Cuenta> findByClienteId(UUID clienteId) {
        return cuentaRepository.findByClienteId(clienteId);
    }

    @Override
    public List<Reporte> generateReporte(ReporteConsulta reporteConsulta) {
        return cuentaRepository.generateReporte(reporteConsulta);
    }
}
