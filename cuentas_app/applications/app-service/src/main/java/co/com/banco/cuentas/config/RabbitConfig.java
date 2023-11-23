package co.com.banco.cuentas.config;

import com.rabbitmq.client.ConnectionFactory;
import org.reactivecommons.async.rabbit.config.ConnectionFactoryProvider;
import org.reactivecommons.async.rabbit.config.RabbitProperties;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class RabbitConfig {

    @Value("${rabbit.host}")
    private String host;

    @Value("${rabbit.port}")
    private int port;

    @Value("${rabbit.secret.region}")
    private String secretRegion;

    @Value("${rabbit.secret.name}")
    private String secretName;

    @Bean
    @Primary
    public RabbitProperties rabbitProperties(){
        RabbitProperties rabbitProperties = new RabbitProperties();
        rabbitProperties.setHost(host);
        rabbitProperties.setPort(port);
        rabbitProperties.setUsername(secretRegion);
        rabbitProperties.setPassword(secretName);
        return rabbitProperties;
    }

    @Bean
    public ConnectionFactoryProvider connectionTest(RabbitProperties rabbitProperties) {
        return () -> connectionGlobal(rabbitProperties);
    }

    public ConnectionFactory connectionGlobal(RabbitProperties rabbitProperties){
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost(rabbitProperties.getHost());
        connectionFactory.setPort(rabbitProperties.getPort());
        connectionFactory.setUsername(rabbitProperties.getUsername());
        connectionFactory.setPassword(rabbitProperties.getPassword());
        return connectionFactory;
    }

}
