package co.com.banco.cuentas.config;

import co.com.banco.cuentas.consumer.rabbit.ClienteRabbit;
import co.com.banco.cuentas.model.cliente.gateways.ClienteRabbitRepository;
import co.com.banco.cuentas.model.cuenta.gateways.CuentaRepository;
import co.com.banco.cuentas.model.movimiento.gateways.MovimientoRepository;
import co.com.banco.cuentas.usecase.cuenta.CuentaUseCase;
import co.com.banco.cuentas.usecase.cuenta.CuentaUseCaseImpl;
import co.com.banco.cuentas.usecase.movimiento.MovimientoUseCase;
import co.com.banco.cuentas.usecase.movimiento.MovimientoUseCaseImpl;
import co.com.banco.cuentas.usecase.movimiento.OperacionesUseCase;
import co.com.banco.cuentas.usecase.movimiento.OperacionesUseCaseImpl;
import co.com.banco.cuentas.usecase.reporte.ReporteUseCase;
import co.com.banco.cuentas.usecase.reporte.ReporteUseCaseImpl;
import org.reactivecommons.async.api.DirectAsyncGateway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(basePackages = "co.com.banco.cuentas.usecase",
        includeFilters = {
                @ComponentScan.Filter(type = FilterType.REGEX, pattern = "^.+UseCase$")
        },
        useDefaultFilters = false)
public class UseCasesConfig {

        @Bean
        public CuentaUseCase cuentaUseCase(CuentaRepository cuentaRepository){
             return new CuentaUseCaseImpl(cuentaRepository);
        }

        @Bean
        public OperacionesUseCase operacionesUseCase(){
            return new OperacionesUseCaseImpl();
        }

        @Bean
        public MovimientoUseCase movimientoUseCase(CuentaUseCase cuentaUseCase,
                                                   OperacionesUseCase operacionesUseCase,
                                                   MovimientoRepository movimientoRepository){
            return new MovimientoUseCaseImpl(cuentaUseCase, operacionesUseCase, movimientoRepository);
        }

        @Bean
        public ClienteRabbitRepository clienteRabbitRepository(DirectAsyncGateway directAsyncGateway){
            return new ClienteRabbit(directAsyncGateway);
        }

        @Bean
        public ReporteUseCase reporteUseCase(ClienteRabbitRepository clienteRabbitRepository,
                                             CuentaUseCase cuentaUseCase){
            return new ReporteUseCaseImpl(clienteRabbitRepository, cuentaUseCase);
        }
}
