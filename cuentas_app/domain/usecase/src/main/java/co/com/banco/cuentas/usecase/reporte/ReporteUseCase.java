package co.com.banco.cuentas.usecase.reporte;

import co.com.banco.cuentas.model.reporte.Reporte;
import co.com.banco.cuentas.model.reporte.ReporteConsulta;

import java.util.List;

public interface ReporteUseCase {

    List<Reporte> generarReportesPorRangoFechas(ReporteConsulta reporteConsulta);

}
