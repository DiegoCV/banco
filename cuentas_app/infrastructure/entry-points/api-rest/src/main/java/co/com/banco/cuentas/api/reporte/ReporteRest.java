package co.com.banco.cuentas.api.reporte;
import co.com.banco.cuentas.api.movimiento.model.MovimientoResponse;
import co.com.banco.cuentas.api.reporte.model.ReporteRequest;
import co.com.banco.cuentas.model.reporte.Reporte;
import co.com.banco.cuentas.usecase.reporte.ReporteUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/api/reportes", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class ReporteRest {

    private final ReporteUseCase reporteUseCase;

    @PostMapping
    public ResponseEntity<List<Reporte>> generarReporte(@RequestBody ReporteRequest reporte) {
        List<Reporte> reportes = reporteUseCase.generarReportesPorRangoFechas(UUID.fromString(reporte.getClienteId()),
                null, null);
        return  new ResponseEntity<List<Reporte>>(reportes, HttpStatus.OK);
    }
}
