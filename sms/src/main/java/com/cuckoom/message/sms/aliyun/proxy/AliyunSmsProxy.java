package com.cuckoom.message.sms.aliyun.proxy;

import com.aliyun.tea.TeaException;
import com.cuckoom.message.sms.aliyun.model.AliyunSms;
import com.cuckoom.message.sms.aliyun.model.AliyunSmsContext;
import com.cuckoom.message.sms.aliyun.model.AliyunSmsResult;
import com.cuckoom.message.sms.core.proxy.SmsProxy;

import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;

/**
 * 阿里云短信发送代理
 * @author cuckooM
 */
public class AliyunSmsProxy implements SmsProxy<AliyunSms, AliyunSmsContext, AliyunSmsResult> {

    /** 阿里云短信上下文 */
    private AliyunSmsContext context = null;

    @Nullable
    @Override
    public AliyunSmsContext getContext() {
        return context;
    }

    @Override
    public void setContext(@Nonnull AliyunSmsContext context) {
        this.context = context;
    }

    @Nonnull
    @Override
    public AliyunSmsResult send(@Nonnull AliyunSmsContext context, @Nonnull AliyunSms sms) {
        try {
            com.aliyun.dysmsapi20170525.Client client = AliyunSmsProxy.createClient(context);
            com.aliyun.dysmsapi20170525.models.SendSmsRequest sendSmsRequest = new com.aliyun.dysmsapi20170525.models.SendSmsRequest()
                    .setPhoneNumbers(sms.getPhoneNumber())
                    .setSignName(sms.getSignName())
                    .setTemplateCode(sms.getTemplateCode())
                    .setTemplateParam(sms.getTemplateParam())
                    .setSmsUpExtendCode("");
            com.aliyun.teautil.models.RuntimeOptions runtime = new com.aliyun.teautil.models.RuntimeOptions();
            com.aliyun.dysmsapi20170525.models.SendSmsResponse resp = client.sendSmsWithOptions(sendSmsRequest, runtime);
        } catch (TeaException error) {
            System.out.println(error.getMessage());
            System.out.println(error.getData().get("Recommend"));
            com.aliyun.teautil.Common.assertAsString(error.message);
        } catch (Exception _error) {
            TeaException error = new TeaException(_error.getMessage(), _error);
            System.out.println(error.getMessage());
            System.out.println(error.getData().get("Recommend"));
            com.aliyun.teautil.Common.assertAsString(error.message);
        }
        return null;
    }

    /**
     * 使用AK&SK初始化账号 Client
     * @return Client 客户端
     * @throws Exception 异常
     */
    private static com.aliyun.dysmsapi20170525.Client createClient(@Nonnull AliyunSmsContext context)
            throws Exception {
        com.aliyun.teaopenapi.models.Config config = new com.aliyun.teaopenapi.models.Config()
                .setAccessKeyId(context.getAccessKeyId())
                .setAccessKeySecret(context.getAccessKeySecret());
        return new com.aliyun.dysmsapi20170525.Client(config);
    }

}
