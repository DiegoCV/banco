package co.com.banco.cuentas.api.common.util;

import co.com.banco.cuentas.model.common.FormatoFechasExepcion;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static co.com.banco.cuentas.api.common.util.UtilConstantes.FECHA_FIN;
import static co.com.banco.cuentas.api.common.util.UtilConstantes.FECHA_INICIAL;
import static co.com.banco.cuentas.api.common.util.UtilConstantes.SEPARADOR_FECHAS;
import static co.com.banco.cuentas.api.common.util.UtilConstantes.FORMAT_FECHA;
import static co.com.banco.cuentas.model.common.CommonExceptionMessages.ERROR_CON_FECHA;

@Component
public class FechaUtil {

    public Map<String, Date> parsearFechas(String fechas){
        Map<String, Date> dateMap = new HashMap<>();
        String[] datePairs = fechas.split(SEPARADOR_FECHAS);
        SimpleDateFormat dateFormat = new SimpleDateFormat(FORMAT_FECHA);
        String startDateStr = datePairs[0];
        String endDateStr = datePairs[1];
        try {
            Date startDate = dateFormat.parse(startDateStr);
            Date endDate = dateFormat.parse(endDateStr);
            dateMap.put(FECHA_INICIAL, startDate);
            dateMap.put(FECHA_FIN, endDate);
        } catch (ParseException e) {
            throw new FormatoFechasExepcion(ERROR_CON_FECHA);
        }

        return dateMap;
    }
}
