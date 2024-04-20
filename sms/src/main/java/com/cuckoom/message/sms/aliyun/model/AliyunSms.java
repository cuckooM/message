package com.cuckoom.message.sms.aliyun.model;

import com.cuckoom.message.sms.aliyun.proxy.AliyunSmsProxy;
import com.cuckoom.message.sms.core.model.Sms;

import jakarta.annotation.Nonnull;
import java.io.Serial;
import lombok.Getter;
import lombok.Setter;

/**
 * 阿里云短信
 * @author cuckooM
 */
@Getter
@Setter
public class AliyunSms implements Sms {

    @Serial
    private static final long serialVersionUID = 8663136154735499248L;

    /** 获取接收短信的手机号码 */
    private String phoneNumber;

    /** 短信签名 */
    private String signName;

    /** 短信模板编码 */
    private String templateCode;

    /** 短信模板变量参数 */
    private String templateParam;

    @Nonnull
    @Override
    public String getProxy() {
        return AliyunSmsProxy.class.getName();
    }
}
