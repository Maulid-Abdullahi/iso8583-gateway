package ir.navaco.mcb.jposgateway.parser.pooya;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class Message1200 {
    private Long accountNo; //field 2
    private String RawTXProcessCode;
    private TxProcessCodeType TXProcessCode; //field 3
    private BigDecimal TXAmountAcquire; //field 4
    private String dateExpiration; //field 14 (comes in persian)
    private Date TXReceiveDateTime; //field 17
    private Short merchantType; //field 18 (Pooya Transactions)
    private String posInfo; //field 22
    private FunctionCodeType functionCode; //field 24
    private Long acquireInstituteCode; //field 32
    private Long senderInstituteCode; //field 33
    private String track2Data; //field 35
    private String TXRefRecoverNo; //field 37
    private String TXAcquirePosNumber; //field 41
    private String cardAcquireNumber; //field 42
    private String cardAcquireNameLocation; //field 43
//    private AdditionalTxData additionalData; //field 48
    private String TXCurrency; //field 49
    private String TXCoding; //field 62 (NOTinPooya)
    private String dataRecord;//field 72 (Pooya Transactions)
    private String accountIdentification; //field 102 (Pooya Transactions)
    private String pooyaTxReserved; //field 113 (Pooya Transactions)




}
