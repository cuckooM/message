package com.cuckoom.message.sms.tencent.model;

import com.cuckoom.message.sms.core.model.SmsContext;
import com.cuckoom.message.sms.tencent.proxy.TencentSmsProxy;

import jakarta.annotation.Nonnull;
import lombok.Getter;
import lombok.Setter;

/**
 * 腾讯云短信上下文。用于短信平台信息的传递。
 * @author cuckooM
 */
@Getter
@Setter
public class TencentSmsContext implements SmsContext {

    /** 秘钥 ID */
    private String secretId;

    /** 秘钥 */
    private String secretKey;

    /** 应用 ID */
    private String sdkAppId;

    /** 区域 */
    private String region;

    @Nonnull
    @Override
    public String getProxy() {
        return TencentSmsProxy.class.getName();
    }

}
