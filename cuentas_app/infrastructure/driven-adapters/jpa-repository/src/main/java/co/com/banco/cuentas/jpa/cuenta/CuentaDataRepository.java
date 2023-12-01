package co.com.banco.cuentas.jpa.cuenta;

import co.com.banco.cuentas.model.reporte.Reporte;
import co.com.banco.cuentas.model.reporte.ReporteConsulta;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import java.util.List;
import java.util.UUID;

public interface CuentaDataRepository extends CrudRepository<CuentaData, UUID>, QueryByExampleExecutor<CuentaData> {
    List<CuentaData> findByClienteID(UUID clienteID);

    @Query(value =
            "SELECT new co.com.banco.cuentas.model.reporte.Reporte( " +
                    "m.fecha, c.tipo, c.numero, c.tipo, m.saldo, c.estado, " +
                    "CASE WHEN m.tipo = 'retiro' THEN -m.valor ELSE m.valor END, c.saldo)  " +
            "FROM CuentaData c " +
            "LEFT OUTER JOIN MovimientoData m " +
            "ON c.id = m.cuenta.id " +
            "WHERE c.clienteID = :#{#consulta.clienteID} " +
            "AND m.fecha BETWEEN :#{#consulta.fechaInicial} AND :#{#consulta.fechaFinal}")
    List<Reporte> generateReporte(@Param("consulta") ReporteConsulta reporteConsulta);
}
