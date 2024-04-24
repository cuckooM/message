package com.cuckoom.message.sms.aliyun.model;

import com.cuckoom.message.sms.core.model.SmsResult;
import com.cuckoom.message.sms.core.model.SmsResultEnum;

import jakarta.annotation.Nonnull;

/**
 * 阿里云短信发送响应结果
 * @author cuckooM
 */
public class AliyunSmsResult implements SmsResult {

    @Nonnull
    @Override
    public SmsResultEnum getResult() {
        return null;
    }

}
