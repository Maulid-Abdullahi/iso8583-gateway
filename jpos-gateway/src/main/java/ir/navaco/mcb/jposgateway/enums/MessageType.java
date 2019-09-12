package ir.navaco.mcb.jposgateway.enums;


import lombok.Data;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 *
 * @author a.khatamidoost
 * */

@Data
public enum MessageType {

    /**
     * درخواست تاییدیه و بررسی
     */
    MTI_1100(0, 1100, MessageType.messageType1100),
    /**
     * پاسخ به درخواست تاییدیه و بررسی
     */
    MTI_1110(1, 1110, MessageType.messageType1110),
    /**
     * درخواست انجام تراکنش مالی
     */
    MTI_1200(2, 1200, MessageType.messageType1200),
    /**
     * پاسخ به درخواست انجام تراکنش مالی
     */
    MTI_1210(3, 1210, MessageType.messageType1210),
    /**
     * تایید انجام تراکنش مالی
     */
    MTI_1220(4, 1220, MessageType.messageType1220),
    /**
     * پاسخ به تایید انجام تراکنش مالی
     */
    MTI_1230(5, 1230, MessageType.messageType1230),
    /**
     * درخواست اصلاحیه تراکنش مالی
     */
    MTI_1420(6, 1420, MessageType.messageType1420),
    /**
     * پاسخ به درخواست اصلاحیه تراکنش مالی
     */
    MTI_1430(7, 1430, MessageType.messageType1430),
    /**
     * تراکنش مدیریت شبکه
     */
    MTI_1804(8, 1804, MessageType.messageType1804),
    /**
     * پاسخ تراکنش مدیریت شبکه
     */
    MTI_1814(9, 1814, MessageType.messageType1814);

    private static final String messageType1100 = "CC.MessageType.messageType1100";
    private static final String messageType1110 = "CC.MessageType.messageType1110";
    private static final String messageType1200 = "CC.MessageType.messageType1200";
    private static final String messageType1210 = "CC.MessageType.messageType1210";
    private static final String messageType1220 = "CC.MessageType.messageType1220";
    private static final String messageType1230 = "CC.MessageType.messageType1230";
    private static final String messageType1420 = "CC.MessageType.messageType1420";
    private static final String messageType1430 = "CC.MessageType.messageType1430";
    private static final String messageType1804 = "CC.MessageType.messageType1804";
    private static final String messageType1814 = "CC.MessageType.messageType1814";

    private Integer id;
    private Integer code;
    private String title;

    MessageType(Integer id, Integer code, String title){
        this.id = id;
        this.code = code;
        this.title = title;
    }

    public static MessageType findByCode(Integer code){
        return Arrays
                .stream(values())
                .filter(messageType -> messageType.code.equals(code))
                .findFirst().orElse(null);
    }
}
