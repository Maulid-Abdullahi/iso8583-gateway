package ir.navaco.mcb.jposgateway.parser.pooya;

import lombok.Data;
import org.jpos.iso.ISOMsg;

import java.util.Date;

@Data
public class Message1110 {
    private Long accountNo; //field 2
    private TxProcessCodeType TXProcessCode; //field 3
    private String RawTXProcessCode;
    private Date TXSettlementDate; //field 15
    private Long acquireInstituteCode; //field 32
    private Long senderInstituteCode; //field 33
    private String TXRefRecoverNo; //field 37
    private String TXApprovalCode; //field 38
    private TxProcessStatusType TXResponseCode; //field 39
    private String TXAcquirePosNumber; //field 41
    private String cardAcquireNumber; //field 42
    private String responseExtraData; //field 44
    private String extraAmount; //field 54
    private String TXCoding; //field 62
    private String receiverInstituteCode; //field 100

    public Message1110(ISOMsg isoMsg){

    }
}
