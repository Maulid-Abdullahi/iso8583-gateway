package ir.navaco.mcb.jposgateway.kafka;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.ConsumerFactory;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaConfiguration {

    @Value("${navaco.config.kafka.consumer.bootstrap-server}")
    private String BOOTSTRAP_SERVER_CONFIG;

    @Bean
    public ConsumerFactory<Object, Object> consumerFactory(){
        Map<Object, Object> config = new HashMap<>();
        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVER_CONFIG);

    }
}
