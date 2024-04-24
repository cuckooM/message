package com.cuckoom.message.sms.tencent.model;

import org.jetbrains.annotations.NotNull;

import com.cuckoom.message.sms.core.model.SmsResult;
import com.cuckoom.message.sms.core.model.SmsResultEnum;
import com.tencentcloudapi.sms.v20210111.models.SendSmsResponse;
import com.tencentcloudapi.sms.v20210111.models.SendStatus;

import jakarta.annotation.Nonnull;
import java.io.Serial;

/**
 * 腾讯云短信发送响应结果
 * @author cuckooM
 */
public class TencentSmsResult implements SmsResult {

    @Serial
    private static final long serialVersionUID = 1419486684153138612L;

    /** 结果 */
    private final SmsResultEnum result;

    /** 请求 ID */
    private final String requestId;

    /** 发送结果单项列表 */
    private TencentSmsResultItem[] items;

    /**
     * 构造函数
     * @param sendSmsResponse 腾讯云 SDK 返回的结果
     */
    public TencentSmsResult(@Nonnull SendSmsResponse sendSmsResponse) {
        this.requestId = sendSmsResponse.getRequestId();
        SendStatus[] sendStatusSet = sendSmsResponse.getSendStatusSet();
        if (null == sendStatusSet || sendStatusSet.length == 0) {
            result = SmsResultEnum.FAILED;
            items = new TencentSmsResultItem[0];
        } else {
            result = SmsResultEnum.SUCCEED;
            items = new TencentSmsResultItem[sendStatusSet.length];
            for (SendStatus sendStatus : sendStatusSet) {

            }
        }
    }

    @NotNull
    @Override
    public SmsResultEnum getResult() {
        return result;
    }

}
