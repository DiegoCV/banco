package co.com.banco.cuentas.api.reporte;
import co.com.banco.cuentas.api.common.util.FechaUtil;
import co.com.banco.cuentas.api.reporte.model.ReporteRequest;
import co.com.banco.cuentas.model.reporte.Reporte;
import co.com.banco.cuentas.model.reporte.ReporteConsulta;
import co.com.banco.cuentas.usecase.reporte.ReporteUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import static co.com.banco.cuentas.api.common.util.UtilConstantes.FECHA_FIN;
import static co.com.banco.cuentas.api.common.util.UtilConstantes.FECHA_INICIAL;

@RestController
@RequestMapping(value = "/api/reportes", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class ReporteRest {

    private final ReporteUseCase reporteUseCase;
    private final FechaUtil fechaUtil;

    @PostMapping
    public ResponseEntity<List<Reporte>> generarReporte(@RequestParam(name="fecha", required=true) String fecha,
                                                        @RequestBody ReporteRequest reporte) {
        Map<String, Date> rangoFechas = fechaUtil.parsearFechas(fecha);
        ReporteConsulta reporteConsulta = ReporteConsulta.builder().clienteID(UUID.fromString(reporte.getClienteId()))
                .fechaInicial(rangoFechas.get(FECHA_INICIAL)).fechaFinal(rangoFechas.get(FECHA_FIN)).build();
        List<Reporte> reportes = reporteUseCase.generarReportesPorRangoFechas(reporteConsulta);

        return new ResponseEntity<List<Reporte>>(reportes, HttpStatus.OK);
    }
}
