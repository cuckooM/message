package com.cuckoom.message.sms.core.model;

import jakarta.annotation.Nonnull;

/**
 * 短信上下文。用于短信平台信息的传递。
 * @author cuckooM
 */
public interface SmsContext {

    /**
     * 获取短信发送代理
     * @return 短信发送代理
     */
    @Nonnull
    String getProxy();

}
