package co.com.banco.cuentas.usecase.reporte;

import co.com.banco.cuentas.model.reporte.Reporte;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public interface ReporteUseCase {

    List<Reporte> generarReportesPorRangoFechas(UUID clienteId, Date fechaInicio, Date FechaFin);

}
