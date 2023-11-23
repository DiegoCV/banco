package co.com.banco.personas.api;
import co.com.banco.personas.api.model.ClienteRequest;
import co.com.banco.personas.api.model.ClienteResponse;
import co.com.banco.personas.api.model.PersonaRequest;
import co.com.banco.personas.model.cliente.Cliente;
import co.com.banco.personas.model.persona.Persona;
import co.com.banco.personas.usecase.cliente.ClienteUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(value = "/api/clientes", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class ApiRest {

    private final ClienteUseCase clienteUseCase;

    @PostMapping
    public ResponseEntity<ClienteResponse> crearCliente(@RequestBody ClienteRequest clienteRequest) {
        Cliente cliente = clienteUseCase.crearCliente(armarClienteFromRequest(clienteRequest));
        ClienteResponse clienteResponse = ClienteResponse.builder().id(cliente.getId())
                .estado(cliente.getEstado()).build();

        return new ResponseEntity<ClienteResponse>(clienteResponse, HttpStatus.OK);
    }

    @PutMapping(value = "/{clienteId}")
    public ResponseEntity<ClienteResponse> actualizarCliente(@PathVariable("clienteId") UUID clienteId,
                                                             @RequestBody ClienteRequest clienteRequest) {
        Cliente cliente = armarClienteFromRequest(clienteRequest);
        cliente.setId(clienteId);
        Cliente clienteActualizado = clienteUseCase.actualizarCliente(cliente);
        ClienteResponse clienteResponse = ClienteResponse.builder().id(clienteActualizado.getId())
                .estado(clienteActualizado.getEstado()).build();

        return new ResponseEntity<ClienteResponse>(clienteResponse, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{clienteId}")
    public ResponseEntity eliminarCliente(@PathVariable("clienteId") UUID clienteId) {
        clienteUseCase.eliminarCliente(Cliente.builder().id(clienteId).build());

        return new ResponseEntity(HttpStatus.OK);
    }

    private Cliente armarClienteFromRequest(ClienteRequest clienteRequest){
        Cliente cliente = Cliente.builder().contrasenna(clienteRequest.getContrasenna())
                .estado(clienteRequest.isEstado()).build();
        if(clienteRequest.getPersona() != null) {
            cliente.setPersona(armarPersonaFromRequest(clienteRequest.getPersona()));
        }

        return cliente;
    }

    private Persona armarPersonaFromRequest(PersonaRequest personaRequest){
        return Persona.builder().direccion(personaRequest.getDireccion()).edad(personaRequest.getEdad())
                .genero(personaRequest.getGenero()).identificacion(personaRequest.getIdentificacion())
                .nombre(personaRequest.getNombre()).telefono(personaRequest.getTelefono()).build();

    }
}
