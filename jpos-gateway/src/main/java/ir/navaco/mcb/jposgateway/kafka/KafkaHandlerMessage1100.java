package ir.navaco.mcb.jposgateway.kafka;

import ir.navaco.mcb.jposgateway.parser.pooya.Message1100;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaHandlerMessage1100 implements KafkaHandler {

    private KafkaTemplate<String, Message1100> kafkaTemplate;

    @Autowired
    public KafkaHandlerMessage1100(KafkaTemplate<String, Message1100> kafkaTemplate){
        this.kafkaTemplate = kafkaTemplate;
    }

    @Value("${navaco.config.kafka.producer.queue.message1100}")
    private String topicQueueName;

    private static final String TAG = "KafkaHandlerMessage1100";
    private Logger logger = LoggerFactory.getLogger(TAG);

    @Override
    public void putObjectToQueue(Object object) {
        logger.info(String.format("Trying to store data to Queue [%s]", topicQueueName));
        kafkaTemplate.send(topicQueueName, (Message1100) object);
        logger.info(String.format("Message1100 had been added to Queue [%s] successfully.", topicQueueName));
    }
}
