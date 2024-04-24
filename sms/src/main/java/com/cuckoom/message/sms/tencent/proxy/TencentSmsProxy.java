package com.cuckoom.message.sms.tencent.proxy;

import com.cuckoom.message.sms.core.proxy.SmsProxy;
import com.cuckoom.message.sms.tencent.model.TencentSms;
import com.cuckoom.message.sms.tencent.model.TencentSmsContext;
import com.cuckoom.message.sms.tencent.model.TencentSmsResult;
import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;
import com.tencentcloudapi.sms.v20210111.SmsClient;
import com.tencentcloudapi.sms.v20210111.models.SendSmsRequest;
import com.tencentcloudapi.sms.v20210111.models.SendSmsResponse;
import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;

/**
 * 腾讯云短信发送代理
 * @author cuckooM
 */
public class TencentSmsProxy implements SmsProxy<TencentSms, TencentSmsContext, TencentSmsResult> {

    /** 腾讯云短信上下文 */
    private TencentSmsContext context = null;

    @Nullable
    @Override
    public TencentSmsContext getContext() {
        return context;
    }

    @Override
    public void setContext(@Nonnull TencentSmsContext context) {
        this.context = context;
    }

    @Nonnull
    @Override
    public TencentSmsResult send(@Nonnull TencentSmsContext context, @Nonnull TencentSms sms) {
        try {
            Credential cred = new Credential(context.getSecretId(), context.getSecretKey());
            SmsClient client = new SmsClient(cred, context.getRegion());
            SendSmsRequest req = new SendSmsRequest();
            req.setSmsSdkAppId(context.getSdkAppId());

            req.setSignName(sms.getSignName());
            req.setTemplateId(sms.getTemplateId());
            req.setTemplateParamSet(sms.getTemplateParams());
            req.setPhoneNumberSet(sms.getPhoneNumbers());

            SendSmsResponse response = client.SendSms(req);
            System.out.println(SendSmsResponse.toJsonString(response));
            System.out.println(response.getRequestId());
            return new TencentSmsResult(response);

        } catch (TencentCloudSDKException e) {
            e.printStackTrace();
        }

        return null;
    }

}
