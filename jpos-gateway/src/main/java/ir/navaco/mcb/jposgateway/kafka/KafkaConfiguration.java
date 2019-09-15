package ir.navaco.mcb.jposgateway.kafka;

import ir.navaco.mcb.jposgateway.parser.pooya.Message1100;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author a.khatamidoost
 * */

@EnableKafka
@Configuration
@PropertySource({"kafka-configuration.properties"})
public class KafkaConfiguration {

    @Value("${navaco.config.kafka.producer.bootstrap-server}")
    private String BOOTSTRAP_SERVER_CONFIG;

    @Value("${navaco.config.kafka.producer.group-id-config}")
    private String GROUP_ID_CONFIG;

    // General bean for producing string in queue

    @Bean
    public ProducerFactory<String, String> producerFactory(){
        Map<String, Object> config = new HashMap<>();
        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVER_CONFIG);
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        return new DefaultKafkaProducerFactory<String, String>(config);
    }

    @Bean
    public KafkaTemplate<String, String> kafkaTemplate(){
        return new KafkaTemplate<>(producerFactory());
    }

    // Beans for producing Message1100 in queue

    @Bean
    public Map<String, Object> getConfigForMessages(){
        Map<String, Object> config = new HashMap<>();
        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVER_CONFIG);
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        return config;
    }

    @Bean
    public ProducerFactory<String, Message1100> producerFactoryM1100(){
        return new DefaultKafkaProducerFactory<String, Message1100>(getConfigForMessages());
    }

    @Bean
    public KafkaTemplate<String, Message1100> kafkaTemplateM1100(){
        return new KafkaTemplate<String, Message1100>(producerFactoryM1100());
    }

}
