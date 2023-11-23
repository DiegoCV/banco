package co.com.banco.cuentas.jpa.cuenta;

import co.com.banco.cuentas.jpa.helper.SimpleMapper;
import co.com.banco.cuentas.model.cuenta.Cuenta;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CuentaMapper extends SimpleMapper<Cuenta, CuentaData> {
}
