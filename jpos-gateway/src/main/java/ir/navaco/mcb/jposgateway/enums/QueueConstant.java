package ir.navaco.mcb.jposgateway.enums;

import lombok.Data;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author a.khatamidoost
 */
public enum QueueConstant {

    MS1100(1, 1100, "MCB.NAVACO.JPOS.M1100");

    private Integer id;
    private Integer code;
    private String queueName;

    QueueConstant(Integer id, Integer code, String queueName) {
        this.id = id;
        this.code = code;
        this.queueName = queueName;
    }

    public static QueueConstant findByCode(Integer code) {
        return Arrays.stream(values())
                .filter(queueConstant -> queueConstant.code.equals(code))
                .findFirst()
                .get();
    }

    public static String getQueueName(Integer code){
        return Arrays.stream(values()).filter(queueConstant -> queueConstant.code == code).findFirst().get().queueName;
    }
}
