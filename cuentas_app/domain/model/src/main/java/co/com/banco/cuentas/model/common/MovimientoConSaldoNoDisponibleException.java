package co.com.banco.cuentas.model.common;

import static co.com.banco.cuentas.model.common.CommonExceptionMessages.SALDO_NO_DISPONIBLE;

public class MovimientoConSaldoNoDisponibleException extends RuntimeException{

    public MovimientoConSaldoNoDisponibleException(){
        super(SALDO_NO_DISPONIBLE);
    }

}
