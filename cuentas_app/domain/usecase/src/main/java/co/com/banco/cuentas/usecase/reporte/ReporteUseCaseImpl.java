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
import java.util.stream.Collectors;

import static co.com.banco.cuentas.model.movimiento.common.MovimientoConstans.RETIRO;

@RequiredArgsConstructor
public class ReporteUseCaseImpl implements ReporteUseCase {

    private final ClienteRabbitRepository clienteRabbitRepository;
    private final CuentaUseCase cuentaUseCase;
    private final MovimientoUseCase movimientoUseCase;

    @Override
    public List<Reporte> generarReportesPorRangoFechas(UUID clienteId, Date fechaInicio, Date FechaFin) {
        ClienteReply clienteReply = clienteRabbitRepository.buscarClienteById(clienteId);
        List<Reporte> reportes = cuentaUseCase.generateReporte(clienteId);
        return reportes.stream().map(reporte -> {
            reporte.setCliente(clienteReply.getNombre());
            return reporte;
        }).collect(Collectors.toList());
    }

    private Double validarValorMovimiento(Movimiento m){
        Double valor = m.getValor();
        if(m.getTipo().equalsIgnoreCase(RETIRO)){
            valor = valor * -1;
        }

        return valor;
    }
}
