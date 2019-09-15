package ir.navaco.mcb.jposgateway.kafka;

import ir.navaco.mcb.jposgateway.enums.QueueConstant;

import java.io.Serializable;

public interface KafkaHandler extends Serializable {
    void putObjectToQueue (Object object);
}
