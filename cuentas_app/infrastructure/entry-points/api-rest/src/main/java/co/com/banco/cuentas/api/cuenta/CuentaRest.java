package co.com.banco.cuentas.api.cuenta;
import co.com.banco.cuentas.api.cuenta.model.CuentaRequest;
import co.com.banco.cuentas.api.cuenta.model.CuentaResponse;
import co.com.banco.cuentas.model.cuenta.Cuenta;
import co.com.banco.cuentas.usecase.cuenta.CuentaUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(value = "/api/cuentas", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class CuentaRest {

    private final CuentaUseCase cuentaUseCase;

    @PostMapping
    public ResponseEntity<CuentaResponse> crearCuenta(@RequestBody CuentaRequest cuentaRequest) {
        Cuenta cuenta = cuentaUseCase.crearCuenta(cuentaFromRequest(cuentaRequest));
        return new ResponseEntity<CuentaResponse>(CuentaResponse.builder().id(cuenta.getId())
                .estado(cuenta.getEstado()).build(), HttpStatus.OK);
    }

    @PutMapping(value = "{cuentaId}")
    public ResponseEntity<CuentaResponse> actualizarCuenta(@PathVariable("cuentaId") UUID cuentaId,
                                                           @RequestBody CuentaRequest cuentaRequest) {
        Cuenta cuenta = cuentaFromRequest(cuentaRequest);
        cuenta.setId(cuentaId);
        Cuenta cuentaActualizada = cuentaUseCase.actualizarCuenta(cuenta);
        return new ResponseEntity<CuentaResponse>(CuentaResponse.builder().id(cuentaActualizada.getId())
                .estado(cuentaActualizada.getEstado()).build(), HttpStatus.OK);
    }

    @DeleteMapping(value = "{cuentaId}")
    public ResponseEntity actualizarCuenta(@PathVariable("cuentaId") UUID cuentaId) {
        cuentaUseCase.eliminarCuenta(Cuenta.builder().id(cuentaId).build());

        return new ResponseEntity(HttpStatus.OK);
    }

    private Cuenta cuentaFromRequest(CuentaRequest cuentaRequest){
        return Cuenta.builder().numero(cuentaRequest.getNumero()).tipo(cuentaRequest.getTipo())
                .saldo(cuentaRequest.getSaldo()).estado(cuentaRequest.getEstado())
                .clienteID(cuentaRequest.getClienteId()).build();
    }
}
