package co.com.banco.cuentas.model.reporte;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder(toBuilder = true)
public class Reporte {
    private Date fecha;
    private String cliente;
    private Long numeroCuenta;
    private String tipo;
    private Double saldoInicial;
    private boolean estado;
    private Double movimiento;
    private Double saldoDisponible;

    public Reporte(Date fecha,
                   String cliente, long numeroCuenta, String tipo, double saldoInicial, boolean estado,
                   double movimiento, double saldoDisponible) {
        this.fecha = fecha;
        this.cliente = cliente;
        this.numeroCuenta = numeroCuenta;
        this.tipo = tipo;
        this.saldoInicial = saldoInicial;
        this.estado = estado;
        this.movimiento = movimiento;
        this.saldoDisponible = saldoDisponible;
    }
}
