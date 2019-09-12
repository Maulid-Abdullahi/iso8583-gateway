package ir.navaco.mcb.jposgateway.participates;

import ir.navaco.mcb.jposgateway.parser.pooya.UnpackIsoMessage;
import ir.navaco.mcb.jposgateway.server.ContextConstant;
import org.jpos.iso.ISOMsg;
import org.jpos.transaction.Context;
import org.jpos.transaction.TransactionParticipant;
import org.springframework.beans.factory.annotation.Autowired;

import javax.print.attribute.standard.MediaSize;
import java.io.Serializable;

/**
 * @author a.khatamidoost
 * */
public class DetectorParticipate implements TransactionParticipant {

    @Autowired
    private UnpackIsoMessage unpackIsoMessage;

    @Override
    public int prepare(long l, Serializable serializable) {
        // get message from space
        Context context = (Context) serializable;
        ISOMsg isoMsg = (ISOMsg) context.get(ContextConstant.REQUEST_KEY);

        

        return 0;
    }
}
