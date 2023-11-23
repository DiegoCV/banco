package co.com.banco.cuentas.api.movimiento;

import co.com.banco.cuentas.api.movimiento.model.MovimientoRequest;
import co.com.banco.cuentas.api.movimiento.model.MovimientoResponse;
import co.com.banco.cuentas.model.cuenta.Cuenta;
import co.com.banco.cuentas.model.movimiento.Movimiento;
import co.com.banco.cuentas.usecase.movimiento.MovimientoUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/movimientos", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class MovimientoRest {

    private final MovimientoUseCase movimientoUseCase;

    @PostMapping
    public ResponseEntity<MovimientoResponse> crearMovimiento(@RequestBody MovimientoRequest movimientoRequest) {
        Movimiento movimiento = movimientoUseCase.crearMovimiento(movimientoFromRequest(movimientoRequest));
        return new ResponseEntity<MovimientoResponse>(MovimientoResponse.builder().id(movimiento.getId()).build(),
                HttpStatus.OK);
    }

    private Movimiento movimientoFromRequest(MovimientoRequest movimientoRequest){
        return Movimiento.builder().tipo(movimientoRequest.getTipo()).valor(movimientoRequest.getValor())
                .cuenta(Cuenta.builder().id(movimientoRequest.getCuenta().getId()).build()).build();
    }
}
