package com.cuckoom.message.sms.core.model;

import jakarta.annotation.Nonnull;

import java.io.Serializable;

/**
 * 短信实体
 * @author cuckooM
 */
public interface Sms extends Serializable {

    /**
     * 获取短信发送代理
     * @return 短信发送代理
     */
    @Nonnull
    String getProxy();

}
