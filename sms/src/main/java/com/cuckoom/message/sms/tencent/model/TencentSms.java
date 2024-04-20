package com.cuckoom.message.sms.tencent.model;

import com.cuckoom.message.sms.core.model.Sms;
import com.cuckoom.message.sms.tencent.proxy.TencentSmsProxy;

import jakarta.annotation.Nonnull;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;

/**
 * 腾讯云短信
 * @author cuckooM
 */
@Getter
@Setter
public class TencentSms implements Sms {

    @Serial
    private static final long serialVersionUID = 1482878222436456592L;

    /** 获取接收短信的手机号码 */
    private String[] phoneNumbers;

    /** 短信签名 */
    private String signName;

    /** 短信模板 ID */
    private String templateId;

    /** 短信模板变量参数 */
    private String[] templateParams;

    @Override
    @Nonnull
    public String getProxy() {
        return TencentSmsProxy.class.getName();
    }

}
