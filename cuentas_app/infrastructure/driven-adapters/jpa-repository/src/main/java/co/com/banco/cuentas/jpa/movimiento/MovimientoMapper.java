package co.com.banco.cuentas.jpa.movimiento;

import co.com.banco.cuentas.jpa.helper.SimpleMapper;
import co.com.banco.cuentas.model.movimiento.Movimiento;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MovimientoMapper extends SimpleMapper<Movimiento, MovimientoData> {
}
