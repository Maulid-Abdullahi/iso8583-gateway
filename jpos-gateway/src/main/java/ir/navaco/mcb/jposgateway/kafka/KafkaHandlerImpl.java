package ir.navaco.mcb.jposgateway.kafka;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ir.navaco.mcb.jposgateway.enums.KafkaConstant;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

public class KafkaHandlerImpl implements KafkaHandler {

//    private KafkaTemplate<String, Message1100> kafkaTemplate = new KafkaConfiguration().kafkaTemplateM1100();

    private String topicQueueName = KafkaConstant.MESSAGE_1100_QUEUE_NAME;// = QueueConstant.getQueueName(1100);

    private KafkaProducer<String, String> producer;
    private Gson gson = new GsonBuilder().create();

    private static final String TAG = "KafkaHandlerMessage1100";
    private Logger logger = LoggerFactory.getLogger(TAG);

    private Properties producerProperties() {
        String serializer = StringSerializer.class.getName();
        Properties config = new Properties();
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, serializer);
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, serializer);
        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, KafkaConstant.BOOTSTRAP_SERVER);
        logger.info("Configuration for Kafka Producer had been set.");
        return config;
    }

    private void createProducer(){
        this.producer = new KafkaProducer<String, String>(this.producerProperties());
        logger.info("Producer had been created.");
    }

    private void putToQueue(String topic, String key, String value) throws ExecutionException, InterruptedException {
        createProducer();
        ProducerRecord<String, String> producerRecord = new ProducerRecord<>(topic, key, value);
        this.producer.send(producerRecord, (recordMetadata, e) -> {
           if (e != null){
               logger.error("Error has been occurred to send message into queue.");
               return;
           }
           logger.info(String.format("Received new mata-data:\ntopic: %s,\npartition: %s\ntimestamp: %d",
                   recordMetadata.topic(), recordMetadata.partition(), recordMetadata.timestamp()));
        }).get();
    }

    private void closeProducer(){
        this.producer.close();
        logger.info("Producer closed.");
    }

    @Override
    public void putObjectToQueue(Object object) {
        logger.info(String.format("Trying to store data to Queue [%s]", topicQueueName));
        try {
            this.putToQueue(topicQueueName, UUID.randomUUID().toString(), gson.toJson(object, object.getClass()));
        } catch (ExecutionException | InterruptedException e) {
            logger.error(e.getMessage());
        } finally {
            this.closeProducer();
        }
        logger.info(String.format("Message1100 had been added to Queue [%s] successfully.", topicQueueName));
    }
}
