package com.cuckoom.message.sms.aliyun.model;

import com.cuckoom.message.sms.aliyun.proxy.AliyunSmsProxy;
import com.cuckoom.message.sms.core.model.SmsContext;

import jakarta.annotation.Nonnull;
import lombok.Getter;
import lombok.Setter;

/**
 * 阿里云短信上下文。用于短信平台信息的传递。
 * @author cuckooM
 */
@Getter
@Setter
public class AliyunSmsContext implements SmsContext {

    /** 访问密钥 ID */
    private String accessKeyId;

    /** 访问密钥密码 */
    private String accessKeySecret;

    /** 访问端点 */
    private String endpoint;

    @Nonnull
    @Override
    public String getProxy() {
        return AliyunSmsProxy.class.getName();
    }

}
