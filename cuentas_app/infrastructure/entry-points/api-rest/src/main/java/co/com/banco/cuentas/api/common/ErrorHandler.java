package co.com.banco.cuentas.api.common;

import co.com.banco.cuentas.model.common.CuentaException;
import co.com.banco.cuentas.model.common.FormatoFechasExepcion;
import co.com.banco.cuentas.model.common.MovimientoConSaldoNoDisponibleException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(CuentaException.class)
    public ResponseEntity<ErrorInfo> cuentaException(HttpServletRequest request, CuentaException e) {
        ErrorInfo errorInfo = new ErrorInfo(HttpStatus.NOT_FOUND.value(), e.getMessage(), request.getRequestURI());
        return new ResponseEntity<>(errorInfo, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MovimientoConSaldoNoDisponibleException.class)
    public ResponseEntity<ErrorInfo> saldoNoDisponibleException(HttpServletRequest request,
                                                                MovimientoConSaldoNoDisponibleException e) {
        ErrorInfo errorInfo = new ErrorInfo(HttpStatus.NOT_FOUND.value(), e.getMessage(), request.getRequestURI());
        return new ResponseEntity<>(errorInfo, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(FormatoFechasExepcion.class)
    public ResponseEntity<ErrorInfo> formatoFechasExepcion(HttpServletRequest request, FormatoFechasExepcion e) {
        ErrorInfo errorInfo = new ErrorInfo(HttpStatus.NOT_FOUND.value(), e.getMessage(), request.getRequestURI());
        return new ResponseEntity<>(errorInfo, HttpStatus.NOT_FOUND);
    }



}
