package co.com.banco.cuentas.usecase.reporte;

import co.com.banco.cuentas.model.cliente.ClienteReply;
import co.com.banco.cuentas.model.cliente.gateways.ClienteRabbitRepository;
import co.com.banco.cuentas.model.cuenta.Cuenta;
import co.com.banco.cuentas.model.movimiento.Movimiento;
import co.com.banco.cuentas.model.reporte.Reporte;
import co.com.banco.cuentas.usecase.cuenta.CuentaUseCase;
import co.com.banco.cuentas.usecase.movimiento.MovimientoUseCase;
import lombok.RequiredArgsConstructor;

import java.util.*;

import static co.com.banco.cuentas.model.movimiento.common.MovimientoConstans.RETIRO;

@RequiredArgsConstructor
public class ReporteUseCaseImpl implements ReporteUseCase {

    private final ClienteRabbitRepository clienteRabbitRepository;
    private final CuentaUseCase cuentaUseCase;
    private final MovimientoUseCase movimientoUseCase;

    @Override
    public List<Reporte> generarReportesPorRangoFechas(UUID clienteId, Date fechaInicio, Date FechaFin) {
        // Este reporte sale facilmente con un query,
        // está escrito en el repo pero no implementado
        // como me quedé sin tiempo me da más facil hacerlo de esta manera
        ClienteReply clienteReply = clienteRabbitRepository.buscarClienteById(clienteId);
        List<Cuenta> cuentas = cuentaUseCase.findByClienteId(clienteId);
        List<Reporte> reportes = new ArrayList<>();
        for (Cuenta c: cuentas) {
            List<Movimiento> movimientos = movimientoUseCase.findByCuenta(c);
            for (Movimiento m: movimientos) {
                reportes.add(Reporte.builder()
                        .fecha(m.getFecha())
                        .cliente(clienteReply.getNombre())
                        .numeroCuenta(c.getNumero()).tipo(c.getTipo()).saldoInicial(m.getSaldo()).estado(c.getEstado())
                        .movimiento(validarValorMovimiento(m)).saldoDisponible(c.getSaldo())
                        .build());
            }
        }
        return reportes;
    }

    private Double validarValorMovimiento(Movimiento m){
        Double valor = m.getValor();
        if(m.getTipo().equalsIgnoreCase(RETIRO)){
            valor = valor * -1;
        }

        return valor;
    }
}
