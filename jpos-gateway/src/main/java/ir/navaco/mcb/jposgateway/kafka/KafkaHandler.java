package ir.navaco.mcb.jposgateway.kafka;

import ir.navaco.mcb.jposgateway.enums.QueueConstant;

import java.io.Serializable;

@FunctionalInterface
public interface KafkaHandler extends Serializable {
    void putObjectToQueue (Object object, QueueConstant queueConstant);
}
