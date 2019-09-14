package ir.navaco.mcb.jposgateway.participates;

import com.google.gson.GsonBuilder;
import ir.navaco.mcb.jposgateway.enums.MessageType;
import ir.navaco.mcb.jposgateway.kafka.KafkaHandler;
import ir.navaco.mcb.jposgateway.parser.pooya.Message1100;
import ir.navaco.mcb.jposgateway.parser.pooya.UnpackIsoMessage;
import ir.navaco.mcb.jposgateway.server.ContextConstant;
import org.jpos.iso.ISOMsg;
import org.jpos.transaction.Context;
import org.jpos.transaction.TransactionParticipant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.print.attribute.standard.MediaSize;
import java.io.Serializable;
import java.text.ParseException;

/**
 * @author a.khatamidoost
 */
public class DetectorParticipate implements TransactionParticipant {

    @Autowired
    private UnpackIsoMessage unpackIsoMessage;

    private static final String TAG = "DetectorParticipate";
    private Logger logger = LoggerFactory.getLogger(TAG);

    @Override
    public int prepare(long l, Serializable serializable) {
        // get message from space
        Context context = (Context) serializable;
        ISOMsg isoMsg = (ISOMsg) context.get(ContextConstant.REQUEST_KEY);

        MessageType messageType = unpackIsoMessage.parseISOMessage(isoMsg);
        switch (messageType) {
            case MTI_1100: putMessage1100ToQueue(isoMsg);
        }

        return 0;
    }

    private void putMessage1100ToQueue(ISOMsg isoMsg) {
        try {
            Message1100 message1100 = new Message1100(isoMsg);
            KafkaHandler kafkaHandler = ((object, queueConstant) -> {
                String jsonString = new GsonBuilder().create().toJson(object, object.getClass());

            });
        } catch (ParseException e) {
            logger.error(e.getMessage());
        }
    }
}
