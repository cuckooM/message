package com.cuckoom.message.sms.core.model;

import jakarta.annotation.Nonnull;
import java.io.Serializable;

/**
 * 短信发送响应结果
 * @author cuckooM
 */
public interface SmsResult extends Serializable {

    /**
     * 发送结果
     * @return 结果
     */
    @Nonnull
    SmsResultEnum getResult();

}
