package ir.navaco.mcb.jposgateway.parser.pooya;

import lombok.Data;
import org.jpos.iso.ISOMsg;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.ParseException;
import java.util.Date;

@Data
public class Message1100 {
    private Long accountNo; //field 2
    private TxProcessCodeType TXProcessCode; //field 3
    private String RawTXProcessCode;
    private Date TXReceiveDateTime; //field 17
    private String posInfo; //field 22
    private FunctionCodeType functionCode; //field 24
    private Short acquireBusinessType; //field 26
    private Long acquireInstituteCode; //field 32
    private Long senderInstituteCode; //field 33
    private String TXRefRecoverNo; //field 37
    private String TXAcquirePosNumber; //field 41
    private String cardAcquireNumber; //field 42
    private String cardAcquireNameLocation; //field 43
    private String specialExtraData; //field 48
    private String TXCoding; //field 62
    private String receiverInstituteCode; //field 100

    @Autowired
    private ParserHelper parserHelper;

    public Message1100(ISOMsg isoMsg) throws ParseException {
        this.accountNo = Long.parseLong(isoMsg.getString(2));
        this.TXProcessCode = TxProcessCodeType.findByCode(Long.parseLong(isoMsg.getString(3)));
        this.RawTXProcessCode = isoMsg.getString(3);
        this.TXReceiveDateTime = ParserHelper.parseDate(isoMsg.getString(17), "MMdd");
        this.posInfo = isoMsg.getString(22);
        this.functionCode = FunctionCodeType.findByCode(Integer.parseInt(isoMsg.getString(24)));
        this.acquireBusinessType = Short.parseShort(isoMsg.getString(26));
        this.acquireInstituteCode = Long.parseLong(isoMsg.getString(32));
        this.senderInstituteCode = Long.parseLong(isoMsg.getString(33));
        this.TXRefRecoverNo = isoMsg.getString(37);
        this.TXAcquirePosNumber = isoMsg.getString(41);
        this.cardAcquireNumber = isoMsg.getString(42);
        this.cardAcquireNameLocation = isoMsg.getString(43);
        this.specialExtraData = isoMsg.getString(48);
        this.TXCoding = isoMsg.getString(62);
        this.receiverInstituteCode = isoMsg.getString(100);
    }
}
