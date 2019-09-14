package ir.navaco.mcb.jposgateway.parser.pooya;

import ir.navaco.mcb.jposgateway.enums.MessageType;
import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author a.khatamidoost
 * */
@Component
public class UnpackIsoMessage {

    public MessageType parseISOMessage(ISOMsg isoMsg){
        try {
            return MessageType.findByCode(Integer.parseInt(isoMsg.getMTI()));
        } catch (ISOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
