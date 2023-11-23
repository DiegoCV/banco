package co.com.banco.personas.jpa.cliente;

import co.com.banco.personas.jpa.helper.SimpleMapper;
import co.com.banco.personas.model.cliente.Cliente;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClienteMapper extends SimpleMapper<Cliente, ClienteData> {
}
