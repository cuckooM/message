package com.cuckoom.message.sms.properties;


import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 腾讯云短信配置
 */
@ConfigurationProperties(prefix = "cuckoom.sms.tencent")
@Getter
@Setter
public class TecentProperties {

    /** 秘钥 ID */
    private String secretId;

    /** 秘钥 */
    private String secretKey;

    /** APP ID */
    private String sdkAppId;

    /** 区域 */
    private String region;

    /** 短信签名 */
    private String signName;

    /** 模板 ID */
    private String templateId;

    /** 模板参数 */
    private String[] templateParams;

    /** 手机号码 */
    private String[] phoneNumbers;

}
