package com.cuckoom.message.sms.tencent.model;

import java.io.Serial;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * 腾讯云短信发送响应结果单项
 * @author cuckooM
 */
@Getter
@Setter
public class TencentSmsResultItem implements Serializable {
    @Serial
    private static final long serialVersionUID = -3756621636783131224L;

    private String serialNo;
    private String phoneNumber;
    private Long fee;
    private String sessionContext;
    private String code;
    private String message;
    private String isoCode;
}
