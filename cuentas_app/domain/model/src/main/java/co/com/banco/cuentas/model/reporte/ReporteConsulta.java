package co.com.banco.cuentas.model.reporte;

import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
@Builder(toBuilder = true)
public class ReporteConsulta {
    private UUID clienteID;
    private String clienteNombre;
    private Date fechaInicial;
    private Date fechaFinal;
}
